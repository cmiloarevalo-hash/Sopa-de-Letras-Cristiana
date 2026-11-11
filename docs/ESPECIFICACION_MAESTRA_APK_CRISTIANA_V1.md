# ESPECIFICACIÓN MAESTRA · SOPA DE LETRAS CRISTIANA · APK V1

> **DECISIÓN HUMANA DE NOMBRE OFICIAL · 11-11-2026:** la aplicación se llama exactamente **«Sopa de letras -Biblia Rv-1909»**. Es el nombre visible en Android, portada, Inicio y material de distribución; **NO se renombra el identificador interno** `applicationId` para proteger las instalaciones y el progreso previos. La integración nueva de lector bíblico offline y pista misteriosa progresiva se desarrolla en rama `supervisor/biblia-pistas-progresivas-20261111` sobre la APK RC1, con 66 libros RV1909 de dominio público. El nuevo contenido y QA deben demostrarse antes de declarar la versión definitiva.

**Work Item Google:** [A6 #15](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/15) · **PR documental:** [#14](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/pull/14).
**Fecha:** 11-11-2026 · **Responsable:** Supervisor · **Estado:** propuesta de integración documental en rama independiente, pendiente de revisión/merge. No confundir con código probado ni con aceptación humana de textos nuevos.

> **Punto único de entrada para agentes nuevos.** Recoger aquí requisitos, diez mundos, catálogo EXACTO por 300 niveles y 10 misterios específicos, arquitectura, Google, alcance, pruebas, fuentes y handoffs. Ningún agente debe reinterpretar decisiones humanas ni afirmar que esta propuesta editorial está integrada sin verificar HEAD. Este documento es una especificación de trabajo autorizada por solicitud directa humana; las listas de sustituciones son **decisiones editoriales propuestas por el Supervisor**, no palabras ya revisadas por el propietario.

> **ACTUALIZACIÓN VINCULANTE DEL 11-11-2026:** [CATÁLOGO DE LOS 300 NIVELES](CATALOGO_300_NIVELES_V1.md) y su [JSON exacto](data/campana_300_niveles_v1.json) sustituyen las propuestas anteriores de 70 palabras y 15 misterios por mundo. El usuario prioriza EXPERIENCIA y PALABRAS. Google/A6 pasa al final del desarrollo, después de una APK offline jugable. **Documentado ≠ implementado; simulación independiente 300/300 ≠ pruebas Kotlin/Android.**

## 1 · Decisiones humanas invariables y nueva decisión
- **Reutilizar** la sopa de letras Android existente Kotlin/Compose: no rehacer el juego, motor, UI o almacenamiento desde cero. **10 mundos × 30 niveles = 300 niveles**; **mundo 3 Noé y Diluvio**, no el primero; mundos 1–5 relatos Antiguo Testamento; mundos 6–10 Jesús, Evangelios y primeras comunidades del Nuevo Testamento.
- **Reina-Valera 1909** como referencia verificable, pero lenguaje español **moderno, sencillo y positivo** en pantallas, palabras y pistas. No repetir por obligación términos antiguos ni ideas de un versículo sin contexto. Sin adscripción a religión católica, protestante u otra.
- **Eje pedagógico humano:** AMOR, ESPERANZA, PAZ, AMISTAD, CORDIALIDAD, ENTUSIASMO, SOLIDARIDAD, PALABRAS AMABLES, GENEROSIDAD, SERVICIO. El jugador encuentra y recuerda palabras que ayudan a tratar bien a los demás. Inspiración: vida y enseñanzas de Jesús, no un examen religioso.
- **Modelo educativo de Biblia–Guía Pastoral (Lago-1):** episodio o enseñanza bíblica contextualizada → valor en lenguaje claro → gesto cotidiano voluntario; no copiar sus 16 capítulos ni el código. Su guía autoral 1.30 está en **PR #68 candidato**, mientras QA5 es baseline aceptada en Lago-1.
- UI **Aventura Bíblica Moderna** según PNG maestro SLC-VIS-001/v001; una revisión humana de seis pantallas ya prevista. Juego offline, sin anuncios ni compras, progreso local, pistas, 1–3 estrellas/nivel, álbum y recompensas; primera APK privada antes de cualquier publicación.
- **CAMBIO HUMANO DEL 11-11-2026:** incorporar **«Continuar con Google»** simple y una **copia/recuperación REAL** del progreso vinculada a esa cuenta. Mantener **«Jugar sin cuenta»** y toda la campaña offline; solo inicio de sesión/restauración/sync requieren conexión. Esta precisión sustituye la prohibición histórica de cuentas únicamente en lo indispensable.
- **Seguridad y procesos:** riesgos ordinarios generan aviso/alerta, no bloqueo especulativo del desarrollo. Una limitación real detiene solo esa operación; seguir tareas independientes. Se protegen secretos/credenciales y se respetan alcances de Workflow V3. Prohibidos sobreingeniería, burocracia extra, infraestructura no necesaria y afirmaciones de pruebas inexistentes.

## 2 · Diez mundos definitivos como propuesta editorial de ejecución
| Mundo | Niveles | Nombre sencillo de la pantalla | Referencias | Valores principales |
|---:|---:|---|---|---|
| 1 | 1–30 | **La creación y la vida** | Génesis 1:1–2:3 | Cuidado, vida, gratitud |
| 2 | 31–60 | **Las primeras familias** | Génesis 2:4–5:32 | Respeto, familia, reconciliación |
| 3 | 61–90 | **Noé y la esperanza** | Génesis 6:9–9:17 | Esperanza, confianza, cuidado |
| 4 | 91–120 | **Abraham y las promesas** | Génesis 12:1–50:26 | Confianza, paciencia, perdón |
| 5 | 121–150 | **Moisés, libertad y justicia** | Éxodo 1–20; 1 Samuel 16; Isaías 6 | Libertad, justicia, ayuda |
| 6 | 151–180 | **Jesús y su familia** | Lucas 1:26–2:52; Mateo 1–2 | Alegría, cariño, bienvenida |
| 7 | 181–210 | **Jesús nos enseña a amar** | Mateo 5–7; Lucas 10:25–37 | Amor, cordialidad, paz |
| 8 | 211–240 | **Jesús y sus amigos** | Marcos 1:16–20; Lucas 5:1–11; Juan 11 | Amistad, escucha, apoyo |
| 9 | 241–270 | **Jesús vive: amor y esperanza** | Lucas 22–24; Juan 19–20 | Esperanza, consuelo, amor |
| 10 | 271–300 | **Una comunidad que comparte** | Hechos 2:42–47; 1 Corintios 13 | Solidaridad, generosidad, paz |

**M1 · La creación y la vida (1–30).** **De qué trata:** Luz, cielo, agua, plantas, animales y descanso; valoración de la creación. **Objetivo educativo:** Cuidado, vida, gratitud. **Mensaje breve original sugerido:** «Cuidar la naturaleza es una forma de apreciar la vida.». **Fuente para comprobar:** Génesis 1:1–2:3.

**M2 · Las primeras familias (31–60).** **De qué trata:** Adán, Eva, Caín, Abel y Set; hogar, familia, trabajo, decisiones y responsabilidad. **Objetivo educativo:** Respeto, familia, reconciliación. **Mensaje breve original sugerido:** «Nuestras palabras y decisiones influyen en quienes nos rodean.». **Fuente para comprobar:** Génesis 2:4–5:32.

**M3 · Noé y la esperanza (61–90).** **De qué trata:** Noé, arca, lluvia, animales, paloma, arcoíris y pacto. Es el TERCER mundo. **Objetivo educativo:** Esperanza, confianza, cuidado. **Mensaje breve original sugerido:** «La esperanza ayuda a mirar hacia un nuevo comienzo.». **Fuente para comprobar:** Génesis 6:9–9:17.

**M4 · Abraham y las promesas (91–120).** **De qué trata:** Abraham, Sara, Isaac, Jacob y José: caminos, familias, confianza, conflictos y reencuentros. **Objetivo educativo:** Confianza, paciencia, perdón. **Mensaje breve original sugerido:** «La familia y la amistad se fortalecen con diálogo y perdón.». **Fuente para comprobar:** Génesis 12:1–50:26.

**M5 · Moisés, libertad y justicia (121–150).** **De qué trata:** Moisés, Miriam, Aarón, éxodo y mandamientos; reyes y profetas como continuación. **Objetivo educativo:** Libertad, justicia, ayuda. **Mensaje breve original sugerido:** «La libertad invita a cuidar y respetar a otras personas.». **Fuente para comprobar:** Éxodo 1–20; 1 Samuel 16; Isaías 6.

**M6 · Jesús y su familia (151–180).** **De qué trata:** Anuncio, nacimiento, María, José, Belén, pastores y relatos de infancia que sí constan en los Evangelios. **Objetivo educativo:** Alegría, cariño, bienvenida. **Mensaje breve original sugerido:** «La bienvenida y el cuidado son gestos de amor.». **Fuente para comprobar:** Lucas 1:26–2:52; Mateo 1–2.

**M7 · Jesús nos enseña a amar (181–210).** **De qué trata:** Enseñanzas de Jesús, amor al prójimo, buen samaritano, perdón, paz y oración. **Objetivo educativo:** Amor, cordialidad, paz. **Mensaje breve original sugerido:** «El amor se muestra también en nuestras palabras y acciones.». **Fuente para comprobar:** Mateo 5–7; Lucas 10:25–37.

**M8 · Jesús y sus amigos (211–240).** **De qué trata:** Discípulos, pescadores, amistad, Marta, María, Lázaro, escucha y compañía. **Objetivo educativo:** Amistad, escucha, apoyo. **Mensaje breve original sugerido:** «Escuchar y acompañar es una forma de cuidar la amistad.». **Fuente para comprobar:** Marcos 1:16–20; Lucas 5:1–11; Juan 11.

**M9 · Jesús vive: amor y esperanza (241–270).** **De qué trata:** Última cena, entrega, muerte y resurrección de Jesús; consuelo y esperanza. **Objetivo educativo:** Esperanza, consuelo, amor. **Mensaje breve original sugerido:** «Incluso en momentos difíciles podemos buscar apoyo y esperanza.». **Fuente para comprobar:** Lucas 22–24; Juan 19–20.

**M10 · Una comunidad que comparte (271–300).** **De qué trata:** Primeras comunidades, colaboración, servicio, oración y buenos tratos cotidianos. **Objetivo educativo:** Solidaridad, generosidad, paz. **Mensaje breve original sugerido:** «Vivir el amor es ayudar, compartir y cuidar a los demás.». **Fuente para comprobar:** Hechos 2:42–47; 1 Corintios 13.

### 30 niveles por mundo: regla existente que NO se rediseña
- Niveles 1–9 introducción/progreso; **10** reto contra reloj; 11–19 avance; **20** palabra misteriosa; 21–29 consolidación; **30** cierre especial y desbloqueo del siguiente mundo.
- Una guía de referencia y contexto por mundo; título/introducción y frase amable de victoria donde permita el diseño. **No hay 300 lecciones individuales aprobadas**: no inventar biografía, diálogos de Jesús ni sermones. No exigir respuesta doctrinal u oración para ganar.
- El contenido de cada tablero se **genera con palabras del banco de 70 del mundo**, sin garantizar 70 palabras diferentes por nivel. Las palabras pueden repetirse entre tableros; la enseñanza reside en el vocabulario, el contexto y el relato.
- **Dificultad conservada por mundo:** M1 6×6, 3–4 palabras; M2 8×8, 4–6; M3 8×8, 6–8; M4 10×10, 6–9; M5 10×10, 8–11; M6 10×10, 10–12; M7 12×12, 8–12; M8 12×12, 10–14; M9 12×12, 12–16; M10 12×12, 14–18. BOSS nivel 30: hasta dos palabras extra si cabe. Direcciones 2–8 según mundo. No endurecerla artificialmente para demostrar aprendizaje.

## 3 · Dicc## 3 · Contenido DEFINIDO PARA LOS 300 NIVELES — AUTORIDAD EDITORIAL V1.1
**INSTRUCCIÓN HUMANA MÁS RECIENTE (11-11-2026):** completar el contenido individual de **los 300 niveles**; no basta con bancos genéricos de 70 palabras por mundo. El contenido debe optimizar la **experiencia del jugador**, no adaptar palabras a cuotas heredadas del validador. **No desarrollar Google hasta el tramo final de integración.**

**Estos dos recursos SON el catálogo vigente para ejecutar, no los listados de 70+15 de la propuesta anterior:**
- **[Catálogo humano: las 300 listas exactas, 30 episodios, mensajes, referencias y diez pistas](CATALOGO_300_NIVELES_V1.md)**.
- **[Catálogo de datos JSON de 300 registros](data/campana_300_niveles_v1.json)** — misma información estructurada para lectura directa del agente y futura incorporación a `app/src/main/assets/`. La app A5 **todavía no consume este JSON**.

**Regla de sustitución:** el antiguo modelo de `70 normales + 15 misterios por mundo` queda como **inventario de código anterior**, NO como obligación de generar/seleccionar contenido. El JSON de 300 niveles indica **exactamente** qué palabras debe presentar cada nivel. No tomar palabras al azar del banco histórico, no sustituirlas silenciosamente si una disposición geométrica falla. Repetición **entre niveles** permitida para reforzar conceptos; **dentro del mismo tablero** prohibida. Se excluyeron pares de palabras contenidas unas en otras en una misma lista.

**Distribución de experiencia y progresión:**

| Mundo | Tablero | Palabras normales por nivel | Misterio del mundo (nivel 20) |
|---:|---|---:|---|
| 1 | 6×6 | 3–5 | CUIDAR |
| 2 | 8×8 | 4–7 | PERDON |
| 3 | 8×8 | 5–8 | PACTO |
| 4 | 10×10 | 6–9 | PERDON |
| 5 | 10×10 | 7–10 | JUSTICIA |
| 6 | 10×10 | 8–11 | ALEGRIA |
| 7 | 12×12 | 9–12 | BONDAD |
| 8 | 12×12 | 10–13 | AMISTAD |
| 9 | 12×12 | 11–14 | CONSUELO |
| 10 | 12×12 | 12–15 | AYUDA |

**30 episodios educativos:** cada mundo se divide en tres episodios de diez niveles, con tema, referencia RV1909, valor y mensaje actual. El nivel 10 es cronometrado, el 20 misterio, el 30 cierre especial. **Una palabra misteriosa exacta por mundo**, no quince niveles ni quince palabras en juego. No se exige memorización bíblica para ganar; el aprendizaje es una invitación, no un examen.

**Comprobación realizada sobre datos:** 300/300 registros, 2.545 apariciones de palabras normales (incluyendo refuerzos entre niveles), sin duplicados dentro de partida, sin vocablos de longitud superior al lado de su cuadrícula, sin subpalabras conflictivas y sin ocultar el misterio dentro de palabra normal. Se ejecutó además un simulador independiente de colocación equivalente en reglas básicas: **300/300 conjuntos viables**, el más exigente requirió 92 intentos (límite heredado 128). **No equivale a Kotlin PASS ni Android instalado**. Los diez misterios requieren adaptación de generador y pruebas reales.

**Defectos del motor conocidos y corrección mínima exigida en A2:**
1. `PuzzleGenerator.countOccurrences` cuenta dos veces una misma trayectoria cuando la palabra es palíndroma (por ejemplo `ANA` en Lucas 2, `ALA` y `OSO`). Contar una trayectoria geométrica no dirigida **una vez**, no borrar un personaje bíblico para esquivar un bug.
2. La modalidad misteriosa previa usa un `Map` por longitud con sobrescritura de candidatos y no respeta respuesta fija por nivel. Incorporar `mystery.word` y `mystery.clue` del JSON; conservar la experiencia de pista y palabra oculta, no rehacer la app.
3. Los niveles misteriosos de mundos 7–10 actualmente fuerzan 10×10 en algunos puntos de `Campaign.kt`, `MainActivity.kt` y `genMystery()`. **El catálogo establece 12×12** para mantener la progresión visual: eliminar esta reducción incompatible de manera focalizada y comprobar geometría, especialmente los 10 niveles de misterio.
4. La selección aleatoria de bancos normales ya no es autoridad: conectar nivel → lista explícita; la lista exacta tiene precedencia sobre `World.minWords/maxWords` históricos. Usar semilla/algoritmo para colocar letras, nunca para elegir vocabulario distinto.
5. Corregir los textos residuales portugueses visibles (p. ej. `Nível`, `Chefe`, `Qual é a palavra?`, `Faltam letras`). Toda UI es español contemporáneo y respetuoso.

**Excepción técnica consciente:** Si hay un nivel realmente imposible en Kotlin y el simulador independiente no revela por qué, registrar nivel y evidencia, corregir algoritmos/sobrecarga mínima antes de sugerir cambiar palabras. No detener otras tareas. Mantener contexto RV1909 y no presentar mensajes originales como cita de Jesús.

itectura de software REAL, reutilización y módulos
```
MainActivity/NavHost (Compose) -> pantallas Cover/Home/Campaign/Game/Album/Settings
  -> ViewModel / core.Campaign + BoardConfig + PuzzleGenerator + puntaje/pistas
  -> data.CampaignContent y WordRepository -> assets words/es-ES/*.json
  -> data.GameDataStore / SettingsStore (DataStore local)
  -> NUEVO A6: adaptador de identidad Google + Drive appDataFolder (solo si autoriza el usuario)
```
- **No crear** backend propio, servidor, microservicios, IA generativa en runtime, base SQL remota ni motor nuevo. No cambiar Kotlin/Compose por el stack React Native de Lago-1.
- Códigos reales: `app/src/main/java/app/sopadeletras/MainActivity.kt`; `AppContainer.kt`; `core/{Campaign,BoardConfig,PuzzleGenerator}.kt`; `data/{CampaignContent,WordRepository,GameDataStore,Rewards}.kt`; `ui/**`; `app/src/main/assets/words/es-ES/*.json`; `tools/validate_words.py`; `.github/workflows/ci.yml`.
- Campaña: nivel `1..300`; índice mundo `(nivel-1)/30`; semilla española `nivel*7919`; generador determinista; nivel 10 TIMED, 20 MYSTERY, 30 BOSS. Progreso DataStore guarda estrellas, mejor tiempo, partida, resultados, apodo y racha. El álbum (10 fichas) y cinco insignias son derivados del progreso. **No duplicar estados derivados.**
- La arquitectura actual está implementada pero falta aceptación/merge. Ninguna capa extra «clean architecture» es requisito de APK.

## 5 · Cuenta Google y sincronización de progreso: contrato mínimo NUEVO
**PRIORIDAD DIFERIDA HASTA EL FINAL:** Google NO es condición previa para terminar los niveles, el juego ni la primera APK offline. **Decisión humana:** la cuenta Google permitirá recuperar avance en otro teléfono una vez integradas las funciones principales. **Iniciar sesión no guarda progreso por sí mismo.** Solución mínima **PROPUESTA TÉCNICA (a implementar y probar):**
1. Android **Credential Manager + «Continuar con Google»**. Mantener **«Jugar sin cuenta»** accesible. No pedir contraseña propia ni usar un WebView embebido para inicio de sesión.
2. Solicitar permiso OAuth **`https://www.googleapis.com/auth/drive.appdata`** solo al activar «Guardar mi avance en Google», no acceso amplio a todo Drive. Google Drive **`appDataFolder`** ofrece almacenamiento oculto asociado a la cuenta de ese usuario, sin servidor propio. La autenticación y el permiso Drive son **dos operaciones diferentes**.
3. Guardar `sopa-cristiana-progress-v1.json`, esquema mínimo:
```json
{"schemaVersion":1,"game":"sopa-cristiana","language":"es-ES","nickname":"","updatedAtEpochMillis":0,"levels":{"1":{"stars":3,"bestSeconds":68}}}
```
4. **Local primero**: siempre salvar la victoria en DataStore, sin esperar internet; marcar pendiente sync. Al volver la red y existir autorización, leer backup de Drive, **fusionar estrellas por máximo** y **mejor tiempo válido**, recalcular álbum; escribir copia actualizada. Dos dispositivos: leer/fusionar antes de sobrescribir, reintentar en conflicto. No subir la Biblia, emails, tokens ni datos sensibles al JSON.
5. Invitado → cuenta: dar opción explícita **«Guardar mi avance en esta cuenta»**, sin transferencia automática no consentida. Cuentas diferentes: datos locales por perfil separado para no mezclarlos; cerrar sesión no borra copia remota. «Borrar mis datos» distingue borrado local de borrar backup Google con confirmación.
6. Offline: todas las pantallas del juego siguen funcionando como invitado o con sesión previa; si OAuth/Drive falla, aviso no bloqueante **«Tu avance sigue guardado en este dispositivo»**. No vender sincronización como «PASS» sin prueba real entre dos teléfonos.
7. **Única dependencia externa aún no disponible como dato de este repositorio:** configuración real de Google Cloud/Drive API, consentimiento OAuth, clientes Android, huellas SHA de builds y cuenta de prueba. El Humano ha autorizado la **función**, no ha proporcionado client IDs ni acceso a su consola. No inventarlos. **Posponer este Work Item hasta tener la aplicación principal jugable e integrada.** Solo entonces preparar UI, DataStore, contrato y pruebas independientes; el acceso Google real seguirá `PENDING` hasta contar con configuración.
8. No introducir Firebase, Firestore o backend por inercia: Google Drive appDataFolder es el mínimo a evaluar primero. Si aparece una incompatibilidad técnica REAL, Supervisor documenta la evidencia y una alternativa proporcionada, sin bloquear A1–A5.

**Fuentes oficiales para el agente Google:** https://developers.google.com/identity/siwg/best-practices ; https://developer.android.com/identity/credential-manager ; https://developers.google.com/workspace/drive/api/guides/appdata ; https://developers.google.com/workspace/drive/api/guides/api-specific-auth .

## 6 · Pantallas y experiencia de usuario
**Portada:** tema bíblico y botón claro «Jugar»; añadir «Continuar con Google» **solo cuando el servicio funcione en la integración final**, nunca un botón ficticio que bloquee jugar como invitado. **Inicio:** apodo opcional, continuar campaña, diez mundos, juego libre/diario si funcionan, álbum/ajustes. **Mapa:** solo mundos desbloqueados según progreso. **Nivel:** nombre, tablero, palabras y pistas. **Victoria:** 1–3 estrellas, referencia y breve mensaje positivo; siguiente nivel/reintentar. **Álbum:** diez fichas y cinco insignias, no añadir 300 tarjetas sin decisión humana. **Ajustes:** tamaño de letra, tema, sonido, accesibilidad y cuenta/estado de copia. **Final nivel 300:** mensaje de esperanza, amor, amistad y servicio. Todo en español cotidiano, botones táctiles legibles y sin presión religiosa.
**Visual:** PNG maestro real localizado en Drive SLC-VIS-001/v001; comparar seis capturas REALES con referencia, una única revisión humana visual consolidada ya autorizada. No sustituir PNG auténtico por imágenes arbitrarias ni abrir nuevas rondas burocráticas.

## 7 · Criterios de aceptación desde la experiencia del jugador
| Resultado observable | Evidencia concreta | Estado 11-11-2026 |
|---|---|---|
| En cada uno de los 300 niveles aparecen EXACTAMENTE las palabras de su fila | Comparar APK/test con `docs/data/campana_300_niveles_v1.json` | CATÁLOGO DEFINIDO, CÓDIGO PENDIENTE |
| Los tableros 6×6 a 12×12 caben y se resuelven sin respuestas ambiguas | Test Kotlin 300/300 + exploración física de algunos niveles | SIMULACIÓN INDEPENDIENTE 300/300, APK NOT_RUN |
| La cantidad de palabras es agradable y gradual (3–15) | Recorrido por mundo, comparación con cuadro de §3 | DEFINIDO, POR IMPLEMENTAR |
| Diez niveles de misterio, uno por mundo, con respuesta/pista comprensible | Probar niveles 20,50,…,290 y ambas vías de resolución | DEFINIDO, POR IMPLEMENTAR |
| Los 30 episodios enseñan palabras valiosas con referentes bíblicos | Mensaje breve + referencia RV1909 en juego | DOCUMENTADO, SIN REVISIÓN EDITORIAL FINAL |
| Persistencia offline, estrellas, retos, álbum y siguiente nivel funcionan | QA Android y reinicio de app / modo avión | PARCIAL EN A4/A5, NO QA FÍSICO |
| Las pantallas son claras, ligeras y próximas al arte aprobado | Seis capturas, una revisión humana visual consolidada | A3 EN RAMA, PENDIENTE |
| Primera APK cristiana puede instalarse y completar los 300 niveles sin Google | Build, instalación Android, test real y referencia SHA | PENDIENTE |
| **Al final**, Google opcional restaura progreso sin interrumpir el juego | Dos dispositivos, misma cuenta y modo invitado | A6 #15 AUTORIZADO, DIFERIDO POR HUMANO |
| Todo resultado tiene estado verificable y revisión por SHA | Work Item, PR, pruebas, handoff | En seguimiento; NO inventar `ACCEPT` |

## 8 · Estado de ramas comprobado, para no perder información
| Código | Referencia al 11-11-2026 | Qué hay | Lo que no demuestra |
|---|---|---|---|
| main | `229ac4180faf151c6731d271183a6cf9837ab70a` | Motor histórico, documentos originales | No incluye bancos `es-ES` |
| A1 PR #9 | `5b013d2f2bfb51435c3ecf7e90d07c3009d47f25` | 300/900 y debug Android | No merge |
| A2 PR #10 | `b86dc63cd029f4129155cf33e7c1467a43335fb7` | 10 bancos 70+15, pruebas; nivel 178 falla en A2 aislada | No usar como fuente de PASS |
| A4 PR #11 | `4b90c978d84d25afdb176425aaff31212835785d` | DataStore, estrellas, álbum, pistas | No QA físico |
| A3 PR #12 | `cc1f86590614c23e2c19daee6b0dd873b4131105` | Portada y propuesta seis vistas | No aceptación visual |
| A5 PR #13 | `a58bbfc9fc7fc8a3ce30d2394b66673d9dbf4898` | Integración + corrección generador, APK debug | No instalada en teléfono |
| A1 Supervisor PR #7 | `3b862556b1b5d14fb4bbf7019745b1bf90d91c49` | Manifest y corrección tests | No reconciliada |

**Evidencia específica del Delfín:** https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/8#issuecomment-6611819120 — compilación Windows del código `44aafe36568d0fa4ff5d11fae401bb38817cdf8d`, 14.031.411 bytes, SHA-256 `4AD41EF324CFA3930F8DEA37C5E4F17FADF1908C5718215CDE253BCBDB846E12`, 84/84 JVM PASS, 300 tableros PASS **en integración anterior al catálogo**. GitHub Actions consultadas 0 runs. No marcar la primera APK cristiana como final, publicada, instalada ni sincronizada.

## 9 · Orden vinculante de trabajo para agentes — PRIORIDAD CONTENIDO/EXPERIENCIA
**Orden expreso del Humano (11-11-2026):** **1) 300 niveles completos y agradables → 2) interfaz visual ligera + juego/progreso local → 3) integración y APK jugable → 4) Google AL FINAL.** No interrumpir las primeras tres tareas por OAuth, consola Google ni infraestructura de sincronización.

| Paso | Responsable / Work Item existente | Trabajo mínimo y comprobable | Salida |
|---:|---|---|---|
| 1 | Delfín A2 #3 | Incorporar [300 niveles exactos](data/campana_300_niveles_v1.json) al juego. Respetar longitudes y palabras; corregir palíndromos, misterios exactos y reducción de cuadrículas. Revisar claridad de los 30 episodios y sus referencias. | Pruebas Kotlin 300/300, diffs y muestras en APK |
| 2 | Delfín A3 #4 | Usar diseño aprobado, español íntegro, mensajes cálidos, vista de mundo/nivel/pista/victoria. No sobrecargar pantallas con catequesis ni mecanismos extra. | Paquete de seis vistas comparables, sin gates múltiples |
| 3 | Delfín A4 #5 | Completar juego, pistas, recompensas, progreso local y la posibilidad de jugar como invitado offline. | Reabrir app sin perder nivel; álbum, estrellas y victoria |
| 4 | Delfín A5 #6 | Reconciliar PR #9–#13, ejecutar 300 tests finales en código integrado, compilar APK PRIVADA y verificar juego en Android. | APK jugable, pruebas, capturas e informe de problemas reales |
| 5 | Supervisor/Humano | Única revisión visual consolidada prevista; correcciones pequeñas y entrega de APK para prueba humana. | Resultado de revisión real; no fingir instalación |
| 6 · ÚLTIMO | Delfín A6 #15 | **Solamente después** de tener el juego funcional: incorporar «Continuar con Google» y copia/recuperación del avance sin impedir juego offline; probar sincronización real cuando haya credenciales/configuración. | Google opcional probado o reportado pendiente, sin falsear estado |

**No agregar Work Items ni tareas burocráticas por defecto.** Trabajar en el mismo A2–A5; A6 ya existe para aislar la dependencia externa. Si existe defecto real, alertar con nivel/archivo/evidencia y solución concreta; **la alerta no es permiso para paralizar el proyecto**. No inventar decisiones de producto ni cambiar palabras por conveniencia del código.

**Se prohíbe entregar como «terminada» una APK con 300 tableros aleatorios antiguos aunque sus tests pasen:** la aceptación exige que use las listas exactas del catálogo y su enfoque educativo.

## 10 · Gobernanza y handoff para un agente completamente nuevo
- **Autoridad:** HUMANO → JEFE → SUPERVISOR → DELFÍN. Supervisor escribe **solo este repositorio**. **Lago-1 = SOLO LECTURA**, jamás modificar allí código, issues o archivos.
- **Canal Jefe→Supervisor:** [Issue #1](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/1). **Canal Supervisor↔Delfín:** [Issue #8](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/8). Enviar comentario NUEVO con `MESSAGE_TYPE`, `FROM_ROLE`, `SEND_TO`, `TARGET_ROLE`, `REPOSITORY`, `WORK_ITEM`, `ACTIVITY`, `AUTHORITY_REF`, `RETURN_TO`, `STATE`, `REVIEW_HEAD`, `PR` y `VERIFICATION`. `PUBLISHED ≠ DELIVERED ≠ RESPONDED ≠ ACCEPT`.
- Antes de escribir, abrir Issue específico, verificar Path/Semantic/Resource Scope y HEAD. A2 catálogo; A3 visual; A4 local; A5 QA/build; A6 Google. No tocar rutas de otro work item unilateralmente.
- No crear «seguridad», auditorías o procesos abstractos que bloqueen código/pruebas: **avisar, documentar impacto concreto, mitigar mínimo si corresponde y continuar lo independiente**. Nunca exponer OAuth secrets/correos privados en GitHub público. No simular aprobación ni pruebas.
- No confundir los **300 registros individuales nuevos** con los bancos históricos de 70 palabras. Si un término del catálogo es incorrecto, choca con el misterio, está descontextualizado o resulta demasiado difícil, devolver **palabra exacta, mundo, causa y corrección concreta**, no inventar más banco al azar.
- Fuentes a leer sin reconstruir todo: este documento; [Objetivo](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/blob/main/docs/OBJETIVO_PRODUCTO_CRISTIANO.md); [Alcance](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/blob/main/docs/ALCANCE_PRIMER_APK_V1.md); [Marcos](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/tree/main/docs); [Workflow V3](https://github.com/cmiloarevalo-hash/workflow/blob/main/docs/WORKFLOW_PLAN.md); [Guía QA5 Lago-1](https://github.com/cmiloarevalo-hash/Lago-1/blob/main/docs/r13/PROTOTIPO_ESTABLE_ACEPTADO_QA5.md); [Guía 1.30 candidata PR #68](https://github.com/cmiloarevalo-hash/Lago-1/pull/68).
- **Próxima acción medible:** A2 instala catálogo documentado, documenta si necesita cambio mínimo para la jugabilidad, vuelve a validar 300 niveles; A5 no espera pasivamente a OAuth; A6 prototipa el adaptador sin simular una cuenta real. La documentación no reemplaza prueba ni código.

**Registro de versión:** 11-11-2026, propuesta de Supervisión. Decisiones humanas consignadas literalmente por sentido; catálogos y nombres concretados por el Supervisor, **aún sin revisión editorial del Humano**. Actualizar estado, enlaces y SHA cuando se revise o integre; no afirmar que esta rama es `main`.
