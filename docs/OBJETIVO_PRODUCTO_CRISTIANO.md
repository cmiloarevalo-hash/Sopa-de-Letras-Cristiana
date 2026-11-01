# Objetivo oficial de producto — Sopa de Letras Cristiana

**Fecha de decisión vigente:** 2026-11-01. **Autoridad:** Humano. **Estado:** definición de producto y preinvestigación, no implementación. **Repositorio:** `cmiloarevalo-hash/Sopa-de-Letras-Cristiana`.

## Misión y sentido de la aventura

Crear una **Sopa de Letras Cristiana** gratuita y apta para niños y jóvenes, con **300 niveles (10 mundos × 30)** y la identidad visual **Aventura Bíblica Moderna** aprobada por el Humano. La finalidad no es solo reconocer palabras: la aventura debe permitir **conocer a Jesús, aprender sobre los patriarcas y profetas, descubrir su vida, familia y amigos, su enseñanza del amor y la conexión con Dios Padre que Jesús aporta, así como su redención y salvación**.

**Dirección pedagógica expresa:** en los mundos del Antiguo Testamento, **Jesús nos presenta y ayuda a conocer** los relatos de los primeros tiempos, el Diluvio, los patriarcas, Moisés y los profetas. En los mundos del Nuevo Testamento se conoce a Jesús desde su infancia, su entorno familiar y su crecimiento hasta su vida adulta, su relación con personas cercanas, su enseñanza del amor, su entrega, la resurrección, la esperanza y la salvación. **Jesús como guía narrativo del juego es un recurso pedagógico, no la afirmación de que aparezca físicamente en las escenas del Antiguo Testamento ni una cita literal que no figure en RV1909.**

## Los siete puntos aprobados — vigentes

### 1. Campaña: diez mundos y trescientos niveles

La cifra **10 × 30 = 300** es fija. La estructura temática se ajusta a la **decisión más reciente del Humano**: el Diluvio separa los momentos anteriores y posteriores en el centro del tramo del Antiguo Testamento; la parte del Nuevo Testamento enfatiza a Jesús, su familia, sus amigos, la conexión con el Padre, la redención y la salvación.

| Mundo | Niveles | Eje narrativo general | Enfoque |
|---|---:|---|---|
| 1. La Creación | 1–30 | Creación, vida y primeros relatos | Antes del Diluvio; Jesús nos introduce a las Escrituras |
| 2. Los primeros tiempos | 31–60 | Personas y acontecimientos anteriores al Diluvio | Antes del Diluvio; vocabulario infantil apropiado |
| 3. Noé y el Diluvio | 61–90 | Arca, agua, pacto, renovación y cambio de etapa | **Centro** de los cinco mundos del AT |
| 4. Patriarcas y promesas | 91–120 | Abraham, Sara, Isaac, Jacob, José y familias | Después del Diluvio; Jesús nos ayuda a aprender sobre los patriarcas |
| 5. Moisés, reyes y profetas | 121–150 | Éxodo, camino del pueblo, reyes y profetas | Después del Diluvio; contexto y esperanza |
| 6. Jesús, su infancia y familia | 151–180 | Nacimiento, María, José, hogar y escenas bíblicas de infancia | Datos sobre su juventud limitados por las fuentes, no inventar biografía |
| 7. Jesús crece y enseña | 181–210 | Transición hacia su vida pública, amor, enseñanzas y relación con Dios Padre | Vida adulta; esperanza y bien común |
| 8. Jesús, sus amigos y apóstoles | 211–240 | Discípulos, apóstoles, familia y personas de su entorno | Amistad, acompañamiento, cuidado |
| 9. Redención, resurrección y salvación | 241–270 | Entrega de Jesús, resurrección, perdón y esperanza | Tratar sufrimiento sin imágenes gráficas |
| 10. Comunidad y valores cristianos | 271–300 | Primeros cristianos, servicio, fe, amor, esperanza | Síntesis de ambos Testamentos y continuidad |

**Estado de los rótulos nuevos:** la estructura de 10 mundos, la ubicación central del Diluvio y los ejes expresados son decisiones de producto; los **nombres editoriales refinados de esta tabla son propuesta organizativa del Jefe**, no un conjunto de títulos individualmente pronunciados por el Humano. Podrán ajustarse preservando esos objetivos y los 300 niveles.

**Diferencia respecto a la imagen original:** el PNG de cinco pantallas sigue siendo la **referencia visual aprobada**, pero sus rótulos y orden iniciales de mundos representan una **maqueta conceptual anterior**. La tabla vigente manda sobre la distribución temática; la imagen manda sobre el **estilo de interfaz e ilustración**.

### 2. Dificultad progresiva, no imposible
Tableros del motor original de **6×6, 8×8, 10×10 y 12×12** que aumentan gradualmente en complejidad; palabras simples primero, términos menos comunes solo con contexto y pistas. Mantener los desafíos especiales del diseño de campaña (cronómetro, palabra misteriosa, cierre de mundo) sujetos a calibración real. Un niño con práctica debe poder completar **hasta el mundo 10**; la meta es desafiar sin bloquear. El conocimiento bíblico previo no será requisito para jugar.

### 3. AT y NT con Jesús como hilo conductor
Jesús es el vínculo pedagógico de la aventura: invita a conocer la historia bíblica, los patriarcas, el significado del amor y la relación con el Padre. Cada escena, palabra, pista y descubrimiento debe respetar **la Reina-Valera 1909 como referencia bíblica base decidida por el Humano**. Diferenciar estrictamente **hecho bíblico**, **explicación editorial**, **ayuda del juego** e **ilustración artística**. La secuencia y el alcance de la vida infantil/juvenil de Jesús no permiten inventar episodios que la fuente no relata.

### 4. Estrellas y álbum
Hasta **3 estrellas × 300 niveles = 900** estrellas máximas; posibilidad de repetir niveles. Álbum offline de descubrimientos bíblicos con fichas comprensibles de personas, lugares, eventos, valores y referencias bíblicas; desbloqueo ligado al progreso.

### 5. Logros e insignias
Insignias locales por mundos completados, avances, palabras misteriosas, estrellas y perseverancia. Sin castigos por ausencias, compras, anuncios ni incentivos manipuladores para menores. Los nombres y umbrales detallados son diseño posterior.

### 6. Visual «Aventura Bíblica Moderna»
Conservar la **imagen conceptual de cinco pantallas que el Humano aprobó** como referencia madre de estilo: ilustración de aventura, exploradores, caminos, diez mundos, UI moderna, estrellas, paneles cálidos, azul/violeta/turquesa/dorado y tableros legibles. Incorporar la nueva narrativa con Jesús de manera **respetuosa**, distinguible de los exploradores; nunca copiar el estilo visual del repositorio Biblia para Jóvenes. Consultar [Marco visual](MARCO_VISUAL.md) y [Referencias visuales](REFERENCIAS_VISUALES.md).

### 7. Reutilización y entrega
Reutilizar el motor **Kotlin/Jetpack Compose**, generación de tableros, campaña, dificultad, progreso, estadísticas, pistas y modos existentes tras verificar su funcionamiento. Adaptar contenido al español cristiano, diseño, validadores, identificador Android y firma. **Entrega inicial:** APK instalable y compartible que funcione offline y sin cuenta online. **Perfil local:** el jugador puede elegir un nombre o apodo para reconocer su avance, sin correo ni contraseña, editable/eliminable localmente; evitar pedir nombre completo a menores. Futuro previsto, no implementado: posible acceso con Google/Play Games, sincronización y distribución por Google Play.

## Condiciones de publicación y protección de menores
- Aplicación **gratuita**, sin donaciones, compras integradas, anuncios ni cuentas en línea en la primera versión.
- Descarga pública mediante APK desde páginas y eventual publicación en **Google Play**; la revisión de políticas vigentes, ficha de privacidad, público objetivo, clasificación de contenido, firma y formato de distribución será parte de la fase de publicación, no una conformidad presumida hoy.
- Contenido dirigido a niños y jóvenes sin violencia gráfica ni dramatizaciones traumáticas. La entrega y resurrección de Jesús se explican con verdad, tacto, esperanza y sin espectáculo de sufrimiento.
- Datos de usuario mínimos, locales; comprobar comportamiento real del respaldo de Android antes de declarar privacidad exclusivamente local.
- **Reina-Valera 1909:** referencia elegida, pero hay que fijar edición/digitalización específica, procedencia y derechos aplicables a cualquier cita embebida en un APK. No asumir permisos de cualquier reproducción digital.

## Marcos para el trabajo posterior
- [Marco visual](MARCO_VISUAL.md): lenguaje gráfico propio, comparación con el concepto aprobado, relación de Jesús como guía, accesibilidad.
- [Marco editorial](MARCO_EDITORIAL.md): fidelidad, edición RV1909, trazabilidad, tratamiento infantil y licencias.
- [Marco literario](MARCO_LITERARIO.md): estructura narrativa, voz, niveles y pistas.
- [Referencias visuales](REFERENCIAS_VISUALES.md): imagen madre y estado verificable de preservación.

## Estado verificable y límites
**Autorizado en esta interacción:** actualizar **documentación de producto** en GitHub. **No autorizado:** implementar, generar tareas/Issues, cambiar la app o afirmar lanzamiento. Los marcos ofrecen una preinvestigación que el Supervisor podrá convertir más adelante en alcances técnicos y verificaciones siguiendo Workflow V3. **No se ha elaborado ni probado el contenido individual de los 300 niveles.**

Investigación consultiva: [Biblia para Jóvenes](https://github.com/cmiloarevalo-hash/Biblia-para-j-venes-) `main@03efd98d` — **lectura editorial/literaria**, no fuente visual ni autorización para copiar corpus.

## Biblioteca compartida, nombres y versiones

La documentación normativa del juego **permanece en GitHub**. Los archivos de arte y materiales complementarios se organizan en [Google Drive: Sopa de Letras Cristiana](https://drive.google.com/drive/folders/1iENoEGadHyTbCkZlgjK1z2jf4FMQssrK) (con subcarpetas de [imágenes](https://drive.google.com/drive/folders/1Z-jU3IMoVOffDqAqVaypPEyqJc59dhdr) y [documentos](https://drive.google.com/drive/folders/1O5kEzYPuhzXwaKcQb8iRfasUfHx2Zb44)). Para que Jefe, Supervisor, Delfín y agentes asistentes puedan localizar los materiales, **consultar primero** el [Registro de recursos, versiones y disponibilidad](RECURSOS_DRIVE_VERSIONADO.md), respetando Workflow V3 y las autorizaciones del Humano.

Los nuevos archivos de Drive utilizarán nombres versionados `slc_<tipo>_<descripcion>_vNNN_AAAA-MM-DD.ext`; cada versión debe conservar su procedencia, estado, ruta/ID verificados y relación con el marco que la rige. En GitHub los documentos canónicos conservan nombre y registran cambios mediante SHA/commit; no se duplican por versión.

**Estado contrastado, 2026-11-01:** las carpetas Drive existen, pero las subcarpetas están vacías; el **PNG conceptual aprobado no ha sido subido**, por lo que ninguna IA debe describirlo como disponible en Drive ni afirmar haberlo descargado desde allí. Compartir un enlace a carpeta no acredita autorización de acceso de otros agentes.
