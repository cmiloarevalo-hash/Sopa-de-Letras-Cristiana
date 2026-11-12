#!/usr/bin/env python3
"""UX contract validator for the 300 exact biblical word-search levels.

Run: python tools/validate_ux_content.py
No network, SDK or additional Python packages required.
"""
from pathlib import Path
import collections, json, re, unicodedata

ROOT = Path(__file__).resolve().parents[1]
catalog = json.loads((ROOT / "app/src/main/assets/campaign/es-ES/levels-v1.json").read_text(encoding="utf-8"))
bible_root = ROOT / "app/src/main/assets/bible/rv1909"
index = json.loads((bible_root / "index.json").read_text(encoding="utf-8"))
book_files = {}
for item in index["books"]:
    book_files[item["name"]] = json.loads((bible_root / (item["id"] + ".json")).read_text(encoding="utf-8"))

levels = catalog["levels"]
assert len(levels) == 300 and len(catalog["worlds"]) == 10
assert len(index["books"]) == 66
failures = []
counts = collections.Counter()
for i, level in enumerate(levels):
    index_level = i + 1
    board = level["boardSize"]
    words = level["words"]
    entries = level["wordHints"]
    if level["level"] != index_level or not 1 <= level["world"] <= 10:
        failures.append((index_level, "number"))
    if len(words) != level["wordCount"] or len(entries) != len(words):
        failures.append((index_level, "words-count"))
    if len(set(words)) != len(words):
        failures.append((index_level, "duplicate-in-board"))
    if any(not 3 <= len(w) <= board or not re.fullmatch(r"[A-ZÑ]+", w) for w in words):
        failures.append((index_level, "invalid-size-or-characters"))
    for a in range(len(words)):
        for b in range(a + 1, len(words)):
            if words[a] in words[b] or words[b] in words[a]:
                failures.append((index_level, "ambiguous-subword", words[a], words[b]))
    for prev in levels[max(0, i-3):i]:
        if prev["world"] == level["world"] and set(words) & set(prev["words"]):
            failures.append((index_level, "near-repeat", prev["level"]))
    for w, entry in zip(words, entries):
        if entry["word"] != w or entry["initial"] != w[0]:
            failures.append((index_level, "wrong-word-association", w))
        if not entry["clue"].strip() or not entry["reference"].strip():
            failures.append((index_level, "missing-biblical-clue", w))
        if re.search(r"\b" + re.escape(w) + r"\b", entry["clue"].upper()):
            failures.append((index_level, "answer-revealed-in-clue", w))
        ref = entry["reference"]
        match = re.fullmatch(r"(.+?) (\d+):(\d+)", ref)
        if not match:
            failures.append((index_level, "bad-reference", ref))
            continue
        book, chapter, verse = match.groups()
        chapter_map = book_files.get(book, {}).get("chapters", {}).get(chapter, {})
        if verse not in chapter_map:
            failures.append((index_level, "nonexistent-verse", ref))
        counts[entry["referenceType"]] += 1
    if level["kind"] == "MISTERIOSO":
        answer = level["mystery"]["word"]
        acronym = "".join(w[0] for w in words)
        if len(words) != len(answer) or acronym != answer:
            failures.append((index_level, "acrostic-inconsistent", acronym, answer))
        counts["mysteries"] += 1
    counts["words"] += len(words)
assert not failures, failures[:20]
assert counts["mysteries"] == 10
assert counts["words"] >= 2400
assert len(list((ROOT / "app/src/main/res/drawable-nodpi").glob("world_*.webp"))) == 10
print(f"UX contract PASS: {len(levels)} levels, {counts['words']} word-biblical clue links, "
      f"{counts['literal']} direct verses, {counts['tematico']} thematic references, "
      f"10 ordered biblical acrostics, zero near repeats (3-level window), "
      "10 scenic backgrounds, 66 Bible books")

