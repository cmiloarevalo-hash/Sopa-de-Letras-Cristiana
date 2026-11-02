# Handoff de recepción y prearranque — Supervisor → Jefe

**Proyecto:** Sopa de Letras Cristiana  
**Fecha:** 2026-11-02 · **Versión:** v001 · **Autor del registro:** Supervisor en sesión iniciada por instrucción directa del Humano  
**Tipo:** registro documental de recepción, diagnóstico y propuesta de Work Items. **No es** mensaje técnico enrutado Supervisor ↔ Implementer ni aceptación de implementación.  
**MESSAGE_CLASS:** DOCUMENTATION_ONLY / NOT_ROUTING  
**Destinatario informativo:** Jefe de Agente IA, mediante traslado manual de **aviso corto** por el Humano. Este archivo **no** prueba entrega al chat del Jefe.  
**Estado:** HANDOFF RECIBIDO; PREARRANQUE DOCUMENTAL EJECUTADO; ACTIVACIÓN DE WORK ITEMS BLOQUEADA POR CONFIGURACIÓN DE GITHUB; CÓDIGO/CI/APK NO EJECUTADOS.

## 1. Autoridad y preflight

- **Orden actual:** el Humano dirigió directamente al Supervisor la misión de gobernar la primera APK Android y organizar cinco actividades/Work Items, publicar handoff completo con evidencia y preparar solo aviso corto para el Jefe. Esta recepción es **en esta sesión**, no un ACK de Actuador.
- **Handoff de origen leído:** [2026-11-02_JEFE_A_SUPERVISOR_APK_V001.md](2026-11-02_JEFE_A_SUPERVISOR_APK_V001.md); es documentación de producto, **no** Work Item/activación ni mensaje de transporte técnico.
- **Workflow V3 oficial consultado:** [WORKFLOW_PLAN.md](https://github.com/cmiloarevalo-hash/workflow/blob/main/docs/WORKFLOW_PLAN.md) y [WORKFLOW_FOUNDATIONS.md](https://github.com/cmiloarevalo-hash/workflow/blob/main/docs/WORKFLOW_FOUNDATIONS.md), repositorio privado `cmiloarevalo-hash/workflow`, HEAD `91e6b2b3851a95c01ba930b5ed9d792c7225b7b7`, `WORKFLOW_PLAN.md` ACTIVE/CONTROL. Aplican §§3, 4, 5, 6, 9, 11, 18, 20.
- **Repositorio de producto:** `cmiloarevalo-hash/Sopa-de-Letras-Cristiana` público; acceso GitHub conectado con permisos `pull`/`push`/`admin`, **capacidad técnica distinta de autoridad**. `main` observado antes de este registro en `849fb8ac0d8a969bb47d7c25f6cef711bce71818`; rama única `main` (consulta de ramas). No se hallaron Issues ni PR en búsqueda inicial.
- **Límites del mandato:** 10 mundos × 30 niveles = 300, español cristiano con base RV1909, Jesús como guía pedagógica, mundo 3 Diluvio, pistas, tres estrellas por nivel (900 máximo), apodo local, álbum/logros y progreso persistente, sin red obligatoria, anuncios, compras, cuentas o backend. **Única revisión humana anterior a la APK:** propuesta visual consolidada; después prueba física de la APK por el Humano. Sin autorización de Google Play ni distribución pública.
- **No activado:** Delfín/Implementer, GoFlow ni canal automático Jefe. No hay evento `SUPERVISOR_ROUTING`, revisión `ACCEPT`, merge, despliegue ni publicación de software.

## 2. Hallazgo bloqueante de GitHub

El intento efectivo de `create_issue` para A1 devolvió **HTTP 410** de GitHub: `Issues has been disabled in this repository.` Por tanto:
- **Cero Work Items GitHub Issues creados**, cero números de Issue y cero rutas de mensajes Supervisor ↔ Implementer verificables.
- La instrucción humana autoriza **organizar y preparar** el trabajo; no se infiere permiso adicional para **cambiar ajustes administrativos** del repositorio ni para inventar un Work Item en otro repositorio/canal.
- Los apartados de §4 son **borradores íntegros de Work Items pendientes**, no Work Items activos ni permiso para implementar. El bloqueo afecta creación/enrutamiento de Work Items y, por consiguiente, desarrollo material que los requiera; **no** invalida análisis de lectura ya realizado.
- **Condición de desbloqueo:** habilitar Issues en **este repositorio** mediante autorización/acción administrativa competente, o designar formalmente un mecanismo de Work Item compatible con V3. Revalidar contrato/canal antes del primer mensaje técnico. No pedir al Humano detalles rutinarios de tecnología.

`BLOCK_SCOPE: creación de Issues y activación de tareas materiales`  
`REASON_EVIDENCE: GitHub API create_issue → HTTP 410 / Issues has been disabled in this repository`  
`CRITICAL_GATE_EFFECT: no es posible establecer los cinco Work Items activos ni arrancar implementación gobernada`  
`CONTINUE_ALLOWED: lectura, análisis y documentación expresamente solicitada; no cambios de código o infraestructura`  
`NEXT_ACTOR: Humano o administrador autorizado del repositorio`  
`NEXT_ACTION: habilitar Issues o autorizar destino alternativo de Work Items V3`  
`UNBLOCK_CONDITION: creación real de Work Item verificable en GitHub`  
`OWNER_ACTION_REQUIRED: resolver configuración de Issues / canal de Work Items`  
`OWNER_NOTICE_STATUS: PUBLISHED_UNCONFIRMED (solo si este registro se publica; traslado manual pendiente)`

## 3. Estado técnico realmente observado

| Control | Evidencia y resultado |
|---|---|
| Línea base Android | Kotlin + Compose, `core/` con `Campaign.kt`, `PuzzleGenerator.kt`, `Selection.kt`, `Scoring.kt`; `data/GameDataStore.kt` ya usa DataStore. |
| Campaña | `Campaign.kt` declara `TOTAL_LEVELS = 300`, `LEVELS_PER_WORLD = 30`; sus diez mundos siguen con nombres en portugués. **No** demuestra 300 niveles bíblicos válidos. |
| Idioma/bancos | `CampaignContent.kt` y `app/src/main/assets/words/{pt-PT,en-US}/`; los bancos y rótulos españoles bíblicos definitivos no están implementados. |
| CI | `.github/workflows/ci.yml` especifica `validate_words.py`, `testDebugUnitTest`, `assembleDebug` y artifact `app-debug`. API `actions/runs?per_page=10` devolvió `total_count: 0`. **Ninguna CI ejecutada acreditada en el fork**. |
| Android | `app/build.gradle.kts`: `applicationId = "app.sopadeletras"`, `minSdk = 26`, `targetSdk = 36`, `versionName = "1.0.5"`; AndroidManifest declara `VIBRATE` y `allowBackup=true`. Identidad y política de copia de seguridad requieren revisión proporcional, no servicios nuevos. |
| Licencia base | `LICENSE`: MIT, copyright Tiago Correia 2026; conservar avisos de licencia. Fuente RV1909/edición digital para citas concretas **aún por verificar**. |
| Imagen aprobada | [Drive `SLC-VIS-001/v001`](https://drive.google.com/file/d/1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03/view?usp=drivesdk) abierta mediante conexión autorizada: `aventura_biblica_moderna_aprobada.png`, PNG 1536×1024, 2.362.665 bytes, huella SHA-256 local `d3a54bd0be946bf3b3f37bb700bc17467b16c1c84a5ed1f153cd1cb7dffc441e`. Imagen conceptual **ya aprobada como estilo**; no aprobó nuevos nombres de mundos ni la UI final. No cambiar permisos de Drive. |
| Build/APK | No se corrieron Gradle, compilación Android ni tests de ejecución en esta sesión. **Sin APK cristiana, sin tamaño, firma ni checksum de APK**, sin prueba física del Humano. |

**Decisión de mínima ingeniería:** reutilizar el proyecto actual **Compose ↔ core ↔ bancos locales y DataStore**, sujeto a mediciones y comprobación. No incluir Firebase, servicios, cuentas, telemetría, orquestadores, nuevos motores ni capas de seguridad sin defectos concretos. Medir bytes de APK real al compilar; no fijar MB arbitrarios.

## 4. Cinco Work Items propuestos — borradores NO ACTIVOS

Los siguientes contratos deben convertirse en **cinco Issues concretos**, uno por actividad material, **cuando GitHub lo permita**. La gramática de los Issues usa los siete apartados V3: Objective, Acceptance Criteria, Authorized Scope, Relevant Sources, Local Verification, Required CI, Base SHA. Los scopes indicados son máximos de propuesta y **no delegación operativa** hasta creación/validación de los Issues. Baseline inicial común: `main@849fb8ac0d8a969bb47d7c25f6cef711bce71818`; comprobar SHA vigente al activarlos.

### A1 — Base Android e ingeniería mínima
- **Objective:** auditar el fork, comprobar base reproducible y acordar interfaces de datos mínimas.
- **Acceptance Criteria:** registrar dependencias/licencia/permisos/SDK/Gradle/identificador; ejecutar validadores, tests y `assembleDebug` en entorno autorizado o documentar bloqueo reproducible; conservar motor de juego y DataStore cuando funcionen; precisar contratos con A2/A4 y comparar tamaño base si se genera artefacto.
- **Authorized Scope:** *Semantic:* correcciones de base e interfaces indispensables, sin ampliar producto; *Path:* `app/build.gradle.kts`, `build.gradle.kts`, `settings.gradle.kts`, `gradle/**`, `gradle.properties`, `app/src/main/AndroidManifest.xml`, `app/src/main/java/app/sopadeletras/core/**`, `app/src/test/**`, `.github/workflows/ci.yml`, `tools/validate_words.py`; *Resource:* checkout/branch, ejecución local o CI GitHub existente; no credenciales, cuentas pagadas, dispositivos, tags/releases.
- **Relevant Sources:** `docs/ALCANCE_PRIMER_APK_V1.md`, este diagnóstico, `Campaign.kt`, `GameDataStore.kt`, Gradle, CI, LICENSE, V3.
- **Local Verification:** `python3 tools/validate_words.py`, `./gradlew testDebugUnitTest`, `./gradlew assembleDebug` con resultados exactos.
- **Required CI:** job `CI` de PR/commit pertinente; si ausente, registrar `NOT_RUN`.
- **Base SHA:** `849fb8ac0d8a969bb47d7c25f6cef711bce71818`; actualizar/reconciliar al abrir Issue.
- **Salida:** baseline verificable o bloqueo técnico preciso, sin alegar APK cristiana.

### A2 — Contenido RV1909 y 300 niveles
- **Objective:** campaña española de diez mundos/300 tableros verificables; Diluvio en mundo 3, Jesús guía sin citas ficticias.
- **Acceptance Criteria:** mapa 10×30 conforme a objetivos; bancos/pistas/referencias editoriales con trazabilidad de edición/uso RV1909; 300 niveles generables y resolubles con semillas deterministas, sin palabras portuguesas visibles; dificultad progresiva 6×6..12×12 adaptada al motor; revisar nivel 10/20/30 y contenido no gráfico; sin reproducir texto digital de derechos no confirmados.
- **Authorized Scope:** *Semantic:* datos bíblicos, vocabulario, pistas, niveles, validadores y tests; *Path:* `app/src/main/assets/words/**`, `app/src/main/java/app/sopadeletras/core/Campaign.kt`, `app/src/main/java/app/sopadeletras/data/CampaignContent.kt`, `app/src/main/java/app/sopadeletras/data/WordRepository.kt`, `tools/validate_words.py`, `app/src/test/**`; *Resource:* fuentes textuales legales verificadas, GitHub y pruebas locales; no copiar corpus externo, ilustraciones protegidas ni usar servicios de pago.
- **Relevant Sources:** `OBJETIVO_PRODUCTO_CRISTIANO.md`, `MARCO_EDITORIAL.md`, `MARCO_LITERARIO.md`, `ALCANCE_PRIMER_APK_V1.md`, motor A1.
- **Local Verification:** validador por palabras, pruebas de longitud/sin duplicados/referencias, generación determinista de 300 niveles y comprobación de todas las ubicaciones buscables, no solo conteo.
- **Required CI:** tests de bancos/300 tableros y CI de PR.
- **Base SHA:** `849fb8ac0d8a969bb47d7c25f6cef711bce71818`, más la interfaz A1 integrada o fixture acordada cuando proceda.
- **Salida:** campaña jugable comprobada; incertidumbres de derechos o doctrina documentadas sin bloquear datos independientes.

### A3 — Identidad visual y única revisión humana consolidada
- **Objective:** aplicar el estilo `SLC-VIS-001/v001` a la experiencia real, sin copiar «Biblia para Jóvenes», y presentar **un único paquete visual** para revisión del Humano.
- **Acceptance Criteria:** propuesta consistente de portada, inicio, mapa, tablero, victoria y vista de álbum/logros; corrección de nombres de los diez mundos según la especificación actual; legibilidad, navegación táctil, tratamiento apropiado de Jesús y texto alternativo donde sea necesario; comparación con la imagen madre y evidencia de pantallas, antes de cerrar el diseño.
- **Authorized Scope:** *Semantic:* tema, recursos propios/transformaciones permitidas y UX sin cambiar lógica de campaña; *Path:* `app/src/main/java/app/sopadeletras/ui/**`, `app/src/main/res/**` y pruebas UI pertinentes; *Resource:* **lectura** de PNG privado Drive ID `1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03` ya comprobado; creación de recursos gráficos propios en rutas de app una vez exista WI; **no** cambiar permisos Drive ni producir publicación pública.
- **Relevant Sources:** `MARCO_VISUAL.md`, `REFERENCIAS_VISUALES.md`, `RECURSOS_DRIVE_VERSIONADO.md`, imagen madre, objetivos actuales.
- **Local Verification:** contraste de pantallas en tamaños representativos, legibilidad/contraste, equivalencia de información y revisiones de UI del Supervisor.
- **Required CI:** compilación/tests UI disponibles cuando haya código.
- **Base SHA:** `849fb8ac0d8a969bb47d7c25f6cef711bce71818`, reconciliando interfaces con A4.
- **CRITICAL_GATE:** **revisión visual consolidada del Humano** previa al cierre de diseño de la primera APK; aprobación de la imagen madre no sustituye esa revisión. No solicitar microaprobaciones.

### A4 — Juego offline, pistas, perfil y recompensas
- **Objective:** flujo completo de 300 niveles con progreso local, pistas útiles, estrellas, álbum, insignias y apodo editable sin cuenta.
- **Acceptance Criteria:** selección de palabras jugable, pistas escalonadas, guardado/restauración tras reiniciar, hasta 3 estrellas por nivel/900 total, desbloqueo de mundos/álbum/logros, apodo local editable/borrable, cero red requerida ni anuncios/cobros; evitar penalización que bloquee menores.
- **Authorized Scope:** *Semantic:* integración de reglas/jugabilidad/progreso offline; *Path:* `app/src/main/java/app/sopadeletras/core/**`, `app/src/main/java/app/sopadeletras/data/**`, `app/src/main/java/app/sopadeletras/ui/**`, `app/src/test/**`; *Resource:* almacenamiento local DataStore y pruebas de dispositivo/emulador **solo en entorno autorizado**, sin acceder al teléfono del Humano ni solicitar permisos sensibles.
- **Relevant Sources:** objetivos, alcance, marcos editoriales, interfaces de A1/A2 y referencia de A3.
- **Local Verification:** tests de progresión/estrellas/pistas y persistencia al reiniciar, modo sin red, validación de perfil; comprobación funcional en emulador autorizado cuando disponible.
- **Required CI:** tests de lógica/regresión y compilación.
- **Base SHA:** `849fb8ac0d8a969bb47d7c25f6cef711bce71818`, reconciliando interfaz con A1/A2/A3.
- **Salida:** prototipo integrado jugable, pendiente de QA A5.

### A5 — Calidad, integración y primera APK candidata
- **Objective:** integrar lo aprobado de A1–A4 y producir **APK debug/de prueba** Android reproducible, verificable e instalable para la prueba del Humano.
- **Acceptance Criteria:** verificación exhaustiva 300 niveles, español y offline, regresión/tamaños de pantalla, persistencia, sin permisos/red innecesarios; evidencia de CI y revisión independiente del Supervisor sobre HEAD exacto; comparar tamaño real APK con referencia; registrar nombre, versión, `applicationId`, firma de prueba, SHA-256 del binario, bytes, commit, incidencias y guía de instalación; **prueba física del Humano marcada PENDIENTE** hasta que realmente ocurra.
- **Authorized Scope:** *Semantic:* integración, correcciones estrictas de QA y packaging de **prueba privada**; *Path:* `app/**`, `tools/**`, `.github/workflows/ci.yml`, archivos Gradle, documentación de pruebas bajo `docs/**`; *Resource:* CI/build artifact GitHub y herramientas de build existentes, sin tags que disparen release público, sin secretos de distribución, Google Play o envío a terceros.
- **Relevant Sources:** Issues/PR revisados A1–A4 cuando existan, alcance, licencia, V3, resultados de test y registro visual del Humano.
- **Local Verification:** validador + unit tests + `assembleDebug`, comprobaciones de instalación/arranque sin atribuir prueba del Humano, pruebas funcionales y hash `sha256sum` de APK.
- **Required CI:** PR `CI` verde sobre HEAD final; si un check falla o está ausente, registrar el hecho y decisión técnica.
- **Base SHA:** `849fb8ac0d8a969bb47d7c25f6cef711bce71818` como origen del programa, **target de integración real** se determinará al crear el WI.
- **GATE:** no cerrar diseño/entrega APK candidata sin revisión visual consolidada previa; no confundir APK compartida de prueba con publicación pública.

## 5. Dependencias, paralelización y siguiente acción

`DEPENDENCY_CHAIN:` A1 fija contratos base → A2 contenidos y A4 mecánicas consumen interfaces; A3 diseña con imagen vigente y datos de A2; A5 integra cambios revisados de A1–A4 + conformidad visual consolidada.  
`CRITICAL_GATE:` **ahora** habilitación/selección autorizada del registro de Work Items. **Más adelante** revisión visual única antes de cerrar diseño/primera APK. No inventar plazos/CPM.  
`PARALLEL_READY:` mientras falten Issues, solo investigación documental y planificación; tras crearlos, A2/A3/A4 podrán avanzar en paralelo con responsables, interfaces y escrituras no conflictivas.  
`REVIEW:` el Supervisor evalúa **ACCEPT/REWORK/BLOCK/ESCALATE** únicamente sobre entregables reales y estado exacto. No aceptar por CI ni mergear/publicar por posesión de credenciales.

**Prioridad inmediata:** resolver el único bloqueo administrativo real (Issues). Después crear los cinco Issues con sus siete encabezados V3, refs, scopes y nuevo HEAD; registrar checkpoint en Issue gobernante; habilitar trabajo técnico según actores/canales realmente verificados. No se requiere ninguna nueva decisión humana sobre herramientas, bancos o ajustes menores.

## 6. Puntero de aviso al Jefe (transporte exclusivo del Humano)

Usar un **aviso corto** con el enlace de **este archivo ya publicado**, actividad `A1–A5 / PREARRANQUE`, HEAD publicado y acción puntual `informar bloqueo real de Issues y necesidad de habilitar Work Items`. **No** crear `SEND_TO: ProjectLead` ni suplantar a Implementer. La publicación GitHub acredita `PUBLISHED` y no `DELIVERED`/aprobación/ejecución.

**Fuentes canónicas de producto:** [plan](../PLAN_BASE_5_ACTIVIDADES_APK.md) · [alcance](../ALCANCE_PRIMER_APK_V1.md) · [objetivo](../OBJETIVO_PRODUCTO_CRISTIANO.md) · [continuidad](../CONTINUIDAD_SUPERVISOR_APK_V1.md) · [visual](../MARCO_VISUAL.md) · [editorial](../MARCO_EDITORIAL.md) · [literaria](../MARCO_LITERARIO.md).
