# Corrección de tamaño y créditos · Sopa de letras -Biblia Rv-1909

**Solicitud humana · 12-11-2026.** Ajustar «Palabra misteriosa», mostrar contacto del desarrollador y mencionar otra aplicación cristiana sin inventar enlace de descarga. Implementación basada en la candidata 1.0.8.

## Defecto y solución
**Error observado:** en la pantalla de configuración se podía seleccionar 8×8, pero la ruta del modo libre tomaba el tamaño de un nivel especial de campaña (10×10 o 12×12). El resultado no respetaba la elección del jugador.

**Corrección:** el modo «Palabra misteriosa» utiliza siempre el tamaño seleccionado: **6×6, 8×8 o 10×10**. Se creó una pequeña tabla editorial \`app/src/main/assets/campaign/es-ES/free_mystery_sizes_v1.json\` con **30 combinaciones** (10 categorías × 3 tamaños). Las palabras están adaptadas a la cuadrícula y sus iniciales siguen formando la palabra misteriosa. Cada misterio tiene pista y referencia bíblica. En tableros 6×6 hay misterios más cortos para evitar palabras imposibles; ello no cambia los 300 niveles fijos de campaña.

**Datos conservados:** no se cambia el \`applicationId\` Android, la firma de esta línea de prueba ni el progreso local guardado; no se modifica la campaña original.

## Créditos y otra aplicación
El panel **Ajustes → Acerca de esta aplicación** muestra:
- Nombre: **Sopa de letras -Biblia Rv-1909**
- Desarrollador: **Camilo Arévalo**
- Correo de contacto: **apkcristiana@gmail.com** (enlace al correo del dispositivo)
- Otra aplicación del desarrollador: **Guía pastoral - Biblia**
- Texto de orientación: «Guía de lectura y formación bíblica. Consulta su disponibilidad escribiendo al correo de contacto».

Se cotejó el **nombre** «Guía pastoral - Biblia» y la atribución al desarrollador en el plan de distribución Android de esa aplicación fechado 08-11-2026. **El correo indicado por el usuario para esta APK es apkcristiana@gmail.com** y se mantiene separado del contacto histórico que figure en la otra aplicación. No se afirma que Guía pastoral - Biblia esté publicada ni se inventa un enlace público.

## QA
- Prueba JVM \`FreeMysterySizesTest\` genera y comprueba **las 30 combinaciones reales** con el motor Android: tamaño elegido, palabras colocadas, acróstico y referencia.
- Prueba de metadatos: el desarrollador, el correo y la otra aplicación aparecen en recursos y Ajustes.
- Verificación integral pendiente o realizada se consigna en la PR y las evidencias de compilación; no equivale a certificación de publicación definitiva.
- Prioridad visual: comprobar desde un teléfono pequeño la configuración 8×8, el tablero resultante y el panel de créditos sin recargar la interfaz.

**Alcance:** corrección concreta y panel informativo sencillo; sin nueva arquitectura, sin permisos, sin funciones de seguridad adicionales ni rediseño.

