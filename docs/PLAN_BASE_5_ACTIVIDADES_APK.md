# Plan base de cinco actividades — primera APK

**Proyecto:** Sopa de Letras Cristiana. **Versión documental:** v001 (2026-11-02). **Origen:** decisiones expresas del Humano y organización propuesta por el Jefe. **Estado:** especificación de producto y gestión **para entregar al Supervisor**, no Work Item ni asignación ejecutada.

**Propósito:** disponer de una **APK Android liviana, offline y jugable**, con 300 niveles bíblicos en español, experiencia infantil-juvenil y diseño «Aventura Bíblica Moderna». Reutilizar el proyecto original tanto como resulte viable. La ingeniería detallada y los Work Items corresponden al Supervisor bajo Workflow V3.

## Decisión expresa del Humano (2026-11-03): todos los agentes, continuidad y seguridad por alertas

**Regla obligatoria para todos los agentes del proyecto (Jefe, Supervisor, Delfín/Implementer y otros agentes autorizados):** queda **PROHIBIDO agregar instrucciones, requisitos, condiciones, verificaciones, controles o responsabilidades inventadas por el agente que generen bloqueos, esperas o interrupciones** del desarrollo o de los programas. Las propuestas propias no son órdenes del Humano ni deben imponerse como condiciones de avance. Respetar Workflow V3 y los límites de autoridad y permisos realmente aplicables, sin añadir obstáculos por iniciativa propia.

**Seguridad de los programas:** ante incidencias o riesgos ordinarios se deben emitir **avisos o alertas informativos**, sin impedir el funcionamiento del programa ni paralizar el trabajo autorizado. **Solo una situación de seguridad extrema, concreta y justificada puede motivar un bloqueo de seguridad.** No convertir una advertencia, una incertidumbre menor, una preferencia técnica o una comprobación opcional en veto. Las prohibiciones técnicas o de autorización que realmente sean obligatorias no quedan derogadas por esta regla.

**Continuidad:** si existe un impedimento puntual, registrarlo y proseguir con las demás tareas autorizadas e independientes; resolverlo sin exigir al Humano activaciones o aprobaciones rutinarias. El Supervisor mantiene la dirección técnica; el Jefe no asigna por cuenta propia nuevos controles ni tareas de administración del transporte.

**Transporte y límites del Jefe:** los agentes publican los handoffs por los Issues autorizados del repositorio; el software de Windows realiza su transporte mecánico según lo indicado por el Humano y **para el Jefe es solo lectura**. No imponer modificaciones ni reconfiguraciones de ese software. La publicación no demuestra por sí sola recepción.

**Precedencia respecto de sugerencias anteriores:** cualquier propuesta del Jefe de añadir condiciones para el canal, supervisión de Windows o controles no autorizados que pudiera bloquear el desarrollo queda expresamente **sin efecto como instrucción**. Esta regla es una **decisión del Humano**, no una propuesta técnica del Jefe.

## 1. Cinco actividades y sus resultados

| ID | Actividad | Subcategorías mínimas | Resultado / evidencia de salida |
|---|---|---|---|
| **A1** | **Base Android e ingeniería mínima** | Auditoría del fork; baseline/SDK/build; motor reutilizable; compatibilidad; dependencias; Git/CI y estructura existente | Línea base registrada; compila o se documenta el bloqueo reproducible; propuesta mínima de integración del Supervisor |
| **A2** | **Contenido bíblico y campaña** | RV1909 y procedencia; diez mundos ×30; contenido español; banco de palabras; dificultad; pistas y referencias; validadores | 300 niveles reales, coherentes, resolubles y contrastados contra las fuentes; ninguna palabra portuguesa visible en el producto |
| **A3** | **Visual y experiencia de usuario** | Imagen madre aprobada; portada; inicio; mapa; tablero; victoria; álbum/logros; legibilidad/accesibilidad; consistencia gráfica | **Una sola presentación visual consolidada al Humano**, con referencia al PNG v001 y comparación de las pantallas clave; aprobación o correcciones antes de cerrar el diseño |
| **A4** | **Juego y progreso offline** | Generación/selección de palabras; ayudas; perfil local; DataStore; estrellas; álbum; insignias; modos originales útiles | Flujo completo jugable, progresión recuperable tras reinicio y funcionamiento sin internet ni cuenta |
| **A5** | **Calidad, integración y APK de prueba** | Pruebas automáticas y funcionales; verificación de tableros; tamaño/rendimiento; revisión Supervisor; integración autorizada; firma de prueba; artefacto/checksum | APK candidata con commit, versión, hash, evidencia y guía de instalación; **instalación en celular del Humano todavía pendiente hasta su prueba** |

**Orden orientativo:** A1 identifica base y dependencias. A2, A3 y A4 podrán avanzar parcialmente en paralelo si hay recursos, autorizaciones, interfaces y ramas no conflictivas. A5 integra y verifica el estado completo. El Supervisor registra el mapa mínimo de precedencias en el **Work Item existente** cuando corresponda; no crear una estructura administrativa paralela.

## 2. Ingeniería básica: límites, no arquitectura impuesta

**Base reconocida en el código de origen:** Kotlin + Jetpack Compose, motor `core/` (`PuzzleGenerator`, `Campaign`), persistencia `data/GameDataStore.kt` con DataStore, pantallas en `ui/`, bancos JSON bajo `app/src/main/assets/words/`, `tools/validate_words.py` y CI GitHub Actions que valida bancos, tests y `assembleDebug`.

**Dirección mínima suficiente:** conservar/adaptar **UI Compose ↔ lógica existente ↔ bancos bíblicos locales y DataStore local**. La división es conceptual, no mandato de introducir capas, módulos, interfaces, patrones, servidores o frameworks. El Supervisor determina la ingeniería técnica compatible con esta base y documenta desviaciones materiales justificadas.

**Prohibición de sobrediseño:** no introducir por iniciativa propia infraestructura remota, cuentas, Firebase, microservicios, autenticación, analítica, servicios en nube, cifrado personalizado, orquestadores, diagramas o procesos adicionales **sin una necesidad demostrable para esta APK**. La posibilidad futura de Google/Play Games NO obliga a implementarlo hoy.

**Seguridad proporcional:** no solicitar permisos Android innecesarios; datos de perfil solo locales; no almacenar secretos de firma en Git; verificar procedencia de dependencias y textos; validar las protecciones relevantes para una app dirigida también a menores. No confundir proporcionalidad con omitir controles necesarios. La publicación pública y sus requisitos regulatorios son un hito separado.

**APK liviana:** medir el tamaño real de la compilación y compararlo con la base; optimizar recursos, fuentes, ilustraciones y dependencias cuando sea relevante. **No imponer un límite arbitrario de MB ni afirmar peso sin construir el artefacto.** Priorizar legibilidad y compatibilidad antes que efectos visuales pesados.

## 3. Participación del Humano: dos intervenciones planificadas

1. **Revisión visual consolidada antes de cerrar la propuesta visual de la primera APK.** El Supervisor reúne pantallas representativas y lenguaje gráfico coherente con la [imagen original aprobada en Drive](https://drive.google.com/file/d/1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03/view?usp=drivesdk) y [MARCO_VISUAL.md](MARCO_VISUAL.md). El Humano valida el conjunto o pide una corrección visual consolidada. No solicitar aprobación por cada ilustración, botón o pantalla.
2. **Recepción y prueba de la primera APK candidata** con instrucciones y evidencia, después de la integración autorizada.

**Sin consultas rutinarias:** el Supervisor resuelve decisiones técnicas, formatos de datos, pruebas, banco de palabras, ajustes menores y corrección de defectos. Solo elevar una incompatibilidad material con decisiones del Humano, un permiso/gasto sensible o un bloqueo crítico que no pueda resolver dentro de lo autorizado. No detener el trabajo independiente válido por un bloqueo puntual.

## 4. Interlocución, handoffs y transporte: decisión expresa del Humano

**Dos IA interlocutoras con el Humano:** **Jefe de Agente IA** (producto/seguimiento solicitado) y **Supervisor** (dirección técnica). El Supervisor puede disponer de Delfín como implementador subordinado cuando Workflow V3 y el alcance lo autoricen, pero **Delfín no es destinatario de handoffs de gestión dirigidos al Jefe**.

- **Las IA son responsables de publicar el handoff completo y la evidencia en GitHub cuando corresponda en su actividad autorizada**. No trasladar al Humano la obligación de redactar, publicar ni mantener handoffs.
- **Decisión humana posterior (2026-11-03):** el software de Windows realiza el transporte mecánico. No exigir al Humano trasladar mensajes, habilitar cada Issue o administrar dicho software, que para el Jefe es solo lectura.
- **Supervisor → Jefe:** el Supervisor deja un registro completo y verificable de su estado, hito o excepción en el Work Item/canal GitHub autorizado, y prepara un **aviso corto para el Jefe**. Su transporte corresponde al mecanismo de Windows informado por el Humano, sin dar por probada la recepción. El Jefe consulta la fuente durable cuando el Humano lo solicita; no presume recepción por un commit o comentario.
- **Jefe → Supervisor:** cuando exista una decisión expresa del Humano, el Jefe conserva su texto como decisión humana y prepara un aviso corto con referencia a la documentación. Su transporte corresponde al mecanismo de Windows informado por el Humano, sin dar por probada la recepción. El Supervisor verifica autenticidad, autorización y alcance antes de actuar; luego registra las decisiones técnicas e instruye a su implementador si corresponde.
- **Intercambio Supervisor ↔ Implementer, si se usa:** permanece **interno bajo V3**, con sus roles reales y el contrato de su canal autorizado. No sustituirlo por un supuesto handoff Jefe ↔ Delfín.
- **No inventar enrutamiento automático hacia Jefe:** Workflow V3 identifica `ProjectLead` como rol de referencia, **no prueba de un receptor compatible con `SEND_TO`**. Antes de un mensaje dirigido verificar canal, contrato, destinatario y permisos. Cuando el registro sea solo documentación para el transporte manual, **no emitir `SEND_TO: ProjectLead` ni otro encabezado de ruta no verificado**. Un comentario GitHub por sí solo no prueba entrega al otro chat.

**Formato del aviso corto que el Supervisor entrega al Humano para transportar al Jefe** (plantilla, no mensaje emitido):
```text
PARA: Jefe de Agente IA
PROYECTO: Sopa de Letras Cristiana
TIPO: Avance | Revisión visual | Bloqueo material | APK candidata
WORK_ITEM / ACTIVIDAD: <referencia real>
HANDOFF_PUBLICADO: <URL exacta GitHub del registro o comentario>
HEAD / PR: <SHA o URL si aplica>
ACCIÓN SOLICITADA AL JEFE: <contrastar o presentar al Humano>
```
El registro completo contiene alcance, evidencia, estado real, pendientes y decisión del Supervisor (si corresponde); el aviso es solo un **puntero**. **`PUBLISHED != DELIVERED != REVIEWED/ACCEPTED`**. Si no existe Work Item o canal de publicación verificado, documentar esa carencia; **no fingir entrega ni crear destinatarios técnicos**.

**Significado de publicación automática:** publicación realizada por la IA en el curso de una sesión/tarea realmente activada y autorizada, **no trabajo en segundo plano, monitorización o control automático de otro chat**. No introducir bots, servicios de mensajería o GoFlow como requisitos.

## 5. Cómo supervisar la ruta sin microgestión

Para cada **actividad material** el Supervisor conserva en GitHub: ID de Work Item, autoridad/scopes, criterios observables de aceptación, base SHA, rama/PR/HEAD, pruebas/CI, estado exacto, dependencias/bloqueos y próximo responsable. No crear Work Items por cada microtarea. Evidencia de **propuesto ≠ implementado ≠ probado ≠ revisado ≠ integrado ≠ instalado**.

**Puntos de control:** (i) línea base; (ii) campaña validada; (iii) propuesta visual consolidada **presentada al Humano**; (iv) experiencia integrada; (v) APK candidata. Son hitos de trazabilidad, **no cinco autorizaciones adicionales del Jefe ni reportes recurrentes**. El Supervisor decide la ingeniería y las revisiones técnicas, y el Jefe analiza progreso o desviaciones **solo a petición del Humano**.

## 6. Fuentes y precedencia

- [Objetivo oficial](OBJETIVO_PRODUCTO_CRISTIANO.md) (producto y diez mundos).
- [Primera APK](ALCANCE_PRIMER_APK_V1.md) (funcionalidad y verificaciones).
- [Marco visual](MARCO_VISUAL.md), [editorial](MARCO_EDITORIAL.md), [literario](MARCO_LITERARIO.md).
- [Recursos en Drive](RECURSOS_DRIVE_VERSIONADO.md) (`SLC-VIS-001/v001`; acceso no público).
- [Continuidad del Supervisor](CONTINUIDAD_SUPERVISOR_APK_V1.md).
- **Workflow V3 vigente en su repositorio oficial**: prevalece en autoridad, routing, scopes, revisiones y comunicación. Este plan de producto **no lo modifica**, no crea roles y no constituye una orden de ejecución ni prueba de recepción por el Supervisor.

**Pendientes previos a ejecución:** Supervisor/Work Item/canal autorizados y verificables, base compilada y acceso legítimo a recursos. No se ha acreditado inicio técnico, integración ni APK de este fork cristiano por esta publicación documental.
