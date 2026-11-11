# Sopa de letras -Biblia Rv-1909 · Biblia integrada y pistas de la campaña

**Decisión humana 11-11-2026**: el nombre exacto de la app es **«Sopa de letras -Biblia Rv-1909»**. No renombrar el `applicationId` existente; el nombre visible cambia, no la identidad con la que se guarda el progreso.

## Biblia de dominio público, lectura offline

- **Fuente original**: [eBible.org — Santa Biblia, Reina-Valera 1909](https://ebible.org/spaRV1909/) · [registro de dominio público](https://ebible.org/bible/details.php?id=spaRV1909).
- **Descarga de origen**: `https://ebible.org/Scriptures/spaRV1909_usfx.zip`, fuente USFX XML.
- **Archivo XML `spaRV1909_usfx.xml`, SHA-256**: `233b4d6a87f833ac809d0e68dcf9ba83c709d612e914a357a4f5473782b703a3`.
- **Extracción offline**: 66 libros y **31.084 versículos** con citas originales sin modernizar vocabulario ni reescribir el texto de RV1909. Los recursos se ubican en `app/src/main/assets/bible/rv1909/index.json` y los 66 ficheros por libro.
- **Interfaz**: «Leer la Biblia RV1909» desde Inicio; selección libro, navegación entre capítulos, numeración de versículos, referencia desde pista y lectura sin internet.
- Las frases pedagógicas son **texto original del juego**, redactado en español actual; **no son citas textuales de la Biblia**. El lector deja intacta la ortografía histórica de RV1909.

## Mecánica exacta de palabra misteriosa

1. El nivel muestra las casillas de la palabra oculta en orden de lectura, con pista bíblica.
2. **Cada palabra normal encontrada revela exactamente una letra de la solución**, de izquierda a derecha. Ejemplo: `PACTO` → `P□□□□` → `PA□□□` → `PAC□□`. No se revelan al azar ni hay coste adicional.
3. Si el jugador reanuda una partida, se reconstruyen las mismas letras visibles contando las palabras que ya había descubierto.
4. «Adivinar» permite resolver antes de completar todas las palabras; al completar todos los términos del tablero, se revela la palabra completa según el comportamiento anterior. La dificultad no aumenta.
5. El feedback debe ser alegre y respetuoso; nunca castigar una respuesta incorrecta con mensajes negativos.

## Pistas bíblicas en todos los modos

- **Campaña, niveles normales, diarios, libres y contrarreloj**: modal «Pista bíblica» con contexto del episodio y referencia de libro/capítulo/versículo. «Leer en Biblia RV1909» abre el pasaje **sin gastar pistas**. «Iluminar una casilla» consume la ayuda permitida (en contrarreloj conserva penalización de cinco segundos).
- **Misterio**: la tarjeta del tablero cita su pista, indica el texto bíblico concreto, revela letras progresivamente; «Adivinar» permite respuesta libre; las pistas pueden llevar al lector offline.
- **Orden narrativo**: 10 mundos × 3 episodios, Antiguo Testamento a Nuevo Testamento, desde Génesis hasta las primeras comunidades. Todo el vocabulario de la campaña sigue siendo el catálogo exacto de 300 niveles previamente autorizado. Las pistas bíblicas de los 30 episodios están en `app/src/main/assets/campaign/es-ES/levels-v1.json`, campo `bibleHint`.
- **Diez retos misteriosos**: referencia individualizada del pasaje en `mystery.reference` y pista específica del relato, sin afirmaciones bíblicas inventadas.
- **Juego libre**: se contextualizan las quince pistas históricas por banco mediante referencias bíblicas reconocibles. El programa heredado todavía conserva el selector por longitud para esa modalidad; no confundir con la solución fija de los diez misterios de campaña.

## Revisión de portugués y compatibilidad

Se corrigieron los textos visibles heredados en ayudas iniciales, casillas accesibles a lectores de pantalla, temporizador, estadísticas y contrarreloj, además de la portada y la pantalla principal. **Solo el español es idioma de juego** para este producto; se mantiene el contenido histórico de PT/EN en el repositorio, sin ofrecerlo como idioma de la campaña actual.

La aplicación funciona localmente sin iniciar sesión. **Google sigue siendo una integración final**, conforme a la instrucción humana anterior; no se incorpora botón de sesión ficticio ni se condiciona la APK offline a la configuración OAuth.

## Checklist de verificación imprescindible

- Pruebas JVM: catálogo 300/300, diez misterios, función de revelación progresiva por orden, validación de 66 libros y referencias.
- APK Android: instalar/abrir, comprobar el nombre visible exacto, leer Génesis 1:1 y Lucas 2:10, saltar desde pista al libro/versículo, volver a la partida sin perder el progreso, abrir pistas en campaña/libre/contrarreloj/misterio, verificar contraste y facilidad de lectura en 320×640.
- QA no acreditada todavía: revisión humana visual consolidada, recuperación Google entre dispositivos, firma de producción y publicación final. No confundir `assembleDebug` con APK definitiva.

**Entrega por rama de Supervisor**: cambios de contenido y experiencia sobre la integración A5+RC1 ya compilada, a revisión independiente bajo Workflow V3; no publicación automática.

