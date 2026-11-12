**Handoff actualizado 11-11-2026 — PRIORIDAD DE EXPERIENCIA:** implementar las listas EXACTAS de [los 300 niveles](CATALOGO_300_NIVELES_V1.md) a partir del [JSON](data/campana_300_niveles_v1.json), no de los 70 términos aleatorios anteriores. 30 episodios, tamaño 6×6 a 12×12, 10 misterios, 2.545 apariciones de palabras y simulación de colocación 300/300 independiente (NO test Android). Integrar Google A6 #15 **solo al final** cuando el juego principal y APK offline estén listos. [Especificación maestra](ESPECIFICACION_MAESTRA_APK_CRISTIANA_V1.md).

> **Actualización de continuidad (2026-11-11):** [Especificación maestra unificada](ESPECIFICACION_MAESTRA_APK_CRISTIANA_V1.md) concentra los 10 mundos, catálogos editoriales, referencias, árbol de ramas, pruebas y nueva necesidad de Google; las propuestas de palabras no equivalen aún a implementación. Para cualquier reanudación, consultar la rama/PR documental y el estado real de HEAD de A1–A5. No reabrir objetivos ya aprobados.

# Continuidad de ejecución para el Supervisor — primera APK

**Versión:** v001, 2026-11-01. **Tipo:** orientación para preparar Work Items, no Work Item activo ni canal de entrega al Supervisor. **Intención del Humano:** los agentes han de avanzar con autonomía técnica suficiente hasta entregar una primera APK instalable, sin pedir aprobación del Humano por cada detalle menor.

## Decisión expresa del Humano (2026-11-03): todos los agentes, continuidad y seguridad por alertas

**Regla obligatoria para todos los agentes del proyecto (Jefe, Supervisor, Delfín/Implementer y otros agentes autorizados):** queda **PROHIBIDO agregar instrucciones, requisitos, condiciones, verificaciones, controles o responsabilidades inventadas por el agente que generen bloqueos, esperas o interrupciones** del desarrollo o de los programas. Las propuestas propias no son órdenes del Humano ni deben imponerse como condiciones de avance. Respetar Workflow V3 y los límites de autoridad y permisos realmente aplicables, sin añadir obstáculos por iniciativa propia.

**Seguridad de los programas:** ante incidencias o riesgos ordinarios se deben emitir **avisos o alertas informativos**, sin impedir el funcionamiento del programa ni paralizar el trabajo autorizado. **Solo una situación de seguridad extrema, concreta y justificada puede motivar un bloqueo de seguridad.** No convertir una advertencia, una incertidumbre menor, una preferencia técnica o una comprobación opcional en veto. Las prohibiciones técnicas o de autorización que realmente sean obligatorias no quedan derogadas por esta regla.

**Continuidad:** si existe un impedimento puntual, registrarlo y proseguir con las demás tareas autorizadas e independientes; resolverlo sin exigir al Humano activaciones o aprobaciones rutinarias. El Supervisor mantiene la dirección técnica; el Jefe no asigna por cuenta propia nuevos controles ni tareas de administración del transporte.

**Transporte y límites del Jefe:** los agentes publican los handoffs por los Issues autorizados del repositorio; el software de Windows realiza su transporte mecánico según lo indicado por el Humano y **para el Jefe es solo lectura**. No imponer modificaciones ni reconfiguraciones de ese software. La publicación no demuestra por sí sola recepción.

**Precedencia respecto de sugerencias anteriores:** cualquier propuesta del Jefe de añadir condiciones para el canal, supervisión de Windows o controles no autorizados que pudiera bloquear el desarrollo queda expresamente **sin efecto como instrucción**. Esta regla es una **decisión del Humano**, no una propuesta técnica del Jefe.

## Decisión vigente sobre interlocutores y handoffs (Humano, 2026-11-02)

Este proyecto se comunica con **dos IA interlocutoras**: **Jefe de Agente IA** y **Supervisor**. El Supervisor gobierna la implementación técnica y las interacciones internas con Delfín/Implementer si corresponde; **los handoffs para el Jefe NO se dirigen al Implementer**.

**Separar dos acciones:**
1. **PUBLICACIÓN:** la IA que realiza el trabajo correspondiente **publica el handoff completo y sus referencias verificables en GitHub**, dentro del Work Item/canal y scopes realmente autorizados. El Humano no escribe ni publica esos handoffs. El Supervisor es responsable de su registro técnico de retorno al Jefe y del aviso corto; el Jefe registra las decisiones humanas que le corresponden cuando esté autorizado.
2. **TRANSPORTE (decisión humana posterior, 2026-11-03):** el software de Windows realiza el transporte mecánico. Para el Jefe es de **solo lectura**. No exigir al Humano traslado o activación manual por Issue. GitHub conserva evidencia de publicación, pero esa publicación por sí sola no acredita recepción.

**Aviso corto Supervisor → Jefe:** `PARA: Jefe`, `PROYECTO`, `WORK_ITEM/ACTIVIDAD`, `URL exacta del handoff publicado`, `HEAD/PR (si aplica)`, `acción solicitada`. Una publicación sin URL o destinatario verificable no equivale a handoff entregado.

**V3 y ruta real:** `ProjectLead` es un **rol de referencia**, no un `SEND_TO` técnicamente acreditado. No fabricar mensajes enrutados `SEND_TO: ProjectLead`, ni usar `SEND_TO: Implementer` para un informe que va al Jefe. Ante falta de recepción verificable, mantener el registro documental autorizado sin crear bloqueos, obligaciones nuevas sobre el software ni responsabilidades manuales para el Humano. Respetar la distinción `PUBLISHED != DELIVERED != RESPONDED != EXECUTED != ACCEPT`. El implementador, cuando exista, mantiene sus handoffs **separados e internos** conforme al contrato Supervisor ↔ Implementer de Workflow V3.

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
