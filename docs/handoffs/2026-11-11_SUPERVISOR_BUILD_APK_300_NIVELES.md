# Evidencia de compilación APK privada — campaña exacta de 300 niveles
**Fecha:** 2026-11-11
**Responsable:** Supervisor, bajo orden directa del Humano de iniciar generación APK.
**Estado:** APK **DEBUG TÉCNICA COMPILADA**, pruebas JVM satisfactorias; **NO revisada visualmente por el Humano, NO instalada en Android por esta sesión, NO publicación pública, NO Google**.
**Referencia:** [catálogo exacto de 300 niveles — PR #14](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/pull/14) · [Issue #3](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/3) · [A5 #6](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/6).

## Código exacto probado
- **Repo:** `cmiloarevalo-hash/Sopa-de-Letras-Cristiana`.
- **Base:** `implementer/a5-integration-apk-20261103@a58bbfc9fc7fc8a3ce30d2394b66673d9dbf4898`.
- **Rama:** `supervisor/apk-catalogo-300-20261111`.
- **SHA de código + tests ensamblado:** `6677d5d438f83b42d16b5a777d49b936a9989b85` (los commits documentales posteriores no cambian la APK ya producida).
- El asset `app/src/main/assets/campaign/es-ES/levels-v1.json` contiene 300 niveles, con palabras y mensajes exactos del catálogo editorial.
- `WordRepository.kt` carga datos por nivel en vez de recurrir a bancos genéricos; `MainActivity.kt` aplica esas palabras a la campaña, con mensaje/referencia de episodio en victoria; `PuzzleGenerator.kt` cuenta palíndromos como trayectoria no dirigida e implementa misterio fijo; `MysteryViewModel.kt` adapta la modalidad sin alterar el juego libre; títulos de mundos y cadenas visibles corregidos. Google sigue diferido por orden del Humano.

## Evidencia en Windows conectado
- **Equipo:** Windows autorizado conectado vía Remote Desktop Commander, usuario de ruta `C:\Users\cmilo`; checkout separado `C:\Users\cmilo\Downloads\SopaDeLetras-Build-20261111`.
- **Comando:** `.\gradlew.bat :app:testDebugUnitTest :app:assembleDebug --offline --no-daemon --console=plain` con JDK 17 y Gradle wrapper; resultado `BUILD SUCCESSFUL in 40s` después de adaptar prueba al CRLF de Windows.
- **Tests:** `86 tests`, `0 failures`, `0 errors`, incluido `FixedCampaignBoardsTest` que obliga a usar todas las listas de los niveles 1–300, comprobar las diez respuestas misteriosas y verificar que `ANA` no cuente doble. Banco previo `validate_words: ok`.
- **APK privada generada en el PC (copiada para el Humano):**
  `C:\Users\cmilo\Downloads\Sopa-de-Letras-Cristiana-300-niveles-v1-debug.apk`
- **Tamaño:** `14.099.430 bytes`.
- **SHA-256:** `6B1AE5312766625E9190C7DD610B2A349FB84DF973838F6D3440CA9A59E32597`.
- **Contenido del APK:** ZIP contiene `assets/campaign/es-ES/levels-v1.json`, `199.018` bytes de asset sin comprimir según contenedor, presencia confirmada.
- **aapt:** package `app.sopadeletras.cristiana.debug`, versionCode `24`, versionName `1.0.5-candidate-dev`, minSdk `26`, targetSdk `36`, label `Sopa de Letras Cristiana`.
- **apksigner:** `Verifies`, esquema v2 válido, `Number of signers: 1`.

## Defectos y límites pendientes (no fingir completitud)
1. Los 300 niveles ya usan **palabras concretas** en el código y cuentan con test Kotlin; falta inspección táctil y visual en emulador del proyecto / dispositivo real. La sesión detectó un emulador `Lago1_QA_ASUS_API36` en ejecución y **no lo alteró**, por pertenecer a otro proyecto.
2. El alcance A3 de fidelidad visual al arte aprobado y revisión humana única sigue pendiente; no confundir APK técnica con versión definitiva aprobada.
3. El flujo de Google/Drive A6 #15 **no está implementado**, explícitamente pospuesto por el Humano hasta después de una primera APK offline funcional.
4. El archivo binario permanece **en el PC autorizado**, no se adjuntó a una release pública ni se subió a `main`. El enlace GitHub al código **no** equivale a un enlace de descarga de APK.
5. PRs heredados A1–A5 permanecen abiertos. El cambio de contenido requiere review independiente y reconciliación de PRs bajo Workflow V3. No auto-merge ni publicación.

## Próxima verificación prioritaria
Abrir APK en AVD dedicado/Android físico, recorrer niveles 1, 20, 30, 80, 150, 200, 290 y 300, comprobar solapamientos de pistas, texto de victoria y partida guardada; comparar seis pantallas al PNG aprobado en única revisión visual humana. Verificar Google solo en fase final. Avisos no bloqueantes de problemas ordinarios.
