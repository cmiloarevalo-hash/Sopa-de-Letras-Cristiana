# ESPECIFICACIÓN MAESTRA · SOPA DE LETRAS CRISTIANA · APK V1
**Fecha:** 11-11-2026 · **Responsable:** Supervisor · **Estado:** propuesta de integración documental en rama independiente, pendiente de revisión/merge. No confundir con código probado ni con aceptación humana de textos nuevos.

> **Punto único de entrada para agentes nuevos.** Recoger aquí requisitos, diez mundos, catálogo concreto de 700 palabras normales y 150 misterios existentes, arquitectura, Google, alcance, pruebas, fuentes y handoffs. Ningún agente debe reinterpretar decisiones humanas ni afirmar que esta propuesta editorial está integrada sin verificar HEAD. Este documento es una especificación de trabajo autorizada por solicitud directa humana; las listas de sustituciones son **decisiones editoriales propuestas por el Supervisor**, no palabras ya revisadas por el propietario.

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

## 3 · Diccionario normativo propuesto por mundo y diferencias comprobables
**Cantidad objetivo precisa:** **70 palabras normales × 10 = 700 entradas; 15 términos misteriosos con pista × 10 = 150 entradas de inventario**. Las repeticiones entre mundos son permitidas cuando el contexto justifica un valor común. **Las listas normales de abajo son el catálogo editorial PROPUESTO (no incorporado aún a JSON); los misterios son el inventario EXACTO existente en A5**, con pistas originales heredadas. Eso impide confundir propuesta y código; un Delfín puede aplicar cambios concretos sin seleccionar arbitrariamente palabras.
**Formato obligatorio:** mayúsculas, 3–12 letras en la cuadrícula, Ñ conservada, tildes suprimidas **solo en tablero** (`JESUS` → «Jesús» en textos, `CARINO` → «cariño»). Sin vocablos difíciles solo para rellenar cuotas, ni palabras pegadas artificialmente.
**Identidad técnica:** cada mundo corresponde al JSON `app/src/main/assets/words/es-ES/<id>.json`; `id` permanece inalterado aunque cambie el título mostrado. Las 70 palabras de cada lista se conservan en el orden mostrado; se editan solo bajo A2 y se verifican contra este contrato. No alterar silenciosamente las otras traducciones del software heredado.

### M1 — La creación y la vida
**Banco:** `es-ES/creacion.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`RIOS · LUCES · DIOS · AMOR · VIDA · LUZ · PAZ · SOL · MAR · RIO · AGUA · LUNA · NUBE · FLOR · AVE · HOJA · FRUTO · DIA · CAMPO · BROTE · ASTROS · LUCERO · JARDIN · PLANTAS · BOSQUES · ANIMALES · OCEANOS · CREADOR · CREADOS · SEMILLAS · LLANURA · CREACION · AMANECER · CLARIDAD · BENDITOS · DESCANSO · ARBOLES · CIELOS · TIERRAS · FRUTALES · LUNARES · CAMINO · CUIDADO · SEMILLA · LAGUNAS · PRADERA · PAISAJE · MONTANA · RIACHOS · VERDURA · ESTRELLAS · FIRMAMENTO · MANANTIAL · ATARDECER · NATURALEZA · OSCURIDAD · VEGETALES · ALIMENTOS · SEPARACION · ESPERANZA · MARIPOSAS · PRIMAVERA · CRECIMIENTO · DIVERSIDAD · MARAVILLAS · AGRADECER · ARBOLEDAS · CUIDARNOS · ALIMENTAR · EQUILIBRIO`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (25):** `PAN → AGUA`; `SAL → LUNA`; `RED → NUBE`; `OJO → FLOR`; `VOZ → HOJA`; `REY → FRUTO`; `VER → CAMPO`; `DAR → BROTE`; `TEMPLO → CUIDADO`; `PROFETA → LAGUNAS`; `DESIERTO → PRADERA`; `ESPIRITU → PAISAJE`; `CORDERO → MONTANA`; `PASTORES → RIACHOS`; `PALABRA → VERDURA`; `BENDICIONES → MARIPOSAS`; `RESURRECCION → PRIMAVERA`; `CONSOLACION → CRECIMIENTO`; `GENERACION → DIVERSIDAD`; `SALVACION → MARAVILLAS`; `ADORACION → AGRADECER`; `NACIMIENTO → ARBOLEDAS`; `REVELACION → CUIDARNOS`; `MANDAMIENTO → ALIMENTAR`; `DESCENDIENTE → EQUILIBRIO`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M2 — Las primeras familias
**Banco:** `es-ES/origenes.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`ADAN · EVA · CAIN · ABEL · SET · ENOC · HIJOS · DIOS · AMOR · VIDA · LUZ · PAZ · PADRE · MADRE · HIJA · HIJO · CAMPO · FRUTO · CULPA · AYUDA · LINAJE · LABRADOR · HERMANOS · PRIMEROS · JARDINES · CULTIVAR · COSECHAS · HUERTOS · FAMILIA · TIERRAS · HUERTO · PRIMERA · GENERAR · SEMBRAR · CUIDADO · PADRES · MADRES · CAMINAR · MEMORIAS · CAMINO · RESPETO · SEMILLA · ESCUCHA · TRABAJO · UNIDOS · ALEGRIA · ABRAZOS · CONFIAR · PERDON · ARBOLES · GENERACIONES · ANTEPASADO · DESCENDENCIA · FAMILIARES · PRIMOGENITO · ESPERANZA · CONVIVENCIA · DESACUERDO · CONFIANZA · CUIDARNOS · RESPETARNOS · SOLIDARIDAD · ACOMPANAR · COMPARTIR · APRENDIZAJE · GENEROSIDAD · LIBERACION · PROTECCION · CAMINANTES · RECOMPENSA`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (25):** `SOL → PADRE`; `MAR → MADRE`; `RIO → HIJA`; `PAN → HIJO`; `SAL → CAMPO`; `RED → FRUTO`; `OJO → CULPA`; `AVE → AYUDA`; `TEMPLO → RESPETO`; `PROFETA → ESCUCHA`; `DESIERTO → TRABAJO`; `ESPIRITU → UNIDOS`; `CORDERO → ALEGRIA`; `PASTORES → ABRAZOS`; `PALABRA → CONFIAR`; `BENDICIONES → CONVIVENCIA`; `RESURRECCION → DESACUERDO`; `CONSOLACION → CONFIANZA`; `GENERACION → CUIDARNOS`; `SALVACION → RESPETARNOS`; `ADORACION → SOLIDARIDAD`; `NACIMIENTO → ACOMPANAR`; `REVELACION → COMPARTIR`; `MANDAMIENTO → APRENDIZAJE`; `DESCENDIENTE → GENEROSIDAD`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M3 — Noé y la esperanza
**Banco:** `es-ES/diluvio.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`BARCO · ARCA · AGUAS · OLIVO · PACTO · DIOS · AMOR · VIDA · LUZ · PAZ · AVES · MAR · RIO · NUBE · MONTE · LLENO · SECO · AVE · LAGO · CAMPO · LLUVIA · PAREJAS · PALOMA · ARCOIRIS · MONTANA · CUBIERTA · VENTANAS · PUERTAS · REFUGIO · ANIMALES · CUARENTA · PROMESA · FAMILIA · DILUVIO · MADERAS · ALIMENTO · CAMINO · CUIDADO · SEMILLA · VOLVER · REGRESO · FUTURO · SALVAR · ANIMOS · JUNTOS · PERDON · ARBOLES · CONFIAR · AVANZAR · COLORES · ESPERANZA · RENOVACION · EMBARCACION · NAVEGANTE · MULTITUDES · LLOVIENDO · PATRIARCA · DESCENDENCIA · NUBARRONES · RECOMENZAR · COMPARTIR · CUIDARNOS · AGRADECER · CONFIANZA · SEGURIDAD · NATURALEZA · COMPROMISO · CONVIVENCIA · CUIDADORES · ACOMPANAR`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (29):** `NOE → BARCO`; `SOL → AVES`; `PAN → NUBE`; `SAL → MONTE`; `RED → LLENO`; `OJO → SECO`; `VOZ → LAGO`; `REY → CAMPO`; `TEMPLO → CUIDADO`; `PROFETA → VOLVER`; `DESIERTO → REGRESO`; `ESPIRITU → FUTURO`; `CORDERO → SALVAR`; `PASTORES → ANIMOS`; `PALABRA → JUNTOS`; `HERMANO → CONFIAR`; `HERMANA → AVANZAR`; `PIEDRAS → COLORES`; `BENDICIONES → RECOMENZAR`; `RESURRECCION → COMPARTIR`; `CONSOLACION → CUIDARNOS`; `GENERACION → AGRADECER`; `SALVACION → CONFIANZA`; `ADORACION → SEGURIDAD`; `NACIMIENTO → NATURALEZA`; `REVELACION → COMPROMISO`; `MANDAMIENTO → CONVIVENCIA`; `DESCENDIENTE → CUIDADORES`; `LIBERACION → ACOMPANAR`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M4 — Abraham y las promesas
**Banco:** `es-ES/patriarcas.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`SARA · ISAAC · JACOB · JOSE · BETEL · HIJOS · DIOS · AMOR · VIDA · LUZ · PAZ · HIJA · HIJO · CASA · ROPA · POZO · TRIGO · GRANO · JUNTO · VOZ · ABRAHAM · RAQUEL · REBECA · CANAAN · EGIPTO · FARAON · HERMANOS · FAMILIAS · PADRES · TRIBUS · PROMESA · VIAJERO · CAMINOS · TIENDAS · PASTORES · MANADAS · DESIERTO · ALIANZA · HERENCIA · CUIDADOS · CAMINO · CARINO · SEMILLA · RESPETO · REGRESO · UNIDOS · ALEGRIA · PERDON · DECIDIR · HERMANO · DESCENDENCIA · RECONCILIAR · BENDICION · ENCUENTRO · ESPERANZA · CONFIANZA · AGRADECER · SOLIDARIDAD · CONVIVENCIA · APRENDIZAJE · COMPROMISO · GENEROSIDAD · RESPETARNOS · ACOMPANAR · COMPRENDER · LIBERACION · PROTECCION · CAMINANTES · RECOMPENSA · MISERICORDIA`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (24):** `SOL → HIJA`; `MAR → HIJO`; `RIO → CASA`; `PAN → ROPA`; `SAL → POZO`; `RED → TRIGO`; `OJO → GRANO`; `AVE → JUNTO`; `TEMPLO → CARINO`; `PROFETA → RESPETO`; `ESPIRITU → REGRESO`; `CORDERO → UNIDOS`; `PALABRA → ALEGRIA`; `ARBOLES → DECIDIR`; `BENDICIONES → CONFIANZA`; `RESURRECCION → AGRADECER`; `CONSOLACION → SOLIDARIDAD`; `GENERACION → CONVIVENCIA`; `SALVACION → APRENDIZAJE`; `ADORACION → COMPROMISO`; `NACIMIENTO → GENEROSIDAD`; `REVELACION → RESPETARNOS`; `MANDAMIENTO → ACOMPANAR`; `DESCENDIENTE → COMPRENDER`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M5 — Moisés, libertad y justicia
**Banco:** `es-ES/exodo.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`AARON · SINAI · EXODO · MANA · DAVID · SAUL · ELIAS · REYES · TRONO · DIOS · AMOR · VIDA · LUZ · PAZ · LEY · MAR · JUEZ · PAN · LIDER · DIAS · MOISES · MIRIAM · EGIPTO · FARAON · LIBERTAD · MANANA · DESIERTO · TABLAS · PUEBLO · CAMINO · SAMUEL · ISAIAS · PROFETAS · JUSTICIA · SALMOS · VIRTUDES · LEVITAS · PROMESAS · TEMPLO · RESPETO · PROFETA · ALIENTO · AYUDAR · PASTORES · JUSTOS · PERDON · CUIDADO · CANTOS · ORIENTA · FAMILIA · SACERDOTE · MANDAMIENTOS · LIBERTADES · ESPERANZA · CONFIANZA · SOLIDARIDAD · RESPONSABLE · COMPROMISO · GENEROSIDAD · CONVIVENCIA · RECONCILIAR · AMABILIDAD · MANDAMIENTO · PROTEGERNOS · PROTECCION · CAMINANTES · RECOMPENSA · MISERICORDIA · AGRADECER · EVANGELIOS`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (21):** `SOL → LEY`; `RIO → JUEZ`; `SAL → LIDER`; `RED → DIAS`; `SEMILLA → RESPETO`; `ESPIRITU → ALIENTO`; `CORDERO → AYUDAR`; `PALABRA → JUSTOS`; `ARBOLES → CUIDADO`; `HERMANO → CANTOS`; `HERMANA → ORIENTA`; `LIBERACION → LIBERTADES`; `BENDICIONES → CONFIANZA`; `RESURRECCION → SOLIDARIDAD`; `CONSOLACION → RESPONSABLE`; `GENERACION → COMPROMISO`; `SALVACION → GENEROSIDAD`; `ADORACION → CONVIVENCIA`; `NACIMIENTO → RECONCILIAR`; `REVELACION → AMABILIDAD`; `DESCENDIENTE → PROTEGERNOS`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M6 — Jesús y su familia
**Banco:** `es-ES/infancia.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`JESUS · MARIA · JOSE · BELEN · ANGEL · MAGOS · ANA · DIOS · AMOR · VIDA · LUZ · PAZ · CUNA · NINO · CASA · MADRE · PADRE · BEBE · CANTO · AMAR · NAZARET · ESTRELLA · PASTORES · PESEBRE · INFANCIA · FAMILIA · TEMPLO · SIMEON · HOGARES · ALEGRIA · CUIDADOS · DESCANSO · CAMINO · ABRAZOS · PROFETA · TERNURA · ESPIRITU · CARINO · CRECER · PERDON · ESCUCHA · HERMANO · HERMANA · BARRIO · UNIDOS · JUSTICIA · CUIDADO · CORAZON · VECINOS · SIERVOS · NACIMIENTO · ANUNCIACION · CRECIMIENTO · SABIDURIA · PRESENTAR · ENSENANZA · JERUSALEN · EVANGELIO · RECUERDOS · CAMINANTE · OBEDIENCIA · ESPERANZA · BIENVENIDA · CONFIANZA · HOSPITALIDAD · SOLIDARIDAD · CONVIVENCIA · COMPARTIR · ACOMPANAR · APRENDIZAJE`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (25):** `SOL → CUNA`; `MAR → NINO`; `RIO → CASA`; `PAN → MADRE`; `SAL → PADRE`; `RED → BEBE`; `OJO → CANTO`; `AVE → AMAR`; `SEMILLA → ABRAZOS`; `DESIERTO → TERNURA`; `CORDERO → CARINO`; `PALABRA → CRECER`; `ARBOLES → ESCUCHA`; `PIEDRAS → BARRIO`; `MILAGRO → UNIDOS`; `ALTARES → VECINOS`; `BENDICIONES → BIENVENIDA`; `RESURRECCION → CONFIANZA`; `CONSOLACION → HOSPITALIDAD`; `GENERACION → SOLIDARIDAD`; `SALVACION → CONVIVENCIA`; `ADORACION → PROTECCION`; `PROTECCION → COMPARTIR`; `REVELACION → ACOMPANAR`; `MANDAMIENTO → APRENDIZAJE`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M7 — Jesús nos enseña a amar
**Banco:** `es-ES/ensenanzas.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`JESUS · PADRE · AMOR · PAZ · MONTE · REINO · PANES · PECES · DIOS · VIDA · LUZ · AMAR · BUENO · MANO · PAN · SAL · AMIGO · CASA · AYUDA · VOZ · PERDON · SERVIR · ORACION · BIENES · PROJIMO · SEMILLA · PARABOLA · JUSTICIA · POBRES · CUIDADO · LIMPIOS · CORAZON · HUMILDAD · CAMINO · TEMPLO · PROFETA · RESPETO · ESCUCHA · BONDAD · AMABLE · PALABRA · SALUDAR · HERMANO · HERMANA · FAMILIA · HUMANOS · VECINOS · ALEGRIA · APOYAR · SIERVOS · COMPASION · ENSENANZAS · CAMINANTE · AMABILIDAD · MISERICORDIA · SOLIDARIDAD · FIDELIDAD · RECONCILIAR · ESPERANZA · HOSPITALIDAD · GENEROSIDAD · CONVIVENCIA · AGRADECER · CUIDARNOS · COMPARTIR · CONFIANZA · COMPROMISO · RESPETARNOS · LIBERACION · PROTECCION`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (25):** `SOL → AMAR`; `MAR → BUENO`; `RIO → MANO`; `RED → DAR`; `DAR → AMIGO`; `OJO → CASA`; `AVE → AYUDA`; `DESIERTO → RESPETO`; `ESPIRITU → ESCUCHA`; `CORDERO → BONDAD`; `PASTORES → AMABLE`; `ARBOLES → SALUDAR`; `PIEDRAS → HUMANOS`; `MILAGRO → VECINOS`; `ALTARES → APOYAR`; `MANDAMIENTO → SOLIDARIDAD`; `BENDICIONES → HOSPITALIDAD`; `RESURRECCION → GENEROSIDAD`; `CONSOLACION → CONVIVENCIA`; `GENERACION → AGRADECER`; `SALVACION → CUIDARNOS`; `ADORACION → COMPARTIR`; `NACIMIENTO → CONFIANZA`; `REVELACION → COMPROMISO`; `DESCENDIENTE → RESPETARNOS`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M8 — Jesús y sus amigos
**Banco:** `es-ES/amigos.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`PEDRO · JUAN · MATEO · TOMAS · MARTA · MARIA · PESCA · REDES · LAGO · DIOS · AMOR · VIDA · LUZ · PAZ · AMIGO · MAR · RIO · MANO · GENTE · RED · ANDRES · SANTIAGO · LAZARO · AMIGOS · BARCAS · ORILLAS · HERMANOS · AMISTAD · SERVICIO · CERCANOS · GALILEA · CUIDADOS · CAMINO · TEMPLO · ESCUCHA · ABRAZOS · SALUDAR · APOYAR · CONFIAR · AFECTO · UNIDOS · PERDON · RESPETO · HERMANO · HERMANA · FAMILIA · PIEDRAS · MILAGRO · JUSTICIA · ALEGRIA · APOSTOLES · DISCIPULOS · COMPANEROS · ENCUENTRO · ACOMPANAR · CONFIANZA · SEGUIDORES · SOLIDARIDAD · HOSPITALIDAD · ESPERANZA · COMPRENDER · COMPARTIR · CUIDARNOS · RESPETARNOS · GENEROSIDAD · CONVIVENCIA · AMABILIDAD · AMISTOSOS · AGRADECER · DESCENDIENTE`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (21):** `SOL → AMIGO`; `PAN → MANO`; `SAL → GENTE`; `SEMILLA → ESCUCHA`; `PROFETA → ABRAZOS`; `DESIERTO → SALUDAR`; `ESPIRITU → APOYAR`; `CORDERO → CONFIAR`; `PASTORES → AFECTO`; `PALABRA → UNIDOS`; `ARBOLES → RESPETO`; `CAMINANTES → SOLIDARIDAD`; `BENDICIONES → COMPRENDER`; `RESURRECCION → COMPARTIR`; `CONSOLACION → CUIDARNOS`; `GENERACION → RESPETARNOS`; `SALVACION → GENEROSIDAD`; `ADORACION → CONVIVENCIA`; `NACIMIENTO → AMABILIDAD`; `REVELACION → AMISTOSOS`; `MANDAMIENTO → AGRADECER`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M9 — Jesús vive: amor y esperanza
**Banco:** `es-ES/resurreccion.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`JESUS · CENA · PAN · COPA · AMOR · CRUZ · TUMBA · MARIA · ANGEL · PAZ · DIOS · VIDA · LUZ · CALMA · VIVIR · CUIDA · CREER · NUEVO · GOZO · HOY · ORACION · PIEDRA · MUJERES · PERDON · VIVIENTE · RESUCITO · CONSUELO · TESTIGOS · CAMINO · ALIENTO · AMISTAD · CONFIAR · CAMBIO · REUNION · CORDERO · APOYAR · PALABRA · SEGUIR · HERMANO · HERMANA · FAMILIA · TESTIGO · MILAGRO · JUSTICIA · ALEGRIA · CUIDADO · CORAZON · REGRESO · ESCUCHA · CUIDAR · DISCIPULOS · RESURRECCION · SALVACION · ESPERANZA · REDENCION · REENCUENTRO · COMUNIDAD · ENCUENTROS · SEGUIDORES · CONFORTAR · NUEVAVIDA · RECOMENZAR · CONFIANZA · COMPRENDER · COMPARTIR · GENEROSIDAD · SOLIDARIDAD · AMABILIDAD · CUIDARNOS · RESPETARNOS`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (27):** `SOL → CALMA`; `MAR → VIVIR`; `RIO → CUIDA`; `SAL → CREER`; `RED → NUEVO`; `OJO → GOZO`; `AVE → DAR`; `DAR → HOY`; `TEMPLO → ALIENTO`; `SEMILLA → AMISTAD`; `PROFETA → CONFIAR`; `DESIERTO → CAMBIO`; `ESPIRITU → REUNION`; `PASTORES → APOYAR`; `ARBOLES → SEGUIR`; `PIEDRAS → TESTIGO`; `ALTARES → REGRESO`; `SIERVOS → ESCUCHA`; `BENDICIONES → RECOMENZAR`; `CONSOLACION → CONFIANZA`; `GENERACION → COMPRENDER`; `ADORACION → COMPARTIR`; `NACIMIENTO → GENEROSIDAD`; `REVELACION → SOLIDARIDAD`; `MANDAMIENTO → AMABILIDAD`; `DESCENDIENTE → CUIDARNOS`; `LIBERACION → RESPETARNOS`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.

### M10 — Una comunidad que comparte
**Banco:** `es-ES/comunidad.json` · **70 normales exactas**, distribución 3–5 / 6–8 / 9–12 caracteres: **20 / 30 / 20**.
`AMOR · PAZ · DIOS · VIDA · LUZ · AYUDA · AMIGO · ABRIR · PAN · MANO · SALUD · CANTO · AVE · VOZ · REY · DIA · VER · DAR · SER · NOE · IGLESIA · AMISTAD · SERVICIO · ALEGRIA · CUIDADOS · ORACION · ENSENAR · AYUDAR · UNIDAD · HERMANOS · BONDAD · HUMILDAD · GRATITUD · REUNIDOS · CAMINO · TEMPLO · ESCUCHA · APOYAR · SALUDAR · RESPETO · JUNTOS · UNIDOS · PALABRA · PERDON · AFECTO · HERMANO · HERMANA · FAMILIA · ABRAZOS · VECINOS · COMUNIDAD · ESPERANZA · COMPARTIR · SOLIDARIOS · GENEROSIDAD · COMPASION · COLABORAR · CONCORDIA · SOLIDARIDAD · DISCIPULOS · SERVIDORES · ENCUENTRO · HOSPITALIDAD · RESPETARNOS · RESURRECCION · CONVIVENCIA · AMABILIDAD · SALVACION · COMPRENDER · COMPROMISO`

**15 palabras misteriosas existentes, con pista exacta:**
1. **ROCA** (4): Una piedra grande que se encuentra en la naturaleza.
2. **RAMA** (4): Parte del árbol que nace del tronco.
3. **ALAS** (4): Las aves las usan para volar.
4. **HOGAR** (5): Lugar donde una familia vive y se cuida.
5. **PATIO** (5): Espacio al aire libre junto a una casa.
6. **FAROL** (5): Lámpara que ayuda a iluminar el camino.
7. **TUNICA** (6): Prenda de vestir que aparece en muchos relatos antiguos.
8. **PUENTE** (6): Construcción que permite pasar de un lado a otro.
9. **MANTOS** (6): Prendas que se usan para cubrirse.
10. **PALOMAS** (7): Aves que pueden verse volando en grupo.
11. **REGALOS** (7): Objetos que damos para mostrar cariño.
12. **PASTORA** (7): Persona que cuida un rebaño.
13. **ALABANZA** (8): Expresión de gratitud y reconocimiento.
14. **ESCUCHAR** (8): Prestar atención a lo que otra persona dice.
15. **CAMINATA** (8): Recorrido que hacemos al andar.

**Cambios cerrados propuestos respecto a A5 (21):** `SOL → AYUDA`; `MAR → AMIGO`; `RIO → ABRIR`; `SAL → MANO`; `RED → SALUD`; `OJO → CANTO`; `SEMILLA → ESCUCHA`; `PROFETA → APOYAR`; `DESIERTO → SALUDAR`; `ESPIRITU → RESPETO`; `CORDERO → JUNTOS`; `PASTORES → UNIDOS`; `ARBOLES → AFECTO`; `PIEDRAS → ABRAZOS`; `MILAGRO → VECINOS`; `CAMINANTES → SOLIDARIDAD`; `BENDICIONES → RESPETARNOS`; `CONSOLACION → CONVIVENCIA`; `GENERACION → AMABILIDAD`; `ADORACION → COMPRENDER`; `NACIMIENTO → COMPROMISO`. **Pendiente:** aplicar dichos cambios en JSON y probar en el motor; misterios todavía no tematizados.


### Advertencias editorial/técnicas obligatorias
- Las primeras palabras deben ser **fáciles y cortas**. El validador actual impone como herencia 20% de palabras de 9–12 letras incluso en el mundo de 6×6: esas palabras **no caben en sus tableros**; un agente no debe concluir que las 70 se juegan. Si la cuota perjudica la experiencia, documentar corrección focalizada al validador y comprobar generador en lugar de forzar arcaísmos.
- Actualmente **los mismos 15 misterios se repiten en los diez bancos**. Además `WordRepository.parseCategory()` los convierte en un mapa por longitud (4, 5, 6, 7, 8) y sobrescribe dos de cada trío: en ejecución hay **solo cinco opciones efectivas por mundo**. No prometer 150 pistas distintas. Mejora opcional posterior: selección rotativa determinista por longitud, con prueba y sin rediseño general.
- `PuzzleGenerator.generate()` fue corregido en la integración A5 a **128 intentos deterministas** para evitar una triple aparición de SAL en nivel 178. No perder esa corrección al reconciliar PR #10 con #13.
- **Validación antes de aceptar catálogo:** formato, conteos, duplicados dentro de un banco, palabras normales vs misterios, longitud y proporciones, sentido bíblico y contemporaneidad del español; prueba generable/resoluble de niveles 1–300. **Los 84 tests y los 300 tableros reportados PASS en A5 cubren únicamente su vocabulario antiguo**, no estas sustituciones propuestas.
- Contexto imprescindible: una palabra positiva puede aparecer en varios relatos, pero no debemos afirmar que el versículo la pronuncia literalmente. Las frases de aprendizaje son **paráfrasis originales del juego**, no citas RV1909. Nunca narrar hechos históricos no sustentados sobre la juventud de Jesús.

## 4 · Arquitectura de software REAL, reutilización y módulos
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
**Decisión humana:** el correo/cuenta Google permite recuperar avance en otro teléfono. **Iniciar sesión no guarda progreso por sí mismo.** Solución mínima **PROPUESTA TÉCNICA (a implementar y probar):**
1. Android **Credential Manager + «Continuar con Google»**. Mantener **«Jugar sin cuenta»** accesible. No pedir contraseña propia ni usar un WebView embebido para inicio de sesión.
2. Solicitar permiso OAuth **`https://www.googleapis.com/auth/drive.appdata`** solo al activar «Guardar mi avance en Google», no acceso amplio a todo Drive. Google Drive **`appDataFolder`** ofrece almacenamiento oculto asociado a la cuenta de ese usuario, sin servidor propio. La autenticación y el permiso Drive son **dos operaciones diferentes**.
3. Guardar `sopa-cristiana-progress-v1.json`, esquema mínimo:
```json
{"schemaVersion":1,"game":"sopa-cristiana","language":"es-ES","nickname":"","updatedAtEpochMillis":0,"levels":{"1":{"stars":3,"bestSeconds":68}}}
```
4. **Local primero**: siempre salvar la victoria en DataStore, sin esperar internet; marcar pendiente sync. Al volver la red y existir autorización, leer backup de Drive, **fusionar estrellas por máximo** y **mejor tiempo válido**, recalcular álbum; escribir copia actualizada. Dos dispositivos: leer/fusionar antes de sobrescribir, reintentar en conflicto. No subir la Biblia, emails, tokens ni datos sensibles al JSON.
5. Invitado → cuenta: dar opción explícita **«Guardar mi avance en esta cuenta»**, sin transferencia automática no consentida. Cuentas diferentes: datos locales por perfil separado para no mezclarlos; cerrar sesión no borra copia remota. «Borrar mis datos» distingue borrado local de borrar backup Google con confirmación.
6. Offline: todas las pantallas del juego siguen funcionando como invitado o con sesión previa; si OAuth/Drive falla, aviso no bloqueante **«Tu avance sigue guardado en este dispositivo»**. No vender sincronización como «PASS» sin prueba real entre dos teléfonos.
7. **Única dependencia externa aún no disponible como dato de este repositorio:** configuración real de Google Cloud/Drive API, consentimiento OAuth, clientes Android, huellas SHA de builds y cuenta de prueba. El Humano ha autorizado la **función**, no ha proporcionado client IDs ni acceso a su consola. No inventarlos. Desarrollar UI, DataStore, contrato y tests offline independientes; solo el acceso real Google queda `PENDING` hasta contar con configuración.
8. No introducir Firebase, Firestore o backend por inercia: Google Drive appDataFolder es el mínimo a evaluar primero. Si aparece una incompatibilidad técnica REAL, Supervisor documenta la evidencia y una alternativa proporcionada, sin bloquear A1–A5.

**Fuentes oficiales para el agente Google:** https://developers.google.com/identity/siwg/best-practices ; https://developer.android.com/identity/credential-manager ; https://developers.google.com/workspace/drive/api/guides/appdata ; https://developers.google.com/workspace/drive/api/guides/api-specific-auth .

## 6 · Pantallas y experiencia de usuario
**Portada:** tema bíblico y botones claros «Jugar sin cuenta» / «Continuar con Google». **Inicio:** apodo opcional, continuar campaña, diez mundos, juego libre/diario si funcionan, álbum/ajustes. **Mapa:** solo mundos desbloqueados según progreso. **Nivel:** nombre, tablero, palabras y pistas. **Victoria:** 1–3 estrellas, referencia y breve mensaje positivo; siguiente nivel/reintentar. **Álbum:** diez fichas y cinco insignias, no añadir 300 tarjetas sin decisión humana. **Ajustes:** tamaño de letra, tema, sonido, accesibilidad y cuenta/estado de copia. **Final nivel 300:** mensaje de esperanza, amor, amistad y servicio. Todo en español cotidiano, botones táctiles legibles y sin presión religiosa.
**Visual:** PNG maestro real localizado en Drive SLC-VIS-001/v001; comparar seis capturas REALES con referencia, una única revisión humana visual consolidada ya autorizada. No sustituir PNG auténtico por imágenes arbitrarias ni abrir nuevas rondas burocráticas.

## 7 · Matriz de aceptación objetiva y estado (no inventar PASS)
| Criterio | Prueba/resultado exigido | Estado conocido |
|---|---|---|
| P01 10 mundos / 300 niveles / AT-NT / Noé M3 | Código, numeración y pantallas | Implementado en rama A2–A5; sin merge |
| P02 Catálogo 70+15 por mundo y español moderno | Diez JSON contra **§3**, muestreo de contenido | Nuevo catálogo DOCUMENTADO, sin implementar |
| P03 300 tableros generables y no ambiguos | Tests 1–300 con bancos **nuevos** | PASS reportado en A5 con bancos **anteriores** |
| P04 1–3 estrellas y desbloqueo 900 máximo | JVM + QA Android | JVM parcial PASS; QA físico PENDING |
| P05 Offline sin cuenta, reinicio y persistencia | modo avión + cerrar/reabrir en Android | PENDING prueba física |
| P06 Pistas/retos 10,20,30 y álbum | recorrido UI + pruebas | Código A4 presente; QA físico PENDING |
| P07 Fidelidad RV1909 y lenguaje actual | referencias contrastadas + lectura editorial | Documentado, revisión final PENDING |
| P08 Diseño Aventura Bíblica Moderna | seis pantallas y único checkpoint humano | A3 propuesta escrita; PENDING capturas/aprobación |
| P09 Inicio Google opcional | autorización OAuth real Android | NUEVO, NO IMPLEMENTADO |
| P10 Progreso restaurado en otra instalación | cuenta A, progreso, backup, dispositivo B, recuperar | NUEVO, NO IMPLEMENTADO |
| P11 APK privada verificable | build, bytes, SHA-256, firma, instalación | APK técnica Windows PASS reportada; no APK final |
| P12 Workflow V3 | Scope, SHA, PR, review independiente, handoffs | PR apilados abiertos; sin ACCEPT/merge |

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

## 9 · Plan de implementación SIN REINICIAR TRABAJO
| Etapa | Responsable | Trabajo concreto | Evidencia/salida |
|---|---|---|---|
| 0 | Supervisor | Revisar este documento, conflictos, A2 y alcance Google | PR documental y decisión de review |
| 1 · A2 #3 | Delfín | Aplicar **sustituciones exactas §3** en 10 JSON; actualizar nombres, guías, referencias y textos simples dentro de scope | diff, validador y 300 pruebas en integración |
| 2 · A3 #4 | Delfín | Comparativa real seis pantallas, mantener PNG y hacer correcciones focalizadas | paquete visual único para revisión humana |
| 3 · A4 #5 | Delfín | Progreso local, pistas, recompensas, invitado, precisión de datos | JVM y pruebas Android offline |
| 4 · A5 #6 | Delfín | Reconciliar PR #9–#13, mantener 128 intentos del generador; corregir residuos de portugués `Nível`, `Chefe` | build, test, APK técnica, checks |
| 5 · A6 NUEVO | Delfín | Google Credential Manager, Drive appDataFolder, sync seguro local-first, ajustes de cuenta | tests sin cuenta, con cuenta, offline y restauración Android |
| 6 | Supervisor | Revisión independiente por SHA y evidencia; coordinar única revisión visual humana | `ACCEPT/REWORK/BLOCK/ESCALATE` fundamentado |
| 7 | Humano | Instalar y probar la APK privada cuando esté revisada | feedback material y confirmación real |
**A6 justificación:** decisión nueva de cuenta/sync modifica dependencias y rutas fuera de A2–A5; requiere Work Item propio, scopes autorizados y **no debe obstaculizar** implementación independiente del resto. Ninguna tarea obliga a activar cada Issue en Windows: usar canal fijo #8.

## 10 · Gobernanza y handoff para un agente completamente nuevo
- **Autoridad:** HUMANO → JEFE → SUPERVISOR → DELFÍN. Supervisor escribe **solo este repositorio**. **Lago-1 = SOLO LECTURA**, jamás modificar allí código, issues o archivos.
- **Canal Jefe→Supervisor:** [Issue #1](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/1). **Canal Supervisor↔Delfín:** [Issue #8](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/8). Enviar comentario NUEVO con `MESSAGE_TYPE`, `FROM_ROLE`, `SEND_TO`, `TARGET_ROLE`, `REPOSITORY`, `WORK_ITEM`, `ACTIVITY`, `AUTHORITY_REF`, `RETURN_TO`, `STATE`, `REVIEW_HEAD`, `PR` y `VERIFICATION`. `PUBLISHED ≠ DELIVERED ≠ RESPONDED ≠ ACCEPT`.
- Antes de escribir, abrir Issue específico, verificar Path/Semantic/Resource Scope y HEAD. A2 catálogo; A3 visual; A4 local; A5 QA/build; A6 Google. No tocar rutas de otro work item unilateralmente.
- No crear «seguridad», auditorías o procesos abstractos que bloqueen código/pruebas: **avisar, documentar impacto concreto, mitigar mínimo si corresponde y continuar lo independiente**. Nunca exponer OAuth secrets/correos privados en GitHub público. No simular aprobación ni pruebas.
- No mezclar decisiones vigentes con propuestas del Supervisor. Si un término propuesto no cabe, choca con misterios, está descontextualizado o resulta demasiado difícil, devolver **palabra exacta, mundo, causa y corrección concreta**, no inventar más banco al azar.
- Fuentes a leer sin reconstruir todo: este documento; [Objetivo](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/blob/main/docs/OBJETIVO_PRODUCTO_CRISTIANO.md); [Alcance](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/blob/main/docs/ALCANCE_PRIMER_APK_V1.md); [Marcos](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/tree/main/docs); [Workflow V3](https://github.com/cmiloarevalo-hash/workflow/blob/main/docs/WORKFLOW_PLAN.md); [Guía QA5 Lago-1](https://github.com/cmiloarevalo-hash/Lago-1/blob/main/docs/r13/PROTOTIPO_ESTABLE_ACEPTADO_QA5.md); [Guía 1.30 candidata PR #68](https://github.com/cmiloarevalo-hash/Lago-1/pull/68).
- **Próxima acción medible:** A2 instala catálogo documentado, documenta si necesita cambio mínimo para la jugabilidad, vuelve a validar 300 niveles; A5 no espera pasivamente a OAuth; A6 prototipa el adaptador sin simular una cuenta real. La documentación no reemplaza prueba ni código.

**Registro de versión:** 11-11-2026, propuesta de Supervisión. Decisiones humanas consignadas literalmente por sentido; catálogos y nombres concretados por el Supervisor, **aún sin revisión editorial del Humano**. Actualizar estado, enlaces y SHA cuando se revise o integre; no afirmar que esta rama es `main`.
