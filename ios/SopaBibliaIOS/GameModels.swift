import Foundation

// Native iOS models. These decode the same editorial JSON files as the Android APK;
// the 300-level corpus and public-domain RV1909 are not rewritten for iPhone.
struct CampaignCatalog: Decodable {
    let worlds: [BibleWorld]
    let levels: [BibleLevel]
}
struct BibleWorld: Decodable, Identifiable {
    let world: Int
    let id: String
    let name: String
    let boardSize: Int
    var identifier: Int { world }
}
struct WordReference: Decodable {
    let word: String
    let initial: String
    let clue: String
    let reference: String
}
struct MysterySpec: Decodable {
    let word: String
    let clue: String
    let reference: String
}
struct BibleLevel: Decodable, Identifiable {
    let level: Int
    let world: Int
    let title: String
    let topic: String
    let reference: String
    let learningMessage: String
    let boardSize: Int
    let kind: String
    let words: [String]
    let wordHints: [WordReference]
    let mystery: MysterySpec?
    var id: Int { level }
}
struct FreeMysteries: Decodable { let layouts: [FreeMystery] }
struct FreeMystery: Decodable {
    let categoryId: String
    let world: Int
    let size: Int
    let words: [String]
    let mystery: MysterySpec
}
struct BibleIndex: Decodable { let books: [BibleBook] }
struct BibleBook: Decodable, Identifiable {
    let id: String
    let name: String
    let chapterCount: Int
}
struct BibleBookText: Decodable {
    let id: String
    let name: String
    let chapters: [String: [String: String]]
}
struct BibleLocation: Equatable {
    let book: BibleBook
    let chapter: Int
    let verse: Int
}

enum DataFailure: Error, LocalizedError {
    case resource(String)
    var errorDescription: String? {
        switch self { case .resource(let file): return "No se encuentra el recurso bíblico: \(file)" }
    }
}

final class BibleLibrary: ObservableObject {
    @Published private(set) var catalog: CampaignCatalog?
    @Published private(set) var freeMysteries: [FreeMystery] = []
    @Published private(set) var books: [BibleBook] = []
    @Published private(set) var loadError: String?
    @Published private(set) var completed: Set<Int> = []

    private var cachedBooks: [String: BibleBookText] = [:]
    private let progressKey = "sopabiblia.ios.completed.levels.v1"

    init() {
        completed = Set(UserDefaults.standard.array(forKey: progressKey) as? [Int] ?? [])
        do {
            catalog = try decode(CampaignCatalog.self, name: "levels-v1", subdirectory: "campaign/es-ES")
            freeMysteries = try decode(FreeMysteries.self, name: "free_mystery_sizes_v1", subdirectory: "campaign/es-ES").layouts
            books = try decode(BibleIndex.self, name: "index", subdirectory: "rv1909").books
            guard catalog?.levels.count == 300 && freeMysteries.count == 30 && books.count == 66 else {
                throw DataFailure.resource("catálogo, misterios o biblioteca incompletos")
            }
        } catch {
            loadError = error.localizedDescription
        }
    }

    private func decode<T: Decodable>(_ type: T.Type, name: String, subdirectory: String) throws -> T {
        guard let url = Bundle.main.url(forResource: name, withExtension: "json", subdirectory: subdirectory) else {
            throw DataFailure.resource("\(subdirectory)/\(name).json")
        }
        return try JSONDecoder().decode(T.self, from: Data(contentsOf: url))
    }

    var nextLevel: Int {
        (1...300).first(where: { !completed.contains($0) }) ?? 300
    }

    func complete(level: Int) {
        guard (1...300).contains(level) else { return }
        completed.insert(level)
        UserDefaults.standard.set(completed.sorted(), forKey: progressKey)
    }

    func level(_ number: Int) -> BibleLevel? {
        catalog?.levels.first(where: { $0.level == number })
    }

    func freeMystery(world: BibleWorld, size: Int) -> FreeMystery? {
        freeMysteries.first(where: { $0.categoryId == world.id && $0.size == size })
    }

    func hints(for world: Int) -> [String: WordReference] {
        Dictionary(
            (catalog?.levels ?? [])
                .filter { $0.world == world }
                .flatMap { $0.wordHints }
                .map { ($0.word, $0) },
            uniquingKeysWith: { _, newest in newest }
        )
    }

    func chapter(book: BibleBook, chapter: Int) -> [(Int, String)] {
        if cachedBooks[book.id] == nil,
           let data: BibleBookText = try? decode(BibleBookText.self, name: book.id, subdirectory: "rv1909") {
            cachedBooks[book.id] = data
        }
        let verses = cachedBooks[book.id]?.chapters[String(chapter)] ?? [:]
        return verses.compactMap { key, text in Int(key).map { ($0, text) } }
            .sorted { $0.0 < $1.0 }
    }

    func parseReference(_ reference: String) -> BibleLocation? {
        let regex = try? NSRegularExpression(pattern: #"^(.+?)\s+(\d+)(?::(\d+))?"#)
        let ns = reference as NSString
        guard let m = regex?.firstMatch(in: reference, range: NSRange(location: 0, length: ns.length)),
              let bookRange = Range(m.range(at: 1), in: reference),
              let chapterRange = Range(m.range(at: 2), in: reference),
              let ch = Int(reference[chapterRange]) else { return nil }
        let rawBook = String(reference[bookRange])
        let wanted = normalize(rawBook)
        guard let book = books.first(where: {
            let candidate = normalize($0.name)
            return candidate == wanted || candidate.hasSuffix(" " + wanted) || wanted.hasSuffix(" " + candidate)
        }) else { return nil }
        var verse = 1
        if m.range(at: 3).location != NSNotFound,
           let verseRange = Range(m.range(at: 3), in: reference) {
            verse = Int(reference[verseRange]) ?? 1
        }
        return BibleLocation(book: book, chapter: ch, verse: verse)
    }

    private func normalize(_ str: String) -> String {
        str.folding(options: [.diacriticInsensitive, .caseInsensitive], locale: Locale(identifier: "es_ES"))
            .lowercased().trimmingCharacters(in: .whitespacesAndNewlines)
    }
}

struct FoundWord: Identifiable {
    let word: String
    let cells: [Int]
    var id: String { word }
}
struct PuzzleBoard {
    let size: Int
    let letters: [String]
    let words: [FoundWord]
}

enum GridFailure: Error, LocalizedError {
    case noLayout
    var errorDescription: String? { "No se pudo generar una sopa de letras para este nivel." }
}

struct GameRandom {
    private var state: UInt64
    init(seed: UInt64) { state = seed == 0 ? 1 : seed }
    mutating func next(_ upper: Int) -> Int {
        state = state &* 6364136223846793005 &+ 1442695040888963407
        return Int((state >> 32) % UInt64(max(upper, 1)))
    }
}

enum GridGenerator {
    static let allDirections: [(Int, Int)] = [
        (0, 1), (1, 0), (1, 1), (0, -1), (-1, 0),
        (-1, -1), (1, -1), (-1, 1)
    ]
    static func directions(for size: Int) -> [(Int, Int)] {
        switch size {
        case ...6: return Array(allDirections.prefix(2))
        case 7...8: return Array(allDirections.prefix(3))
        case 9...10: return Array(allDirections.prefix(5))
        default: return allDirections
        }
    }

    static func make(words: [String], size: Int, seed: UInt64, requiresCrossing: Bool = false) throws -> PuzzleBoard {
        guard size >= 6 && size <= 12 && !words.isEmpty,
              words.count == Set(words).count,
              words.allSatisfy({ (3...size).contains($0.count) }) else {
            throw GridFailure.noLayout
        }
        let dirs = directions(for: size)
        for attempt in 0..<220 {
            var rng = GameRandom(seed: seed &+ UInt64(attempt) &* 977)
            var letters: [Character?] = Array(repeating: nil, count: size * size)
            var placed: [FoundWord] = []
            // Long words first, with varied tie order. This reduces failed dense layouts.
            let indexed = words.map { ($0, rng.next(1000000)) }
            let ordered = indexed.sorted {
                $0.0.count == $1.0.count ? $0.1 < $1.1 : $0.0.count > $1.0.count
            }.map(\.0)

            for word in ordered {
                let chars = Array(word)
                var best: [Int]?
                var bestCrossings = -1
                for _ in 0..<600 {
                    let dir = dirs[rng.next(dirs.count)]
                    let row = rng.next(size), col = rng.next(size)
                    let finalRow = row + dir.0 * (chars.count - 1)
                    let finalCol = col + dir.1 * (chars.count - 1)
                    if !(0..<size).contains(finalRow) || !(0..<size).contains(finalCol) { continue }
                    var candidate: [Int] = []
                    var crossings = 0, possible = true
                    for i in chars.indices {
                        let idx = (row + dir.0 * i) * size + col + dir.1 * i
                        if let old = letters[idx] {
                            if old != chars[i] { possible = false; break }
                            crossings += 1
                        }
                        candidate.append(idx)
                    }
                    if possible && crossings > bestCrossings {
                        best = candidate
                        bestCrossings = crossings
                        if crossings >= 2 { break }
                    }
                }
                guard let path = best else { break }
                for (i, cell) in path.enumerated() { letters[cell] = chars[i] }
                placed.append(FoundWord(word: word, cells: path))
            }
            if placed.count != words.count { continue }
            if requiresCrossing && crossingWords(placed) < 2 { continue }

            let alphabet = Array("AAAAAEEEIIIOOOURSTNLCDPMBGVÑ")
            let filled = letters.map { String($0 ?? alphabet[rng.next(alphabet.count)]) }
            // Ensure only one geometrical occurrence of each requested word.
            if !placed.allSatisfy({ occurrences(of: $0.word, in: filled, size: size) == 1 }) { continue }
            return PuzzleBoard(size: size, letters: filled, words: placed)
        }
        throw GridFailure.noLayout
    }

    static func crossingWords(_ words: [FoundWord]) -> Int {
        var counts: [Int: Int] = [:]
        for word in words { for cell in word.cells { counts[cell, default: 0] += 1 } }
        return words.filter { word in word.cells.contains { counts[$0, default: 0] > 1 } }.count
    }

    static func occurrences(of word: String, in letters: [String], size: Int) -> Int {
        let chars = Array(word).map(String.init)
        var paths: Set<String> = []
        for row in 0..<size {
            for col in 0..<size {
                for dir in allDirections {
                    var indices: [Int] = [], valid = true
                    for i in chars.indices {
                        let r = row + dir.0 * i, c = col + dir.1 * i
                        if !(0..<size).contains(r) || !(0..<size).contains(c) {
                            valid = false; break
                        }
                        let idx = r * size + c
                        if letters[idx] != chars[i] { valid = false; break }
                        indices.append(idx)
                    }
                    if valid {
                        // A palindromic word has the same path in both directions.
                        let forward = indices.map(String.init).joined(separator: ",")
                        let reverse = indices.reversed().map(String.init).joined(separator: ",")
                        paths.insert(min(forward, reverse))
                    }
                }
            }
        }
        return paths.count
    }

    static func path(from first: Int, to last: Int, size: Int) -> [Int]? {
        let r0 = first / size, c0 = first % size
        let r1 = last / size, c1 = last % size
        let dr = r1 - r0, dc = c1 - c0
        let length = max(abs(dr), abs(dc))
        if length == 0 { return [first] }
        guard dr == 0 || dc == 0 || abs(dr) == abs(dc) else { return nil }
        let stepR = dr == 0 ? 0 : dr / abs(dr)
        let stepC = dc == 0 ? 0 : dc / abs(dc)
        return (0...length).map { (r0 + stepR * $0) * size + c0 + stepC * $0 }
    }
}
