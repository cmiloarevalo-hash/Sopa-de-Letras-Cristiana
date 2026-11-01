# Objetivo de producto — Sopa de Letras Cristiana

**Origen de autoridad:** decisiones expresas del Humano en el Proyecto ChatGPT «Jefe de Agente IA», 2026-11-01.  
**Tipo:** definición de producto; no es un Work Item ni una orden de implementación.  
**Estado:** objetivo y dirección visual definidos; adaptación cristiana aún no implementada.

## Finalidad y público

Desarrollar una aplicación **Sopa de Letras Cristiana** para **niños y jóvenes**, fácil de utilizar para los menores y suficientemente atractiva y moderna para adolescentes.

## Decisiones confirmadas por el Humano

1. **Plataforma y entrega:** aplicación Android, instalable mediante un **APK propio**.
2. **Campaña:** **conservar los 300 niveles** del proyecto de partida, estructurados como **10 mundos de 30 niveles**.
3. **Temática:** adaptación cristiana y bíblica, con palabras, pistas, categorías y ambientación pertinentes.
4. **Idioma objetivo inicial:** español para la experiencia y el contenido de la adaptación.
5. **Dirección visual elegida:** **«Aventura bíblica moderna»**.
6. **Referencia visual aprobada:** concepto mostrado en la conversación de ChatGPT del 2026-11-01; combina ilustraciones de paisajes bíblicos, mapa de mundos, cuadrícula clara, estrellas, botones grandes y colores intensos. **El archivo de imagen original aún no está incorporado a este repositorio**.
7. **Estado de autorización:** el Humano pidió registrar el objetivo y actualizar `main`; **no ha autorizado implementación técnica del juego en esta interacción**.

## Diseño visual — criterios de producto

- Apariencia aventurera, luminosa, amable y moderna; evitar tanto la estética escolar como el exceso de infantilización.
- Pantalla de inicio con acción principal clara para continuar la aventura y acceso a modos disponibles.
- Mapa de 10 mundos ilustrados con progresión, desbloqueo y estrellas.
- Tablero con letras grandes y legibles, selección táctil, lista visible de palabras y pistas accesibles.
- Indicadores y animaciones breves al completar palabras y niveles.
- Base cromática sugerida por la referencia: azul profundo, violeta, turquesa, dorado y tonos cálidos.
- El diseño exacto de las pantallas y los nombres definitivos de los mundos se validarán con el Humano antes de implementarse.

## Reutilización prevista de la base existente

Conservar, en la medida de lo funcionalmente verificable:
- Generación de tableros, selección táctil y dificultades.
- Progreso, guardado, estrellas y estadísticas.
- Estructura de 300 niveles.
- Desafío diario, contrarreloj, juego libre y palabra misteriosa, sujetos a adaptación de contenido e interfaz.
- Aplicación Android en Kotlin/Jetpack Compose con funcionamiento local.

Adaptar o sustituir según corresponda:
- Bancos de palabras, categorías, pistas y distribución temática.
- Textos de interfaz originalmente en portugués; experiencia prevista en español.
- Identidad visual, icono, nombre e identificador Android para la propia aplicación.
- Validadores y pruebas afectados por los nuevos bancos, incluidos límites de longitud y tratamiento de tildes/Ñ.
- Configuración de compilación y firma necesaria para distribuir APK propio.

## Criterios de éxito de producto

- **Instalación:** existe un APK de nuestra aplicación instalable y ejecutable en un dispositivo Android compatible.
- **Campaña:** están disponibles y son jugables los **300 niveles** con contenido apropiado.
- **Audiencia:** interfaz legible y fácil de navegar para niños y suficientemente atractiva para jóvenes, validada por el Humano.
- **Tema e idioma:** vocabulario e interfaz cristianos en español, con pistas coherentes.
- **Continuidad:** el jugador puede continuar su progreso; se comprueba el comportamiento real en el APK.
- **Calidad:** compilación, verificaciones pertinentes y pruebas funcionales observables; no inferir PASS o aceptación de una mera descripción.

## Estado técnico y siguientes decisiones

**Base verificada por inspección de código:** `main` anterior a esta actualización: `9269ea116847cc763e0dec8047407dfbc94017df` (rama bifurcada del proyecto original).

**No se afirma:** que los 300 niveles cristianos ya estén implementados, que el APK propio exista, que la referencia visual esté guardada en GitHub o que el Supervisor haya aceptado entregas.

**Pendiente de definición antes del trabajo técnico:** alcance de la primera versión, categorías y vocabulario bíblico, fuentes permitidas para textos bíblicos, detalle final del diseño y Work Items bajo Workflow V3. El Supervisor conservará la dirección técnica y sus revisiones; la publicación externa queda bajo autorización del Humano.
