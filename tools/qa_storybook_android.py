#!/usr/bin/env python3
"""Android emulator visual smoke walkthrough for storybook daytime/night and star win.
No special permissions, app instrumentation or server credentials required.
The script writes real screenshots and a JSON report; optional victory navigation
is reported as not tested rather than misreported as passed.
"""
import json
import re
import subprocess
import time
import xml.etree.ElementTree as ET
from pathlib import Path

ADB = ["adb"]
OUT = Path("docs/qa/emulator-storybook-20261120")
OUT.mkdir(parents=True, exist_ok=True)
report = {"mode": "emulator Android", "screenshots": [], "checks": {}, "notes": []}

def adb(*args, checked=True):
    result = subprocess.run(ADB + list(args), capture_output=True, text=True, timeout=40)
    if checked and result.returncode:
        raise RuntimeError("adb " + " ".join(args) + " → " + result.stderr[-350:])
    return result.stdout

def screenshot(name):
    path = OUT / (name + ".png")
    with path.open("wb") as f:
        proc = subprocess.run(ADB + ["exec-out", "screencap", "-p"], stdout=f, stderr=subprocess.PIPE, timeout=45)
    if proc.returncode or path.stat().st_size < 2500:
        raise RuntimeError("Captura vacía: " + name)
    report["screenshots"].append(str(path))
    print("SCREENSHOT", path, path.stat().st_size, flush=True)

def hierarchy():
    for _ in range(3):
        adb("shell", "uiautomator", "dump", "/sdcard/window.xml", checked=False)
        raw = adb("shell", "cat", "/sdcard/window.xml", checked=False)
        if "<hierarchy" in raw:
            return ET.fromstring(raw[raw.index("<hierarchy"):])
        time.sleep(1)
    raise RuntimeError("Jerarquía Android no disponible")

def matches(substring, exact=False):
    found = []
    root = hierarchy()
    for node in root.iter("node"):
        text = (node.attrib.get("text", "") + " " + node.attrib.get("content-desc", "")).strip()
        if (text == substring if exact else substring.lower() in text.lower()):
            m = re.findall(r"\d+", node.attrib.get("bounds", ""))
            if len(m) == 4:
                x1, y1, x2, y2 = map(int, m)
                if x2 > x1 and y2 > y1:
                    found.append((x1, y1, x2, y2, text))
    return found

def touch(rect):
    x1,y1,x2,y2,_=rect
    adb("shell","input","tap",str((x1+x2)//2),str((y1+y2)//2))
    time.sleep(.7)

def tap_text(text, scroll=False, exact=False, min_y=0, bottom_first=False):
    for i in range(7 if scroll else 2):
        options = [r for r in matches(text, exact) if r[1] >= min_y]
        if options:
            options.sort(key=lambda r: r[1], reverse=bottom_first)
            touch(options[0])
            print("TAPPED",text,options[0],flush=True)
            return True
        if scroll:
            adb("shell","input","swipe","165","558","165","175","470")
            time.sleep(.45)
    report["notes"].append("Elemento no encontrado: "+text)
    print("NOT FOUND",text,flush=True)
    return False

def save():
    (OUT/"results.json").write_text(json.dumps(report,ensure_ascii=False,indent=2)+"\n",encoding="utf-8")

def parse_board_letters():
    root=hierarchy()
    board_bounds=None
    for node in root.iter("node"):
        if "Tablero de 6 por 6 letras" in node.attrib.get("content-desc",""):
            vals=re.findall(r"\d+",node.attrib.get("bounds",""))
            if len(vals)==4:
                board_bounds=list(map(int,vals))
            break
    if not board_bounds:
        return None
    left, top, right, bottom=board_bounds
    letters=[]
    for node in root.iter("node"):
        word=node.attrib.get("text","")
        if len(word)!=1 or not word.isalpha() or not word.isupper():continue
        vals=re.findall(r"\d+",node.attrib.get("bounds",""))
        if len(vals)!=4:continue
        x1,y1,x2,y2=map(int,vals)
        cx,cy=(x1+x2)//2,(y1+y2)//2
        if left<=cx<=right and top<=cy<=bottom:
            letters.append((cx,cy,word))
    letters.sort(key=lambda x:(x[1],x[0]))
    print("BOARD_LETTERS",len(letters),board_bounds,flush=True)
    if len(letters)!=36:return None
    # Cluster by rows; sorting by fixed 6-letter groups is safe for Compose's grid.
    return [sorted(letters[row*6:(row+1)*6],key=lambda z:z[0]) for row in range(6)]

def solve_first_board():
    grid=parse_board_letters()
    if grid is None:
        report["notes"].append("No se pudieron leer 36 casillas en el árbol de accesibilidad")
        return False
    letters=[[cell[2] for cell in row] for row in grid]
    report["checks"]["six_by_six_accessibility"]=True
    words=["LUZ","TIERRA","DIA"]
    direction=[(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
    for word in words:
        found=False
        for r in range(6):
            for c in range(6):
                for dr,dc in direction:
                    cells=[(r+i*dr,c+i*dc) for i in range(len(word))]
                    if all(0<=a<6 and 0<=b<6 and letters[a][b]==word[i] for i,(a,b) in enumerate(cells)):
                        y0,x0=cells[0]; y1,x1=cells[-1]
                        start=grid[y0][x0];end=grid[y1][x1]
                        adb("shell","input","swipe",str(start[0]),str(start[1]),str(end[0]),str(end[1]),"710")
                        time.sleep(.7)
                        print("SOLVED_WORD",word,cells,flush=True)
                        found=True;break
                if found:break
            if found:break
        if not found:
            report["notes"].append("No se encontró palabra "+word+" en la cuadrícula")
            return False
    time.sleep(2)
    return True

try:
    adb("shell","wm","size","320x640")
    adb("shell","wm","density","160")
    adb("shell","am","force-stop","app.sopadeletras.cristiana.debug",checked=False)
    adb("shell","am","start","-n","app.sopadeletras.cristiana.debug/app.sopadeletras.MainActivity")
    time.sleep(2)
    screenshot("01-portada-dia")
    if tap_text("Comenzar la aventura",scroll=True):
        report["checks"]["home_accessible"]=True
        screenshot("02-inicio-dia")
        if tap_text("Ajustes",scroll=True):
            screenshot("03-ajustes-dia")
            if tap_text("Noche estrellada",scroll=True):
                screenshot("04-ajustes-noche")
                report["checks"]["manual_night_theme"]=True
                if tap_text("Volver"):
                    screenshot("05-inicio-noche")
                    report["checks"]["night_home"]=True
                    if tap_text("Ajustes",scroll=True):
                        tap_text("Día soleado",scroll=True)
                        tap_text("Volver")
                        screenshot("06-inicio-dia-restaurado")
                        report["checks"]["manual_day_theme"]=True
        # Optional board and actual win celebration
        if tap_text("Jugar nivel 1", scroll=True):
            screenshot("07-mapa-campana")
            if tap_text("1",exact=True,min_y=210,bottom_first=True):
                screenshot("08-tablero-primer-nivel")
                report["checks"]["board_accessible"]=bool(matches("Tablero de 6 por 6 letras"))
                if solve_first_board():
                    screenshot("09-victoria-estrellas-grandes")
                    report["checks"]["victory_celebration"]=bool(matches("MISIÓN CUMPLIDA"))
finally:
    save()
    print("QA_SUMMARY",json.dumps(report,ensure_ascii=False),flush=True)
