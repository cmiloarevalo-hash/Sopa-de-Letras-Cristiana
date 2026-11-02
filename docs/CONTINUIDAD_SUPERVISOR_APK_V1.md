# Continuidad de ejecución para el Supervisor — primera APK

**Versión:** v001, 2026-11-01. **Tipo:** orientación para preparar Work Items, no Work Item activo ni canal de entrega al Supervisor. **Intención del Humano:** los agentes han de avanzar con autonomía técnica suficiente hasta entregar una primera APK instalable, sin pedir aprobación del Humano por cada detalle menor.

## Decisión vigente sobre interlocutores y handoffs (Humano, 2026-11-02)

Este proyecto se comunica con **dos IA interlocutoras**: **Jefe de Agente IA** y **Supervisor**. El Supervisor gobierna la implementación técnica y las interacciones internas con Delfín/Implementer si corresponde; **los handoffs para el Jefe NO se dirigen al Implementer**.

**Separar dos acciones:**
1. **PUBLICACIÓN:** la IA que realiza el trabajo correspondiente **publica el handoff completo y sus referencias verificables en GitHub**, dentro del Work Item/canal y scopes realmente autorizados. El Humano no escribe ni publica esos handoffs. El Supervisor es responsable de su registro técnico de retorno al Jefe y del aviso corto; el Jefe registra las decisiones humanas que le corresponden cuando esté autorizado.
2. **TRANSPORTE:** el Humano **solo copia el mensaje corto** de un chat al otro (Supervisor → Jefe o Jefe → Supervisor), con el enlace a lo publicado. No transporta informes completos. GitHub guarda evidencia, **no entrega por sí mismo al chat receptor**.

**Aviso corto Supervisor → Jefe:** `PARA: Jefe`, `PROYECTO`, `WORK_ITEM/ACTIVIDAD`, `URL exacta del handoff publicado`, `HEAD/PR (si aplica)`, `acción solicitada`. Una publicación sin URL o destinatario verificable no equivale a handoff entregado.

**V3 y ruta real:** `ProjectLead` es un **rol de referencia**, no un `SEND_TO` técnicamente acreditado. No fabricar mensajes enrutados `SEND_TO: ProjectLead`, ni usar `SEND_TO: Implementer` para un informe que va al Jefe. Ante falta de canal de enrutamiento automático comprobado, mantener la publicación documental autorizada y transportar **solo el aviso** por el Humano. Respetar la distinción `PUBLISHED != DELIVERED != RESPONDED != EXECUTED != ACCEPT`. El implementador, cuando exista, mantiene sus handoffs **separados e internos** conforme al contrato Supervisor ↔ Implementer de Workflow V3.

**Esto no significa una IA trabajando sola en segundo plano.** Las IA realizan sus publicaciones en las sesiones/tareas efectivamente iniciadas y autorizadas. No crear bots, vigilancias, servicios de mensajes ni prometer reanudación automática.

**Documento operativo de proyecto:** [Plan de las cinco actividades y arquitectura mínima](PLAN_BASE_5_ACTIVIDADES_APK.md), que define el único control visual previo a la APK y la autonomía técnica del Supervisor.

## Reglas de autoridad y continuidad
Cadena **HUMANO → JEFE → SUPERVISOR → DELFÍN**. El Jefe documenta decisiones humanas; el Supervisor verifica autenticidad, alcance, actor, baseline y permisos, dirige la ingeniería y revisa entregables. Cada actividad material requiere Work Item durable de Workflow V3 con `Objective`, `Acceptance Criteria`, `Authorized Scope`, `Relevant Sources`, `Local Verification`, `Required CI` y `Base SHA`. Cumplir Semantic/Path/Resource Scope.

**La delegación buscada es autonomía técnica dentro de las tareas autorizadas, no ejecución automática permanente entre conversaciones.** Este archivo **no** activa Jefe Activo, Supervisor, Implementer ni otro agente, y no constituye prueba de recepción o de trabajo iniciado. Ningún mensaje de chat se asume reenviado; la entrega debe verificarse por un canal autorizado.

## Punto de partida comprobado
**Repositorio:** `cmiloarevalo-hash/Sopa-de-Letras-Cristiana`. A fecha de revisión 2026-11-01 no aparecieron Issues ni PR; no se ha acreditado un Supervisor ejecutando esta especificación. El proyecto original Kotlin/Compose, bajo licencia MIT, aporta el motor y la estructura de 300 niveles; no sustituye pruebas propias del fork.

**Producto rector:** [ALCANCE_PRIMER_APK_V1.md](ALCANCE_PRIMER_APK_V1.md), [OBJETIVO_PRODUCTO_CRISTIANO.md](OBJETIVO_PRODUCTO_CRISTIANO.md), [MARCO_VISUAL.md](MARCO_VISUAL.md), [MARCO_EDITORIAL.md](MARCO_EDITORIAL.md), [MARCO_LITERARIO.md](MARCO_LITERARIO.md).

**Visual madre comprobada:** [PNG original aprobado en Drive](https://drive.google.com/file/d/1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03/view?usp=drivesdk), recurso `SLC-VIS-001/v001`, nombre real `aventura_biblica_moderna_aprobada.png`, 2.362.665 bytes, carpeta de imágenes Drive. Archivo **privado**: confirmar acceso real del actor antes de afirmar que fue revisado. El PNG no está integrado como blob en GitHub.

## Etapas sugeridas para planificar, sin imponer soluciones técnicas
1. **Línea base:** identificar HEAD/ref, compilación original, CI y funcionamiento de generación.
2. **Contenido:** RV1909, bancos españoles, reglas editoriales, pistas, verificación factual y validadores para 300 niveles resolubles.
3. **Identidad:** adaptación de las cinco pantallas principales conforme al PNG madre y marcos escritos, sin apropiarse de un diseño del repositorio Biblia para Jóvenes.
4. **Experiencia:** progreso, perfil local/apodo, ayudas, estrellas, logros, álbum y persistencia offline.
5. **Integración y pruebas:** regresión del motor, dificultad infantil-juvenil, acceso sin red, revisión visual, accesibilidad y rendimiento.
6. **APK candidata:** identificar versión, firma adecuada para prueba, commit, artefacto, SHA-256, informe de pruebas y guía de instalación; el Humano hace la prueba física en su teléfono.

La dependencia de una clave de firma de distribución pública o de una cuenta Play **no bloquea** trabajos de UI, bancos o pruebas de desarrollo. Evitar APKs por cada microcambio y complejidad no solicitada.

## Decisiones que se pueden resolver en ejecución técnica
Estructura del código, formatos de datos, implementación del generador y banco, diseño de pruebas, compatibilidad entre modos, medidas de rendimiento, nombres de recursos auxiliares y solución de problemas de CI, siempre dentro del objetivo, marcos y scopes aprobados. El Supervisor puede organizar fases y corregir defectos comprobados sin pedir al Humano decisiones menores.

## Reservadas al Humano
Cambiar 300 niveles/10 mundos, orientación cristológica, público infantil-juvenil, fuente RV1909, referencia visual aprobada de forma material, monetización/cuentas/red, exponer datos de menores, pagar servicios, conceder credenciales, distribuir APK públicamente o subir a Google Play. El teléfono del Humano no se accede ni instala sin permiso concreto. Ante choque legal/denominacional no resoluble técnicamente, documentar alternativas y elevar solo esa decisión.

## Entrega que cuenta como hito
Una APK comprobable y transferible al Humano con nombre, versión, SHA-256, commit, resultados de test, cobertura de 300 tableros, limitaciones, instrucciones de instalación y declaración explícita de pruebas físicas completadas o pendientes. `build success` no equivale a `APP INSTALADA`; `Supervisor ACCEPT` no equivale a autorización de publicación externa.

**Continuidad entre sesiones:** reconstruir desde GitHub (Work Item, PR, commits, checkpoints y revisiones). **ON_DEMAND_ONLY para el Jefe**: no prometer vigilancia o trabajo en segundo plano. Este documento deja la misión preparada para un arranque posterior realmente autorizado y verificable.
