# QA visual RC6 · Android 320×640 · 2026-11-20

**Autoridad:** [Supervisor (Issue #8)](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/8#issuecomment-7047929035), A3 #4/A5 #6. **PR:** [#23](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/pull/23). Se revisó la APK RC6 procedente de `52b52f8a08f32b550e53fe99686ce6125144fd65`.

**Dispositivo real emulado:** Windows `DESKTOP-1G4MC52`, AVD ya existente `SLC_Test_API33`, Android 13/API 33 x86_64, `emulator-5554`, tamaño `320x640`, densidad `160`, `sys.boot_completed=1`. APK RC6 15.856.932 bytes; SHA256 `E8BE0B1494523B2C71A85576A30F98FF8B692EC38479BF8F103710E5C7E2395C`, instalación con `adb install -r` → `Success`. Imágenes capturadas con `adb shell screencap -p` y `adb pull`; ninguna es maqueta.

## Comprobaciones y capturas del APK RC6

| Verificación | Estado | Capturas |
| --- | --- | --- |
| Portada día/noche, botón y título | **PASS con defecto visual menor**: sol/luna interfiere con extremo derecho del rótulo pequeño «AVENTURA BÍBLICA» a 320 px | [día](01-cover-day.png) · [noche](02-cover-night.png) |
| Inicio día y noche, contraste y contenido | **PASS** | [día](03-home-day.png) · [noche](04-home-night.png) |
| Ajustes manuales día/noche | **PASS** | [día](05-settings-manual-day.png) · [noche](06-settings-manual-night.png) |
| Tema AUTO al cambiar modo oscuro del teléfono `cmd uimode night yes/no` | **PASS**, cambia a noche y recupera día | [AUTO día](07-settings-auto-day.png) · [AUTO noche](08-settings-auto-night.png) · [restaurado](09-settings-auto-return-day.png) |
| Mapa de campaña y tablero de nivel 1, 6×6 | **PASS**, texto/celdas legibles | [mapa](10-campaign-map.png) · [tablero](11-campaign-board.png) |
| Victoria nivel 1 tras encontrar LUZ, TIERRA y DIA | **PASS**, tres estrellas grandes, premio, referencia y botones sin oclusión | [victoria](12-campaign-win.png) |
| Cinco colores originales simultáneos en Palabra misteriosa 6×6 | **PASS**, CAMPO amarillo; UNIDOS turquesa; INICIO violeta; DIOS verde; ARBOL rosa | [cinco colores](13-five-colors.png) |
| Acción «Adivinar» en misterio 6×6 en 320×640 | **PASS**, visible al desplazarse; el contenido está diseñado para scroll | [acciones](14-mystery-actions-scroll.png) |
| Victoria misterio al introducir y verificar CUIDAR | **PASS**, tres estrellas, CUIDAR, referencia, «Siguiente»/«Inicio» sin oclusión | [victoria](15-mystery-win.png) |

## Defecto localizado y alcance de corrección

**Hallazgo app comprobado:** en la portada, sol/luna se superpone al rótulo superior en 320×640. **Microcorrección exclusiva:** `CoverScreen.kt` añade `Modifier.padding(end = 72.dp)` al rótulo, sin cambiar paisaje, tablero, colores ni navegación. Todas las capturas anteriores pertenecen a **RC6 antes de la corrección**. La validación visual de esta microcorrección con una APK compilada desde el nuevo HEAD está **NOT_RUN** en este conjunto de evidencias; no se declara PASS de código que aún no se ha instalado.

**Corrección de arnés QA (no app):** `tools/qa_storybook_android.py` ahora decodifica la jerarquía ADB con UTF-8, espera elementos reales para no confundir la splash con la portada, reconsulta las coordenadas del tablero tras desaparecer la ayuda inicial, y solo reporta victoria cuando la interfaz muestra «MISIÓN CUMPLIDA». La ronda completa en RC6: `STORYBOOK_EXIT=0` y 7 checks positivos. La fotografía de splash tomada antes del último ajuste fue **excluida** y sustituida en esta carpeta por captura real de portada.

**Pruebas locales:** `tools/validate_ux_content.py` **PASS**: 300 niveles, 2524 vínculos de pistas, 2149 versículos directos, 375 referencias temáticas, 10 acrósticos, 66 libros; `python -m py_compile` del QA script **PASS**; `git diff --check` **PASS**.

**CI fuente RC6 original:** [run 44791571766 SUCCESS](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/actions/runs/44791571766) (ensamble, validador de bancos y tests JVM). **Runner visual Ubuntu anterior:** [run 44791562753 FAIL boot](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/actions/runs/44791562753) sin capturas; es fallo de arranque AVD, **no** evidencia de defecto funcional. El nuevo HEAD debe evaluarse independientemente.

**Restricciones:** no se modifica ni rehace campaña, Biblia, iOS, Google A6; no se fusiona PR ni se declara RC6 release definitiva. La aprobación visual sigue siendo responsabilidad del Supervisor.
