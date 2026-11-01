# Objetivo oficial de producto — Sopa de Letras Cristiana

**Fecha de decisiones:** 2026-11-01. **Autoridad:** Humano. **Estado:** decisiones de producto registradas; implementación, pruebas de la adaptación y APK propio **no realizados**. Este documento no crea Work Items ni sustituye al Supervisor.

## Visión
Juego Android en español para **niños y jóvenes**, divertido y bíblicamente responsable, con estilo **Aventura Bíblica Moderna**. La primera versión se distribuye como **APK firmado, compartible, instalable y funcional sin conexión obligatoria y sin cuenta**; progreso y recompensas se guardan localmente. En el futuro se podrá **evaluar** vinculación de cuentas, sincronización y Google Play, sin desarrollar ahora infraestructura de servidores/autenticación.

## Los siete puntos decididos por el Humano

### 1. Diez mundos bíblicos, 300 niveles
**Mantener exactamente 10 mundos de 30 niveles = 300 niveles**, con progresión. El Humano aprobó los nombres y el orden del concepto:

| Mundo | Niveles | Nombre | Eje temático |
|---|---|---|---|
| 1 | 1–30 | La Creación | Antiguo Testamento; Génesis, luz, tierra, jardín del Edén |
| 2 | 31–60 | Noé y el Diluvio | Antiguo Testamento; arca, animales, lluvia, pacto y arcoíris |
| 3 | 61–90 | Los Patriarcas | Antiguo Testamento; Abraham, Sara, Isaac, Jacob y José |
| 4 | 91–120 | Moisés y el Éxodo | Antiguo Testamento; Egipto, liberación, desierto y mandamientos |
| 5 | 121–150 | Reyes y Profetas | Antiguo Testamento; David, Salomón, Elías, Daniel, Ester y otros |
| 6 | 151–180 | La Vida de Jesús | Nuevo Testamento; nacimiento, ministerio, milagros, muerte y resurrección |
| 7 | 181–210 | Parábolas y Enseñanzas | Nuevo Testamento; relatos y enseñanzas de Jesús |
| 8 | 211–240 | Los Apóstoles | Nuevo Testamento; discípulos, llamados y misión |
| 9 | 241–270 | La Iglesia Primitiva | Nuevo Testamento; Pentecostés, Pablo y primeras comunidades |
| 10 | 271–300 | Valores Cristianos | Recapitulación transversal de ambos Testamentos: fe, esperanza, amor, justicia, perdón y servicio |

Los primeros cinco mundos suman **150 niveles del Antiguo Testamento**, los mundos 6–9 **120 del Nuevo Testamento** y el último **30 de síntesis AT/NT**. Esta distribución no define por sí misma un canon de 66 o 73 libros.

### 2. Dificultad progresiva
Los tableros **crecen progresivamente** en dimensión y complejidad, reutilizando los formatos 6×6, 8×8, 10×10 y 12×12 del motor actual. Mantener el patrón de campaña existente: **nivel 10 cronometrado, 20 palabra misteriosa, 30 gran desafío** en cada mundo. Calibrar palabras, direcciones y tiempos para niños y jóvenes; permitir repetir niveles y usar pistas sin castigo desproporcionado. El balance concreto requiere pruebas.

### 3. Aprovechamiento de ambos Testamentos
Cada nivel debe tratar un tema reconocible con vocabulario, pistas y un descubrimiento bíblico breve cuando corresponda. Registrar referencias comprobables y **distinguir hechos/texto bíblico de notas editoriales, paráfrasis y juego**. La tradición/canon, edición y licencias concretas de citas quedan **pendientes de decisión y verificación**. No insertar corpus de otro repositorio por inferencia.

### 4. Motivación por estrellas y álbum
Hasta **3 estrellas por nivel**, máximo **900** en toda la campaña; se puede repetir para mejorar. Incorporar **álbum de descubrimientos bíblicos**, guardado offline, con fichas de personajes, lugares, acontecimientos y enseñanzas desbloqueadas con el progreso. Los contenidos e imágenes requieren revisión editorial y derechos claros.

### 5. Logros e insignias
Colección de **logros e insignias persistentes, visibles y obtenibles offline** por progreso, mundos, palabras misteriosas y estrellas. Ejemplos de identidad propuestos: Primer descubrimiento, Guardián del Arca, Explorador del Éxodo, Investigador Bíblico, Coleccionista de Estrellas, Gran Explorador Bíblico. Umbrales finales por definir; sin compras, cuentas, ni penalizaciones por no jugar diariamente.

### 6. Estilo visual aprobado
**Aventura Bíblica Moderna**, tal como aparece en la **imagen conceptual de cinco pantallas aprobada por el Humano**. Dirigido a niños **y** jóvenes; aventura cálida y luminosa, escenarios narrativos, personajes exploradores, mapa de mundos, botones grandes, estrellas doradas y tablero legible. Su identidad es **propia y no deriva del diseño visual de «Biblia para Jóvenes»**. Consultar [Marco visual](MARCO_VISUAL.md) y [Referencias visuales](REFERENCIAS_VISUALES.md).

### 7. Reutilización del código y APK
Reutilizar, tras verificación funcional, Kotlin/Jetpack Compose, generación y selección de palabras, dificultades, campaña, guardado, estadísticas y modos existentes. Adaptar idioma, bancos de palabras, pistas, validación, ilustraciones, interfaz, identidad Android y firma. **Entregable inicial:** APK autónomo y firmado, probado en teléfono, compartible para instalación directa, **sin cuenta ni red obligatoria**. Mantener identificadores y persistencia organizados para facilitar eventual migración futura; **no** implementar autenticación, nube o Google Play ahora.

## Marcos que deben seguir las futuras entregas
- [MARCO_VISUAL.md](MARCO_VISUAL.md): lenguaje de imágenes, consistencia, interfaz y criterios de revisión visual.
- [MARCO_EDITORIAL.md](MARCO_EDITORIAL.md): criterios de fidelidad, fuentes, clasificación, derechos y control de contenido.
- [MARCO_LITERARIO.md](MARCO_LITERARIO.md): voz, lenguaje, tono, secuencia narrativa y estructura por mundo/nivel.
- [REFERENCIAS_VISUALES.md](REFERENCIAS_VISUALES.md): descripción textual y situación del archivo de imagen aprobado.

## Criterios verificables para el producto futuro
1. Los 300 niveles cristianos son generables, jugables y guardan progreso en APK real.
2. La dificultad se incrementa sin impedir jugar a quienes desconocen la Biblia; los modos especiales funcionan.
3. Se registran hasta 900 estrellas; álbum e insignias persisten localmente tras reiniciar aplicación.
4. Temas, palabras, pistas y descubrimientos tienen fuentes y coherencia editorial; contenido bíblico literal posee derechos comprobados cuando corresponda.
5. La interfaz está en español y sigue la línea visual elegida; accesible para niños y no infantilizante para jóvenes.
6. APK propio instalable y utilizable sin cuenta ni conexión obligatoria, probado físicamente.
7. Las posibles cuentas y Google Play quedan como evolución futura no incluida en esta versión.

## Estado y atribuciones
**Confirmado por el Humano:** los siete puntos y los diez mundos, estilo gráfico, APK local sin cuenta y posibilidad de crecer posteriormente. **Guías propuestas por el Jefe:** los detalles reproducibles de marcos y criterios de ejecución; no son decisiones del Supervisor ni aprobación de código. **Sin ejecutar:** cambio del juego, generación del nuevo APK y alta de cuentas. **Pendientes materiales:** canon/confesionalidad, fuente de citas y detalles de contenido de cada nivel, revisados con el Humano.

Fuente de investigación editorial utilizada **solo como consulta**: [Biblia para Jóvenes](https://github.com/cmiloarevalo-hash/Biblia-para-j-venes-), estado documental **STANDBY**, consulta de \`main@03efd98d6ae3582f67793b6eaa783b4e1901a793\`. No se ha copiado corpus ni adoptado su diseño visual.