# Mejoras de jugabilidad autorizadas — Sopa de letras -Biblia Rv-1909
**Decisión humana, 11 de noviembre de 2026. Autoridad:** las instrucciones del Humano sobre UX, asociación de pistas y fondos, sobre la APK 1.0.7 RC2 de PR #18. **No confundir documentación, código implementado y QA aprobado.**

## Objetivo
El juego deja de usar una pista global inconexa. **Cada palabra buscada tiene una referencia bíblica y una pista propia**; la pista activa una letra real en el tablero. En los niveles de misterio, la **inicial de cada palabra de la lista, leída en el orden mostrado, forma la palabra misteriosa**. El jugador aprende una relación real, no adivina un añadido arbitrario.

## 1 · Contrato de PISTA POR PALABRA, para todos los modos
- Una pulsación en «Pista» elige una palabra **todavía sin encontrar** y marca **inmediatamente una casilla en su trayectoria**, sin exigir segunda pulsación para iluminar. Si ya se iluminó su primera letra en otra pista, marcar la siguiente casilla útil de la misma palabra; no desperdiciar ayudas. Reutilizar el límite de tres pistas del juego actual; no añadir monedas, anuncios, suscripciones ni nuevas capas de validación.
- Se abre un diálogo **corto, legible, con alto contraste**: «Pista bíblica», oración que ayuda a identificar esa palabra **sin pronunciarla ni regalar toda la respuesta**, libro/capítulo/versículo verificados en la **RV1909** y «Leer pasaje» (gratis) / «Seguir jugando». Mostrar «Letra iluminada en el tablero». Al volver del lector conservar y, si procede, pausar partida; no perder progreso.
- Cada palabra tiene `word`, `hint`, `reference`, `referenceBookId`, `referenceChapter`, `referenceVerse` y durante la partida un `placedWord.cells[]` para localizarla. El catálogo es la **matriz asociativa**; no hay que crear una base de datos remota.
- Una referencia se asigna **por palabra y por nivel**. Un mismo vocablo puede tener distintos pasajes si el contexto de dos episodios es distinto. Si no aparece literalmente en el pasaje, la pista debe decir que **se relaciona** con el relato y **no atribuir falsas citas**. Se conserva la ortografía original en el lector RV1909, y español moderno en el juego.
- Para la UI a 320 px, máximo título + pista breve en 2–3 renglones + referencia + dos acciones. Nada de cinco ventanas seguidas ni paneles que tapen el tablero sin necesidad.

## 2 · ACRÓSTICO DEL MISTERIO
- En los **diez niveles especiales** (20, 50, ..., 290), y en el modo Misterio libre, las palabras del tablero en **orden de lista** aportan **una letra cada una**: su **primera letra**. Su concatenación es **exactamente** la solución oculta. Ej.: `PASTORES · AMOR · SAL · TEMPLO · OVEJA · RIO · AMISTAD` -> `PASTORA`. Si dos palabras empiezan por A, su posición se determina por la lista, no por el orden en que se descubrieron.
- Cada hallazgo revela **su posición** de la palabra misteriosa, no necesariamente la primera casilla libre. Las casillas aún pendientes mantienen □. En la UI se deben distinguir visualmente inicial, palabra encontrada y casilla correspondiente; el usuario puede descubrir palabras en cualquier orden.
- **Ajuste editorial inevitable:** antes había niveles con 3–15 palabras pero palabras misteriosas de longitudes distintas; no puede existir relación estricta 1:1 sin revisar **solo los diez niveles especiales**. El conteo de palabras de esos niveles pasa a ser igual al número de letras del misterio. Los demás 290 niveles **no se rehacen**. Los diez especiales son retos de deducción; la alta densidad y los cruces se concentran en niveles difíciles normales y jefes.
- Modo Misterio libre: generar un acróstico válido con palabras de la categoría y la palabra misterio que corresponda; si las palabras elegidas no permiten el acróstico, **no enseñar una relación falsa ni una solución ajena al tablero**. Priorizar reusar las diez composiciones curatoriales.
- No premiar con letras aleatorias ni revelar una inicial que no corresponde al vocablo encontrado.

## 3 · GENERADOR: CALIDAD, CRUCES Y ANTI-REPETICIÓN
- Sin palabras duplicadas en el mismo tablero ni contenidos unos en otros. Repetir una palabra entre niveles cuando refuerza una enseñanza **sí** es admisible, pero **evitar repetir el mismo vocablo en los 3 niveles inmediatamente siguientes** dentro del mismo mundo; auditar especialmente niveles 1–30 que el usuario ya jugó.
- Auditoría de raíz semántica `AMOR/AMAR/AMADO` como aviso editorial, no bloqueo automático.
- **Niveles difíciles normales** (`n >= 10` y `cantidad >= 8`): al menos **dos palabras deben cruzarse compartiendo una misma casilla válida**. Medir cruces por trayectorias del generador, no por letras casualmente iguales en el relleno. Progresar a más cruces sin introducir imposibilidades en tableros pequeños.
- Las diagonales y palabras invertidas se agregan según progresión heredada. No rellenar con señuelos que creen soluciones ambiguas. 300/300 tableros y los diez misterios deben seguir resolviéndose.

## 4 · DISEÑO VISUAL DE MUNDO: DIEZ FONDOS LIGEROS
**Prohibido sobrediseñar.** Una sola plantilla visual compartida por los diez mundos: ilustración sencilla / paisaje al 10–18 % de presencia óptica **detrás** de la superficie, tablero sobre panel sólido o marfil claro, letras con contraste alto, chips claros, énfasis en la experiencia táctil. No poner letras, versículos ni imágenes religiosas fuertes dentro del fondo. Sin vídeos, 3D, animaciones pesadas, librerías externas ni fotos que recarguen APK. Un recurso ligero por mundo y reutilizable en mapa, portada de mundo y, con atenuación, juego.

| Mundo | Fondo distintivo propuesto | Color ambiental |
|---|---|---|
| 1 · La creación y la vida | Colinas verdes al amanecer, sol y aves | Verde salvia / celeste |
| 2 · Las primeras familias | Jardín, árbol de sombra y camino tranquilo | Verde oliva / arena |
| 3 · Noé y la esperanza | Arca a lo lejos, arcoíris suave tras la lluvia | Azul lluvia / malva |
| 4 · Abraham y las promesas | Tiendas de viaje y cielo estrellado | Ocre / índigo |
| 5 · Moisés, libertad y justicia | Desierto, montes y agua al horizonte | Arena / azul profundo |
| 6 · Jesús y su familia | Aldea de Belén con casas de piedra y luz cálida | Terracota / marfil |
| 7 · Jesús nos enseña a amar | Ladera luminosa frente al lago | Verde claro / cielo |
| 8 · Jesús y sus amigos | Orilla del lago con una barca discreta | Turquesa / arena |
| 9 · Jesús vive: amor y esperanza | Jardín y amanecer junto a una tumba sin figuras | Lavanda / dorado suave |
| 10 · Una comunidad que comparte | Plaza antigua con luz alegre y convivencia | Coral tenue / oliva |

**Marco visual:** misma cuadrícula, tamaños de fuente y táctiles, chips, pistas y barra; solo cambia paisaje y acentos sutiles. Modo oscuro conserva tablero contrastado; las imágenes son decorativas y no contienen información necesaria.

## 5 · REVISIÓN INDEPENDIENTE CRÍTICA, SIN BUROCRACIA
**Errores reproducibles detectados en capturas del Humano:** pista de episodio en vez de palabra; iniciales no vinculadas con solución; relleno visual plano; palabras repetidas tempranas; niveles supuestamente difíciles sin cruce exigible. Son defectos de jugabilidad, no sugerencias cosméticas.
- Validación automatizada: conteo por tablero, clave inicial-misterio, longitud de misterio, coincidencia palabra→pista→pasaje, longitud de pista, no repetición cercana, cruces reales, ausencia de respuestas duplicadas, funcionamiento sin internet.
- Prueba humana mínima: 6×6 y 12×12, misterio hallado fuera de orden, pista que ilumina una letra real, lectura de pasaje y regreso, contraste en teléfono pequeño, 10 paisajes distinguidos sin afectar legibilidad.
- **Sin controles administrativos nuevos ni bloqueos especulativos de seguridad.** Un defecto concreto trae evidencia y corrección. Google A6 sigue diferido al final según orden anterior; ni la UI ni la APK offline esperan OAuth.

## 6 · Orden para agentes
1. **A2 y A5 ya existentes:** consolidar matriz asociativa en catálogo y recurso Android, motor de pistas y acróstico de misterio, auditoría de repeticiones y cruces con tests.
2. **A3 ya existente:** incorporar plantilla de paisaje discreto y diez variantes sin cambiar la identidad visual anterior ni crear un sistema de diseño nuevo.
3. **A5:** compilar, instalar y comprobar en Android. Una **única revisión visual humana consolidada** para el conjunto; no interrumpir por aprobación de cada componente.
4. **A6 al final:** respaldo Google opcional cuando el juego esté listo; sin vincular ni bloquear otras áreas.
**Estado inicial de esta especificación:** DECISIÓN REGISTRADA / NO DECLARAR CÓDIGO IMPLEMENTADO ANTES DE PR Y TEST.
