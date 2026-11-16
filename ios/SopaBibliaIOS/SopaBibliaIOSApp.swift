import SwiftUI
import Combine

private enum SopaStyle {
    static let navy = Color(red: 0.09, green: 0.16, blue: 0.29)
    static let cream = Color(red: 0.98, green: 0.97, blue: 0.94)
    static let tile = Color(red: 0.81, green: 0.87, blue: 0.93)
    static let yellow = Color(red: 0.96, green: 0.77, blue: 0.36)
    static let teal = Color(red: 0.22, green: 0.73, blue: 0.75)
    static let purple = Color(red: 0.68, green: 0.60, blue: 0.91)
    static let green = Color(red: 0.63, green: 0.83, blue: 0.66)
    static let pink = Color(red: 0.92, green: 0.67, blue: 0.78)
    static let found = [yellow, teal, purple, green, pink]
    static let worldColors: [[Color]] = [
        [.init(red: 0.70, green: 0.88, blue: 0.95), .init(red: 0.71, green: 0.81, blue: 0.57)],
        [.init(red: 0.83, green: 0.87, blue: 0.72), .init(red: 0.80, green: 0.69, blue: 0.50)],
        [.init(red: 0.74, green: 0.82, blue: 0.96), .init(red: 0.71, green: 0.76, blue: 0.68)],
        [.init(red: 0.46, green: 0.52, blue: 0.73), .init(red: 0.89, green: 0.72, blue: 0.48)],
        [.init(red: 0.72, green: 0.83, blue: 0.88), .init(red: 0.86, green: 0.72, blue: 0.52)],
        [.init(red: 0.84, green: 0.85, blue: 0.80), .init(red: 0.90, green: 0.69, blue: 0.50)],
        [.init(red: 0.70, green: 0.88, blue: 0.85), .init(red: 0.72, green: 0.85, blue: 0.63)],
        [.init(red: 0.69, green: 0.85, blue: 0.91), .init(red: 0.51, green: 0.75, blue: 0.73)],
        [.init(red: 0.81, green: 0.79, blue: 0.92), .init(red: 0.91, green: 0.85, blue: 0.69)],
        [.init(red: 0.83, green: 0.89, blue: 0.79), .init(red: 0.92, green: 0.79, blue: 0.65)]
    ]
}

struct WorldScenery: View {
    let world: Int
    var body: some View {
        let palette = SopaStyle.worldColors[max(0, min(world - 1, 9))]
        GeometryReader { proxy in
            ZStack {
                LinearGradient(colors: palette, startPoint: .top, endPoint: .bottom)
                Circle().fill(.white.opacity(0.40))
                    .frame(width: 115, height: 115)
                    .offset(x: proxy.size.width * 0.25, y: -proxy.size.height * 0.25)
                Ellipse().fill(palette[1].opacity(0.60))
                    .frame(width: proxy.size.width * 1.6, height: proxy.size.height * 0.40)
                    .offset(y: proxy.size.height * 0.50)
                Ellipse().fill(palette[1].opacity(0.45))
                    .frame(width: proxy.size.width * 1.4, height: proxy.size.height * 0.27)
                    .offset(x: -40, y: proxy.size.height * 0.39)
            }
            .frame(width: proxy.size.width, height: proxy.size.height)
            .clipped()
        }
        .ignoresSafeArea()
    }
}

@main
struct SopaBibliaIOSApp: App {
    @StateObject private var library = BibleLibrary()
    var body: some Scene {
        WindowGroup {
            NavigationStack {
                HomeView()
            }
            .environmentObject(library)
            .tint(SopaStyle.navy)
        }
    }
}

struct HomeView: View {
    @EnvironmentObject private var library: BibleLibrary

    var body: some View {
        ZStack {
            WorldScenery(world: 1)
            ScrollView {
                VStack(alignment: .leading, spacing: 19) {
                    Text("Sopa de letras")
                        .font(.system(size: 33, weight: .heavy, design: .rounded))
                    Text("Biblia RV-1909")
                        .font(.title2.weight(.semibold))
                    Text("Aprende, descubre palabras y lee la Biblia.")
                        .font(.subheadline)
                    if let error = library.loadError {
                        Text(error).foregroundStyle(.red)
                            .padding().background(SopaStyle.cream, in: RoundedRectangle(cornerRadius: 15))
                    } else {
                        NavigationLink {
                            CampaignWorldList()
                        } label: {
                            HomeAction(title: "Campaña bíblica", detail: "300 niveles · 10 mundos", symbol: "square.grid.3x3.fill")
                        }
                        NavigationLink {
                            FreeMysteryPicker()
                        } label: {
                            HomeAction(title: "Palabra misteriosa", detail: "6×6 · 8×8 · 10×10", symbol: "questionmark.square.fill")
                        }
                        NavigationLink {
                            BibleBookList()
                        } label: {
                            HomeAction(title: "Leer la Biblia", detail: "Reina-Valera 1909 · 66 libros · sin conexión", symbol: "book.closed.fill")
                        }
                    }
                    NavigationLink {
                        CreditsView()
                    } label: {
                        HomeAction(title: "Acerca de esta aplicación", detail: "Desarrollador y contacto", symbol: "info.circle")
                    }
                    Spacer(minLength: 40)
                }
                .foregroundStyle(SopaStyle.navy)
                .padding(20)
                .frame(maxWidth: .infinity, alignment: .leading)
            }
        }
        .navigationTitle("Inicio")
        .navigationBarTitleDisplayMode(.inline)
    }
}

private struct HomeAction: View {
    let title: String
    let detail: String
    let symbol: String
    var body: some View {
        HStack(spacing: 13) {
            Image(systemName: symbol)
                .font(.system(size: 25))
                .frame(width: 42)
            VStack(alignment: .leading, spacing: 4) {
                Text(title).font(.headline)
                Text(detail).font(.caption)
            }
            Spacer()
            Image(systemName: "chevron.right")
        }
        .padding(16)
        .foregroundStyle(SopaStyle.navy)
        .background(SopaStyle.cream.opacity(0.95), in: RoundedRectangle(cornerRadius: 20))
    }
}

struct CampaignWorldList: View {
    @EnvironmentObject private var library: BibleLibrary
    var body: some View {
        List(library.catalog?.worlds ?? [], id: \.world) { world in
            NavigationLink {
                WorldLevelList(world: world)
            } label: {
                HStack(spacing: 12) {
                    Text("\(world.world)")
                        .font(.title3.bold())
                        .frame(width: 42, height: 42)
                        .background(SopaStyle.yellow, in: RoundedRectangle(cornerRadius: 12))
                    VStack(alignment: .leading) {
                        Text(world.name).font(.headline)
                        Text("30 niveles · \(world.boardSize)×\(world.boardSize)").font(.caption)
                    }
                    Spacer()
                }
                .padding(.vertical, 7)
            }
        }
        .navigationTitle("Los 10 mundos")
    }
}

struct WorldLevelList: View {
    @EnvironmentObject private var library: BibleLibrary
    let world: BibleWorld
    var body: some View {
        List {
            ForEach((world.world - 1) * 30 + 1...world.world * 30, id: \.self) { number in
                if let level = library.level(number) {
                    NavigationLink {
                        GameView(definition: .campaign(level))
                    } label: {
                        HStack {
                            Text("Nivel \(number)")
                                .font(.headline).frame(width: 95, alignment: .leading)
                            VStack(alignment: .leading) {
                                Text(level.topic).font(.subheadline)
                                Text("\(level.boardSize)×\(level.boardSize) · \(level.words.count) palabras")
                                    .font(.caption).foregroundStyle(.secondary)
                            }
                            Spacer()
                            if library.completed.contains(number) {
                                Image(systemName: "checkmark.circle.fill").foregroundStyle(.green)
                            }
                        }
                        .padding(.vertical, 5)
                    }
                    .disabled(number > library.nextLevel && !library.completed.contains(number))
                }
            }
        }
        .navigationTitle(world.name)
    }
}

struct FreeMysteryPicker: View {
    @EnvironmentObject private var library: BibleLibrary
    @State private var selectedSize: Int = 8
    var body: some View {
        List {
            Section("Tamaño del tablero") {
                Picker("Cuadrícula", selection: $selectedSize) {
                    ForEach([6, 8, 10], id: \.self) { n in
                        Text("\(n)×\(n)").tag(n)
                    }
                }
                .pickerStyle(.segmented)
            }
            Section("Elegir mundo") {
                ForEach(library.catalog?.worlds ?? [], id: \.world) { world in
                    if let challenge = library.freeMystery(world: world, size: selectedSize) {
                        NavigationLink {
                            GameView(definition: .freeMystery(challenge, world: world, hints: library.hints(for: world.world)))
                        } label: {
                            VStack(alignment: .leading, spacing: 3) {
                                Text(world.name).font(.headline)
                                Text("\(selectedSize)×\(selectedSize) · \(challenge.words.count) palabras · Biblia RV1909")
                                    .font(.caption).foregroundStyle(.secondary)
                            }
                            .padding(.vertical, 5)
                        }
                    }
                }
            }
        }
        .navigationTitle("Palabra misteriosa")
    }
}

struct CreditsView: View {
    var body: some View {
        List {
            Section("Sopa de letras -Biblia Rv-1909") {
                LabeledContent("Desarrollador", value: "Camilo Arévalo")
                Link("apkcristiana@gmail.com", destination: URL(string: "mailto:apkcristiana@gmail.com")!)
            }
            Section("Otra aplicación del desarrollador") {
                Text("Guía pastoral - Biblia").font(.headline)
                Text("Consulta su disponibilidad escribiendo al correo de contacto.")
                    .foregroundStyle(.secondary)
            }
            Section("Contenido") {
                Text("Biblia Reina-Valera 1909 · dominio público · biblioteca disponible sin conexión.")
                Text("Aplicación educativa sin anuncios ni cuentas obligatorias.")
            }
        }
        .navigationTitle("Acerca de")
    }
}

struct GameDefinition {
    let title: String
    let world: Int
    let size: Int
    let words: [String]
    let hints: [String: WordReference]
    let mystery: MysterySpec?
    let reference: String
    let message: String
    let kind: String
    let level: Int?

    static func campaign(_ level: BibleLevel) -> GameDefinition {
        GameDefinition(
            title: level.title, world: level.world, size: level.boardSize,
            words: level.words,
            hints: Dictionary(level.wordHints.map { ($0.word, $0) }, uniquingKeysWith: { _, latest in latest }),
            mystery: level.mystery, reference: level.reference,
            message: level.learningMessage, kind: level.kind, level: level.level
        )
    }

    static func freeMystery(_ challenge: FreeMystery, world: BibleWorld, hints: [String: WordReference]) -> GameDefinition {
        GameDefinition(
            title: world.name, world: world.world, size: challenge.size,
            words: challenge.words, hints: hints, mystery: challenge.mystery,
            reference: challenge.mystery.reference,
            message: "Las iniciales de las palabras forman la palabra misteriosa.",
            kind: "MISTERIOSO", level: nil
        )
    }
}

private struct HintCard: Identifiable {
    let id = UUID()
    let clue: String
    let reference: String
}

struct GameView: View {
    @EnvironmentObject private var library: BibleLibrary
    let definition: GameDefinition
    @State private var board: PuzzleBoard?
    @State private var errorMessage: String?
    @State private var found: Set<String> = []
    @State private var dragStart: Int?
    @State private var dragEnd: Int?
    @State private var illuminated: Set<Int> = []
    @State private var hintsUsed = 0
    @State private var activeHint: HintCard?
    @State private var victory = false
    @State private var secondsRemaining = 300

    private var isTimed: Bool {
        ["CONTRARRELOJ", "TIMED"].contains(definition.kind.uppercased())
    }
    private var solved: Bool { found.count == definition.words.count }
    private var mysteryLetters: [String] {
        guard let mystery = definition.mystery else { return [] }
        let letters = Array(mystery.word).map(String.init)
        return letters.enumerated().map { index, ch in
            solved || found.contains(definition.words[index]) ? ch : "•"
        }
    }

    var body: some View {
        ZStack {
            WorldScenery(world: definition.world)
            ScrollView {
                VStack(alignment: .leading, spacing: 15) {
                    Text(definition.title).font(.title2.bold())
                    HStack {
                        Text("\(definition.size)×\(definition.size) · \(definition.words.count) palabras")
                        Spacer()
                        if isTimed { Text("⏱ \(secondsRemaining)s") }
                    }
                    .font(.subheadline)
                    .foregroundStyle(.secondary)

                    if let errorMessage {
                        Text(errorMessage).foregroundStyle(.red)
                            .padding().background(SopaStyle.cream, in: RoundedRectangle(cornerRadius: 14))
                        Button("Reintentar") { loadBoard() }.buttonStyle(.borderedProminent)
                    } else if let board {
                        BoardGrid(
                            board: board, found: found, illuminated: illuminated,
                            dragStart: $dragStart, dragEnd: $dragEnd,
                            onSelect: acceptPath
                        )
                        .padding(10)
                        .background(SopaStyle.cream, in: RoundedRectangle(cornerRadius: 18))

                        if let mystery = definition.mystery {
                            VStack(alignment: .leading, spacing: 10) {
                                Text("Palabra misteriosa").font(.headline)
                                HStack(spacing: 5) {
                                    ForEach(mysteryLetters.indices, id: \.self) { i in
                                        Text(mysteryLetters[i])
                                            .font(.system(size: definition.size == 6 ? 20 : 17, weight: .bold))
                                            .frame(maxWidth: .infinity)
                                            .frame(height: 35)
                                            .background(SopaStyle.tile, in: RoundedRectangle(cornerRadius: 8))
                                    }
                                }
                                Text(mystery.clue).font(.subheadline)
                                NavigationLink {
                                    BibleReaderView(reference: mystery.reference)
                                } label: {
                                    HStack {
                                        Text(mystery.reference).underline()
                                        Spacer()
                                        Text("Leer la Biblia")
                                    }
                                    .font(.subheadline.bold())
                                    .foregroundStyle(Color(red: 0.60, green: 0.40, blue: 0.05))
                                }
                            }
                            .padding(14)
                            .background(SopaStyle.cream, in: RoundedRectangle(cornerRadius: 18))
                        }

                        LazyVGrid(columns: Array(repeating: GridItem(.flexible(), spacing: 7), count: 3), spacing: 8) {
                            ForEach(definition.words, id: \.self) { word in
                                let index = definition.words.firstIndex(of: word) ?? 0
                                Text(found.contains(word) ? "✓ " + word : word)
                                    .font(.system(size: 13, weight: .semibold))
                                    .lineLimit(1)
                                    .minimumScaleFactor(0.7)
                                    .frame(maxWidth: .infinity, minHeight: 36)
                                    .background(
                                        found.contains(word) ? SopaStyle.found[index % SopaStyle.found.count] : SopaStyle.cream,
                                        in: Capsule()
                                    )
                            }
                        }
                        HStack {
                            Button("Pista · \(max(0, 3 - hintsUsed))") { showHint() }
                                .disabled(hintsUsed >= 3 || solved)
                            Spacer()
                            if isTimed { Button("Reiniciar") { loadBoard() } }
                        }
                        .buttonStyle(.borderedProminent)
                        .tint(SopaStyle.navy)

                        if solved {
                            VStack(alignment: .leading, spacing: 7) {
                                Text("¡Muy bien!").font(.title2.bold())
                                Text(definition.message)
                                if let n = definition.level, n < 300 {
                                    NavigationLink("Siguiente nivel") {
                                        if let next = library.level(n + 1) {
                                            GameView(definition: .campaign(next))
                                        }
                                    }
                                }
                            }
                            .padding(14)
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .background(SopaStyle.cream, in: RoundedRectangle(cornerRadius: 16))
                        }
                    } else {
                        ProgressView("Preparando el tablero…")
                    }
                }
                .foregroundStyle(SopaStyle.navy)
                .padding(15)
            }
        }
        .navigationTitle(definition.level.map { "Nivel \($0)" } ?? "Palabra misteriosa")
        .navigationBarTitleDisplayMode(.inline)
        .task { if board == nil && errorMessage == nil { loadBoard() } }
        .onReceive(Timer.publish(every: 1, on: .main, in: .common).autoconnect()) { _ in
            if isTimed && board != nil && !solved && secondsRemaining > 0 && activeHint == nil {
                secondsRemaining -= 1
            }
        }
        .sheet(item: $activeHint) { hint in
            NavigationStack {
                VStack(alignment: .leading, spacing: 18) {
                    Text("Pista bíblica").font(.title2.bold())
                    Text(hint.clue).font(.body)
                    NavigationLink {
                        BibleReaderView(reference: hint.reference)
                    } label: {
                        HStack {
                            Text(hint.reference).underline()
                            Spacer()
                            Text("Leer la Biblia")
                        }
                        .foregroundStyle(Color(red: 0.60, green: 0.40, blue: 0.05))
                        .font(.subheadline.bold())
                    }
                    Button("Seguir jugando") { activeHint = nil }
                        .buttonStyle(.borderedProminent)
                    Spacer()
                }
                .padding(22)
                .navigationBarTitleDisplayMode(.inline)
            }
            .presentationDetents([.medium, .large])
        }
    }

    private func loadBoard() {
        errorMessage = nil
        board = nil
        found.removeAll()
        illuminated.removeAll()
        hintsUsed = 0
        secondsRemaining = 300
        let seed = UInt64(definition.level ?? definition.world * 10_000 + definition.size)
        do {
            board = try GridGenerator.make(
                words: definition.words, size: definition.size,
                seed: seed,
                requiresCrossing: definition.size >= 10 && definition.words.count >= 8 && definition.mystery == nil
            )
        } catch {
            errorMessage = error.localizedDescription
        }
    }

    private func acceptPath(_ cells: [Int]) {
        guard let item = board?.words.first(where: { $0.cells == cells || Array($0.cells.reversed()) == cells }) else { return }
        guard found.insert(item.word).inserted else { return }
        if solved, let level = definition.level { library.complete(level: level) }
    }

    private func showHint() {
        guard hintsUsed < 3, let item = board?.words.first(where: { !found.contains($0.word) }) else { return }
        let index = min(hintsUsed, item.cells.count - 1)
        illuminated.insert(item.cells[index])
        hintsUsed += 1
        let fallback = "Busca una palabra vinculada con este relato bíblico."
        let clue = definition.hints[item.word]?.clue ?? fallback
        let reference = definition.hints[item.word]?.reference ?? definition.reference
        activeHint = HintCard(clue: clue, reference: reference)
    }
}

private struct BoardGrid: View {
    let board: PuzzleBoard
    let found: Set<String>
    let illuminated: Set<Int>
    @Binding var dragStart: Int?
    @Binding var dragEnd: Int?
    let onSelect: ([Int]) -> Void

    private func cellIndex(_ point: CGPoint, width: CGFloat) -> Int? {
        let step = width / CGFloat(board.size)
        let r = Int(floor(point.y / step))
        let c = Int(floor(point.x / step))
        guard (0..<board.size).contains(r), (0..<board.size).contains(c) else { return nil }
        return r * board.size + c
    }

    private func tileColor(_ index: Int, selected: Set<Int>) -> Color {
        if selected.contains(index) { return SopaStyle.yellow.opacity(0.88) }
        for (i, word) in board.words.enumerated() {
            if found.contains(word.word) && word.cells.contains(index) {
                return SopaStyle.found[i % SopaStyle.found.count]
            }
        }
        return SopaStyle.tile
    }

    var body: some View {
        GeometryReader { geometry in
            let side = geometry.size.width
            let gap: CGFloat = 4
            let cellSide = (side - CGFloat(board.size - 1) * gap) / CGFloat(board.size)
            let selection = Set(
                (dragStart != nil && dragEnd != nil)
                    ? GridGenerator.path(from: dragStart!, to: dragEnd!, size: board.size) ?? []
                    : []
            )
            LazyVGrid(
                columns: Array(repeating: GridItem(.flexible(minimum: 0), spacing: gap), count: board.size),
                spacing: gap
            ) {
                ForEach(board.letters.indices, id: \.self) { index in
                    Text(board.letters[index])
                        .font(.system(size: max(12, cellSide * 0.41), weight: .heavy, design: .rounded))
                        .foregroundStyle(SopaStyle.navy)
                        .frame(maxWidth: .infinity)
                        .frame(height: cellSide)
                        .background(tileColor(index, selected: selection), in: RoundedRectangle(cornerRadius: 8))
                        .overlay(
                            RoundedRectangle(cornerRadius: 8)
                                .stroke(illuminated.contains(index) ? SopaStyle.yellow : .clear, lineWidth: 3)
                        )
                }
            }
            .frame(width: side, height: side, alignment: .top)
            .contentShape(Rectangle())
            .gesture(
                DragGesture(minimumDistance: 0)
                    .onChanged { gesture in
                        if dragStart == nil {
                            dragStart = cellIndex(gesture.startLocation, width: side)
                        }
                        dragEnd = cellIndex(gesture.location, width: side)
                    }
                    .onEnded { gesture in
                        if let start = dragStart,
                           let end = cellIndex(gesture.location, width: side),
                           let path = GridGenerator.path(from: start, to: end, size: board.size) {
                            onSelect(path)
                        }
                        dragStart = nil
                        dragEnd = nil
                    }
            )
        }
        .aspectRatio(1, contentMode: .fit)
        .accessibilityLabel("Sopa de letras de \(board.size) por \(board.size). Desliza sobre una palabra.")
    }
}

struct BibleBookList: View {
    @EnvironmentObject private var library: BibleLibrary
    var body: some View {
        List(library.books) { book in
            NavigationLink {
                BibleChaptersView(book: book)
            } label: {
                HStack {
                    Text(book.name)
                    Spacer()
                    Text("\(book.chapterCount) cap.").font(.caption).foregroundStyle(.secondary)
                }
            }
        }
        .navigationTitle("Biblia RV1909")
    }
}
struct BibleChaptersView: View {
    let book: BibleBook
    var body: some View {
        ScrollView {
            LazyVGrid(columns: [GridItem(.adaptive(minimum: 66))], spacing: 12) {
                ForEach(1...book.chapterCount, id: \.self) { chapter in
                    NavigationLink {
                        BibleChapterView(book: book, chapter: chapter, highlightVerse: 1)
                    } label: {
                        Text("\(chapter)")
                            .font(.headline)
                            .frame(maxWidth: .infinity, minHeight: 46)
                            .background(SopaStyle.cream, in: RoundedRectangle(cornerRadius: 12))
                    }
                }
            }
            .padding()
        }
        .navigationTitle(book.name)
    }
}
struct BibleReaderView: View {
    @EnvironmentObject private var library: BibleLibrary
    let reference: String
    var body: some View {
        Group {
            if let location = library.parseReference(reference) {
                BibleChapterView(book: location.book, chapter: location.chapter, highlightVerse: location.verse)
            } else {
                VStack(spacing: 14) {
                    Image(systemName: "book.closed").font(.largeTitle)
                    Text(reference).font(.headline)
                    Text("Busca este pasaje desde la lista de libros de la Biblia.")
                }
                .padding()
            }
        }
        .navigationTitle("Leer la Biblia")
    }
}
struct BibleChapterView: View {
    @EnvironmentObject private var library: BibleLibrary
    let book: BibleBook
    let chapter: Int
    let highlightVerse: Int

    var body: some View {
        ScrollViewReader { reader in
            ScrollView {
                LazyVStack(alignment: .leading, spacing: 13) {
                    Text("\(book.name) \(chapter)")
                        .font(.title.bold())
                    ForEach(library.chapter(book: book, chapter: chapter), id: \.0) { verse in
                        Text("\(verse.0)  \(verse.1)")
                            .font(.system(size: 17))
                            .lineSpacing(4)
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .padding(.vertical, 5)
                            .padding(.horizontal, 6)
                            .background(
                                verse.0 == highlightVerse ? SopaStyle.yellow.opacity(0.25) : .clear,
                                in: RoundedRectangle(cornerRadius: 7)
                            )
                            .id(verse.0)
                    }
                    Text("Reina-Valera 1909 · dominio público")
                        .font(.caption).foregroundStyle(.secondary)
                }
                .padding(18)
            }
            .onAppear {
                DispatchQueue.main.async {
                    withAnimation(.easeOut(duration: 0.2)) {
                        reader.scrollTo(highlightVerse, anchor: .top)
                    }
                }
            }
        }
        .navigationTitle("\(book.name) \(chapter)")
        .navigationBarTitleDisplayMode(.inline)
    }
}
