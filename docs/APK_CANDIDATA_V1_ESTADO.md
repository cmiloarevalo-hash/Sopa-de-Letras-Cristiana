# A5 · Estado verificable de integración para primera APK de prueba

**Work Item:** #6. **Estado:** SOURCE_INTEGRATION_STAGED / APK_NOT_GENERATED / VISUAL_REVIEW_PENDING. No equivale a aceptación ni a release.

## Línea fuente
- Rama: `implementer/a5-integration-apk-20261103` (encadenada, SIN merges sobre `main`).
- A1: PR #9 · A2: PR #10 · A4: PR #11 · A3: PR #12.
- Android debug: `app.sopadeletras.cristiana.debug`, versión `1.0.5-candidate-dev`; firma debug del SDK cuando se compile; **sin firma de publicación**.
- Campaña española con diez mundos/300 niveles, Noé y el Diluvio en mundo 3, DataStore, apodo local y álbum; el código NO está validado integralmente y las correcciones de PR #7 no se han incorporado por inferencia.

## Orden material
1. Solicitar compilación de debug `./gradlew assembleDebug` y su artefacto en GitHub Actions del SHA exacto. El CI se configuró para producir y subir la APK **antes** de validación de bancos y tests JVM. Los hashes se generan solo si el APK existe realmente.
2. Revisión visual única del Humano de A3 y revisión técnica independiente del Supervisor por SHA/PR. No declarar candidata cristiana final mientras esas puertas sigan pendientes.
3. Después de APK candidata y autorizaciones: `python3 tools/validate_words.py`, `./gradlew testDebugUnitTest`, generación/resolución real de 300 tableros, pruebas de instalación, navegación, recuperación tras reinicio, offline, accesibilidad y derechos editoriales.
4. Si existen defectos, corregir con cambios mínimos, repetir compilación, obtener SHA-256 nuevo y remitir al Supervisor.

## Compilación y guía de prueba (condicional a generar artefacto)

Entorno Android/JDK17+ con SDK Android y licencias: `./gradlew assembleDebug`. Ruta esperada (NO verificada): `app/build/outputs/apk/debug/app-debug.apk`. Ejecutar `python3 tools/check_apk_candidate.py` para bytes, SHA-256 y SHA de código. Descarga por artifact del workflow CI, **no** tags/releases/Play.

Instalación en dispositivo autorizado: descargar APK real, verificar SHA-256, permitir instalación de fuente elegida solo si el Humano decide hacerlo, instalar localmente, verificar arranque sin red y desinstalar desde Ajustes > Aplicaciones. **No** ejecutar instalación remota desde el agente. La prueba física del Humano sigue `PENDING`.

## Límites vigentes
- Entorno local observado: OpenJDK 21; Android SDK/Gradle cache ausentes y DNS hacia GitHub no disponible. CI remota: no se observaron runs al consultar el 2026-11-03.
- No hay APK verificada ni tamaño/bytes/hash/instalación real para declarar.
- PR #7 mantiene `allowBackup=false` propuesto y permanece sin aceptar; no atribuirle integración en esta rama.
- PNG maestro privado de A3 consultado en Drive, sin subir sus bytes al repositorio. Revisión visual humana pendiente.
