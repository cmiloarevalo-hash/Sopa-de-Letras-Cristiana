# A5 · Evidencia de APK técnica de integración (2026-11-03)

**Work Item:** #6. **Estado:** TECHNICAL_APK_BUILT / JVM_TESTS_PASS / SUPERVISOR_REVIEW_PENDING / VISUAL_REVIEW_PENDING / PHYSICAL_TEST_PENDING. La APK es una **construcción técnica de integración**, no una candidata aceptada ni una publicación.

## Fuente exacta y alcance

- Repositorio: cmiloarevalo-hash/Sopa-de-Letras-Cristiana.
- Rama: implementer/a5-integration-apk-20261103 (PR #13, abierto en borrador, sin merge).
- **SHA de código compilado y probado:** 44aafe36568d0fa4ff5d11fae401bb38817cdf8d.
- PR apilados A1 #9, A2 #10, A4 #11 y A3 #12: continúan sujetos a revisión independiente del Supervisor.
- Identificador Android debug: app.sopadeletras.cristiana.debug; versionCode 24; versionName 1.0.5-candidate-dev; minSdk 26; targetSdk 36.
- Firma validada con apksigner: Android Debug (CN=Android Debug). Ninguna clave de publicación involucrada.

## Compilación REAL y APK preservada

- Equipo Windows autorizado, Java 17, Gradle 9.8.0 y Android SDK Platform 37.2 (instalada automáticamente por Gradle con licencia ya aceptada).
- Comando ejecutado en el checkout exacto: .\gradlew.bat assembleDebug --no-daemon.
- **Resultado:** BUILD SUCCESSFUL, exit code 0 (última ejecución: 36 tareas up-to-date).
- Ruta de salida efectiva: app/build/outputs/apk/debug/app-debug.apk.
- Tamaño: **14031411 bytes**.
- **SHA-256:** 4AD41EF324CFA3930F8DEA37C5E4F17FADF1908C5718215CDE253BCBDB846E12.
- Copia privada conservada en el equipo Windows: C:\Users\cmilo\Downloads\SopaDeLetras-Integracion-20261103\app-debug-44aafe3.apk.
- Log correspondiente: C:\Users\cmilo\Downloads\SopaDeLetras-Integracion-20261103\build-a5-44aafe3.log.
- Comprobación de copia con Get-FileHash y verificación de firma con apksigner: PASS. La copia anterior app-debug-03b23e3.apk tiene los mismos bytes y digest, pues el último cambio solo actualizó pruebas.

## QA ejecutada sobre el mismo código

- Comando: .\gradlew.bat testDebugUnitTest --no-daemon.
- **Resultado:** BUILD SUCCESSFUL, exit code 0; **84 tests / 0 failures / 0 errors / 0 skipped** en 19 reportes XML de JUnit.
- Log conservado: C:\Users\cmilo\Downloads\SopaDeLetras-Integracion-20261103\test-a5-all-44aafe3.log.
- La dependencia Gradle validateWords pasó con resultado "validate_words: ok". Por separado, py -3 tools/validate_words.py dio PASS.
- SpanishCampaignBoardsTest recorre los niveles 1–300, diez bancos es-ES y tamaños de tablero 6, 8, 10 y 12, con semillas reproducibles; verifica número de palabras, rutas en el tablero, direcciones permitidas, unicidad en niveles normales y palabras de misterio legibles. **PASS en A5**.
- Esta comprobación del generador no sustituye pruebas de interacción, reinicio, conectividad, dispositivos físicos ni revisión editorial final.

## Fallos reproducibles corregidos

1. Build inicial del código 9d47dac26152cb4982094baf5881fd0191e3bac5: FAIL en compileDebugKotlin; Campaign.kt líneas 40, 41 y 49 usaba dos literales enteros 0 y uno 1 donde se esperaba Double. A2 PR #10 corrigió el origen en 028f1244987e0fef09c7b84e73ef5afe4ef5feea y A5 incorporó la misma corrección en ab071721e48c9f7f88f2dff119e91cd40a1dad89.
2. Test JVM bloqueado en Windows por la invocación python3 ausente. A5 cambió solo la elección de lanzador en app/build.gradle.kts (Windows: py -3, otros: python3), commit 74042866f653a45e4fccfd561ab9d63c0ed7028b.
3. Test nuevo A2 en la rama aislada b86dc63cd029f4129155cf33e7c1467a43335fb7 detectó L178 / banco infancia / seed 1409582: SAL aparecía 3 veces. A5 aumentó intentos deterministas de generación de 8 a 128 en c9518d3c2b567abd4d322c9507aa54f7d9a562fb y trasladó la prueba de 300 niveles en 03b23e3598e1a3c198172ab89ae445e91a9e9e76; **A5 PASS**. El PR A2 aislado sigue sin incorporar la modificación al generador: coordinar revisión de pila antes de cualquier integración.
4. Suite JVM inicial A5: 83/84 PASS; la expectativa de GameLogicTest mantenía portugués aunque victorySummary ya devuelve español. Ajuste únicamente de test en 44aafe36568d0fa4ff5d11fae401bb38817cdf8d. Suite completa repetida: 84/84 PASS.

## CI y límites de la entrega

- Consulta a GitHub Actions el 2026-11-03: total_count=0, sin runs ni artifacts del repositorio observables. No inferir que Actions está deshabilitado; no reportar PASS de CI remoto. El build anterior es una ejecución local REAL, no un run de Actions.
- Gate visual A3 de revisión única del Humano: PENDING. Revisión independiente del Supervisor de commits, PR, licencias y QA: PENDING. No hay ACCEPT ni merge.
- Pruebas de instalación/desinstalación por el Humano, emulador, teléfono físico, navegación completa, reinicio, progresión persistida y offline: PENDING/NOT_RUN. No se realizó instalación remota.
- PR #7 y PR #9–#13 permanecen abiertos/draft según sus revisiones respectivas; no se realizó merge, tag, release, Play ni distribución externa.
- El archivo se preservó **solo localmente en el entorno Windows autorizado**. No hay artefacto publicado por GitHub Actions ni descarga pública.

## Instalación privada, sujeta a autorización humana

Para una prueba futura, identificar y copiar la APK local, comparar el SHA-256 anterior, instalarla solo mediante una decisión del Humano en su dispositivo y desinstalar desde Ajustes > Aplicaciones al terminar. El éxito técnico del build no certifica todavía su funcionamiento en un teléfono real.
