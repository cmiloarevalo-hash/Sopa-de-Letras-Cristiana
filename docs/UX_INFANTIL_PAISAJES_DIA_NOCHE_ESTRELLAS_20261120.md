# Diseño infantil: Día soleado, noche estrellada y victorias festivas

**Sopa de letras -Biblia Rv-1909. Android candidata 1.0.11. 20-11-2026.**

## Propósito

Se atiende la petición de sustituir fondos planos y estrellas de victoria pequeñas por una apariencia infantil más viva. No se altera el tablero, las palabras ni la mecánica de selección.

## Cambios Android

- Escena de paisaje a pantalla completa dibujada con Canvas Compose: cielo con degradados, sol, nubes, montañas lejanas, colinas, camino, árboles y flores. Modo nocturno con luna, 85 estrellas, colores índigo/turquesa. Sin imágenes pesadas ni conexiones externas.
- Paleta de día más saturada y paneles cálidos; noche con azul marino profundo, paneles azules y acentos dorados. Los cinco colores de palabras encontradas son exactamente los existentes.
- Tema automático según el modo claro/oscuro del teléfono, con posibilidad de elegir día soleado o noche estrellada desde Ajustes. No se solicita la ubicación ni se calcula una hora de puesta de sol.
- Celebración: tres estrellas de 60 sp (antes 30 sp), brillo, aparición animada y confeti estático. Se aplica en campaña y misterios sin modificar los puntajes.
- Inicio, portada, campaña, ajustes, lector bíblico, álbum, logros y juego tienen el paisaje de fondo. Los tableros y tarjetas permanecen opacos para leer con comodidad.

## Pruebas

StorybookUxTest comprueba la escena, el modo automático, las estrellas y que el motor conserva los cinco colores. Validaciones de campaña, Biblia RV1909 y 300 niveles deben seguir aprobadas. Compilación CI, QA visual en pantalla pequeña y capturas se documentan cuando existan resultados verificables, sin anticipar aprobaciones.

## Port iOS

La rama base incluye el port iOS SwiftUI experimental. No llamar instalable para iPhone a una APK Android. La paridad visual se evaluará con las pruebas nativas de iOS antes de entregar una IPA.

## Restricciones

Sin publicidad adicional, permisos, conexiones externas, animaciones parpadeantes ni alteraciones a los datos del juego. Los paisajes son artísticos y no pretenden ser reconstrucciones históricas bíblicas.
