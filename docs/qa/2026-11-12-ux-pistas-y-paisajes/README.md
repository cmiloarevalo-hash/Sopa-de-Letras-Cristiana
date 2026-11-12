# Auditoría visual UX: pistas, referencias y fondos

**Aplicación:** Sopa de letras -Biblia Rv-1909, candidata 1.0.10 (versionCode 29).  
**Fecha:** 12-11-2026. **Equipo:** emulador Android API36, pantalla efectiva 320×640.

## Hallazgos y correcciones

| Prueba | Resultado |
|---|---|
| Pista bíblica | Se eliminó el texto redundante sobre casilla iluminada y el botón duplicado. Solo pista breve + referencia bíblica tocable con «Leer la Biblia» + «Seguir jugando». |
| Enlace de versículo | Pulsar Génesis 1:3 desde la pista abre el texto exacto RV1909 en Génesis 1, versículo 3. |
| Tablero 6×6 | Letras y fondo marfil conservados, paisaje con más presencia; no cambia la mecánica. |
| Selección de palabras | Encontrar LUZ mantiene el amarillo original de las casillas y ficha. No se cambió la paleta de selección. |
| Misterio 8×8 | Tarjeta compacta, sin texto duplicado, referencia enlazada; Génesis 1:11–12 abre el lector directamente en el versículo 11. |
| Diálogo Adivinar | Se sustituyeron referencia sin enlace y botón separado por fila de lectura directa. Comprobado salto a Génesis 1:11. |
| Retorno de la Biblia | Partida queda pausada y ahora el diálogo dice «En pausa» y «Salir» en español. |
| Tema nocturno | Probado en 8×8; la ilustración tiene transparencia menor para evitar exceso de brillo. |
| Mapa de mundos | Paisaje más visible, texto con contraste; sin modificar tablero ni fichas. |

## Capturas reales del emulador

- [01 · Tablero y paisaje](01-tablero-paisaje-desde-telefono.png)
- [02 · Diálogo corto y referencia activa](02-pista-compacta-enlace.png)
- [03 · Llegada a Génesis 1:3](03-pasaje-genesis-1-3-destino.png)
- [04 · Amarillo de LUZ conservado](04-palabra-encontrada-paleta-intacta.png)
- [05 · Tarjeta de mundo](05-mapa-primer-mundo.png)
- [07 · Misterio con ficha compacta](07-tarjeta-misterio-compacta.png)
- [08 · Biblia desde la ficha de misterio](08-biblia-desde-misterio.png)
- [09 · Regreso con pausa en español](09-regreso-pausa-en-espanol.png)
- [10 · Diálogo Adivinar](10-dialogo-adivinar-misterio.png)
- [11 · Modo nocturno 8×8](11-modo-nocturno-8x8.png)

## Pruebas automáticas y límite de alcance

Gradle testDebugUnitTest + assembleDebug offline: BUILD SUCCESSFUL; **97/97 tests PASS**. Validador editorial: **300 niveles, 2524 asociaciones palabra-referencia, diez acrósticos y diez fondos** PASS. La APK de desarrollo usa versionCode 29 y firma debug Android v2. Enlace al lector probado con toque real en la UI; se conservan el applicationId y los datos locales. No se añadieron nuevas dependencias ni permisos.

## Recomendación de diseño para la siguiente revisión

Conservar los cinco colores de selección originales, el tablero sólido y el ritmo simple del juego portugués original. Los diez paisajes son más perceptibles, pero las tarjetas de mundo todavía se ven parecidas por el recorte central de las imágenes. **Propuesta:** mejorar el encuadre y añadir un único símbolo ambiental distintivo por mundo (arcoíris/arca, tiendas, desierto, lago/barca, jardín), nunca encima de las letras. Evitar marcos decorativos nuevos, grandes animaciones, más botones, rediseños generales y complejidad sin beneficio visible.

**Observación pendiente, no alterada:** después de leer la Biblia la partida vuelve pausada y exige tocar «Continuar»; es coherente con detener el tiempo, pero supone una pulsación adicional. Evaluar solo si el usuario la considera molesta.

**Estado:** QA en emulador; no es firma de producción ni validación de publicación definitiva.

