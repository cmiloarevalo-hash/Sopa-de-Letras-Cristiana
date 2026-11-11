# Alcance de la primera APK — Sopa de Letras Cristiana

**Extensión expresa del Humano · 11-11-2026:** se añade **Google opcional + recuperación de avance asociado a la cuenta** (Work Item [A6 #15](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana/issues/15)). Esta decisión modifica el alcance histórico «sin cuentas» pero mantiene **campaña offline e invitado sin cuenta**. Se propone Google Credential Manager + Drive appDataFolder **sin backend propio**. Las configuraciones Google Cloud reales y pruebas de segundo dispositivo aún no están acreditadas. Ver [especificación maestra única](ESPECIFICACION_MAESTRA_APK_CRISTIANA_V1.md), PR #14 pendiente de revisión. El resto del alcance aprobado y los A1–A5 permanece.


**Fecha:** 2026-11-01. **Estado:** especificación de producto y orientación de preparación, NO implementación. **Autoridad:** decisiones del Humano del proyecto. **Protocolo:** Workflow V3.

## Resultado solicitado
Entregar una primera APK Android instalable en el teléfono del Humano para probar la **Sopa de Letras Cristiana**: 10 mundos × 30 niveles = **300 niveles**, español comprensible para niños y jóvenes, referencia bíblica **Reina-Valera 1909**, estilo **Aventura Bíblica Moderna**. La APK debe funcionar sin conexión ni cuenta online y guardar progreso local.

**Decisiones humanas:** gratuidad; sin anuncios, compras ni donaciones; perfil por apodo sin contraseña/correo; hasta 3 estrellas por nivel (900), álbum de descubrimientos bíblicos, logros/insignias y pistas; dificultad progresiva, pero sin niveles imposibles. Publicación pública en páginas y eventual Google Play son objetivos futuros sujetos a autorización de publicación separada. Arquitectura razonablemente ampliable a Play Games/cuentas en el futuro, **sin implementarlas ahora**.

## Narrativa
Jesús como guía de aprendizaje: enseña sobre los relatos anteriores y posteriores al Diluvio, patriarcas y profetas; después conocemos su infancia y familia, amistades/apóstoles, vida adulta, amor, relación con Dios Padre, redención, resurrección y salvación. No presentar frases ficticias como citas de Jesús ni inventar episodios de su juventud. No mostrar violencia gráfica.

| Mundo | Niveles | Tema general propuesto |
|---|---|---|
| 1 | 1–30 | La Creación |
| 2 | 31–60 | Los primeros tiempos, antes del Diluvio |
| 3 | 61–90 | Noé y el Diluvio, centro de los cinco mundos del AT |
| 4 | 91–120 | Patriarcas y promesas |
| 5 | 121–150 | Moisés, reyes y profetas |
| 6 | 151–180 | Jesús, infancia y familia |
| 7 | 181–210 | Jesús crece y enseña; amor y Dios Padre |
| 8 | 211–240 | Jesús, sus amigos y apóstoles |
| 9 | 241–270 | Redención, resurrección y salvación |
| 10 | 271–300 | Comunidad y valores cristianos; conexión AT/NT |

Los nombres refinados son propuestas editoriales del Jefe; la estructura 300 niveles y ejes narrativos expresados por el Humano sí son decisiones. Los 300 niveles individuales no están escritos ni probados todavía.

## Identidad visual aprobada
Imagen madre: [PNG original en Google Drive](https://drive.google.com/file/d/1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03/view?usp=drivesdk) · ID `1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03` · archivo REAL `aventura_biblica_moderna_aprobada.png` · **versión lógica v001 / SLC-VIS-001** · PNG, 2.362.665 bytes, 1536 × 1024. **Verificado en la carpeta de imágenes el 2026-11-01; no público**. No renombrar ni duplicar sin razón. El alias versionado del catálogo es `slc_visual_aventura_biblica_moderna_v001_2026-11-01.png`. La imagen manda sobre ESTILO, pero los temas actuales mandan sobre los textos antiguos de esa maqueta. No adoptar el estilo visual de «Biblia para Jóvenes».

**Fuentes canónicas:** [objetivos](OBJETIVO_PRODUCTO_CRISTIANO.md) · [marco visual](MARCO_VISUAL.md) · [editorial](MARCO_EDITORIAL.md) · [literario](MARCO_LITERARIO.md) · [registro Drive](RECURSOS_DRIVE_VERSIONADO.md).

## Qué debe funcionar en la primera APK
- Campaña de 300 tableros resolubles y progresión gradual (formatos de 6×6 a 12×12 según validación del motor).
- Contenido cristiano coherente con RV1909; banco de palabras y pistas probados, referencias correctas y redacción propia. Términos antiguos solo con explicación y pista.
- Pantallas esenciales reconocibles respecto al PNG: portada, inicio, mapa, tablero y victoria.
- Perfil local, progreso persistente, estrellas, álbum y logros básicos offline.
- Pistas escalonadas, accesibles sin conocimientos bíblicos previos ni penalizaciones que bloqueen a niños.
- APK instalable con identidad propia, firma acorde al carácter de prueba, checksum y referencia SHA del código. El Humano realizará la prueba física; no inferir instalación desde el build.

## Decisión expresa del Humano (2026-11-03): todos los agentes, continuidad y seguridad por alertas

**Regla obligatoria para todos los agentes del proyecto (Jefe, Supervisor, Delfín/Implementer y otros agentes autorizados):** queda **PROHIBIDO agregar instrucciones, requisitos, condiciones, verificaciones, controles o responsabilidades inventadas por el agente que generen bloqueos, esperas o interrupciones** del desarrollo o de los programas. Las propuestas propias no son órdenes del Humano ni deben imponerse como condiciones de avance. Respetar Workflow V3 y los límites de autoridad y permisos realmente aplicables, sin añadir obstáculos por iniciativa propia.

**Seguridad de los programas:** ante incidencias o riesgos ordinarios se deben emitir **avisos o alertas informativos**, sin impedir el funcionamiento del programa ni paralizar el trabajo autorizado. **Solo una situación de seguridad extrema, concreta y justificada puede motivar un bloqueo de seguridad.** No convertir una advertencia, una incertidumbre menor, una preferencia técnica o una comprobación opcional en veto. Las prohibiciones técnicas o de autorización que realmente sean obligatorias no quedan derogadas por esta regla.

**Continuidad:** si existe un impedimento puntual, registrarlo y proseguir con las demás tareas autorizadas e independientes; resolverlo sin exigir al Humano activaciones o aprobaciones rutinarias. El Supervisor mantiene la dirección técnica; el Jefe no asigna por cuenta propia nuevos controles ni tareas de administración del transporte.

**Transporte y límites del Jefe:** los agentes publican los handoffs por los Issues autorizados del repositorio; el software de Windows realiza su transporte mecánico según lo indicado por el Humano y **para el Jefe es solo lectura**. No imponer modificaciones ni reconfiguraciones de ese software. La publicación no demuestra por sí sola recepción.

**Precedencia respecto de sugerencias anteriores:** cualquier propuesta del Jefe de añadir condiciones para el canal, supervisión de Windows o controles no autorizados que pudiera bloquear el desarrollo queda expresamente **sin efecto como instrucción**. Esta regla es una **decisión del Humano**, no una propuesta técnica del Jefe.

## Preparación de ejecución bajo Workflow V3
El **Supervisor** identifica estado real, autoridad, baseline y scopes y prepara Work Items de investigación/implementación autorizados; decide soluciones técnicas, dirige a Delfín y revisa evidencia de manera independiente. El Jefe no suple la revisión ni emite estados técnicos. La intención humana es **evitar interrupciones por decisiones menores** hasta disponer de una APK candidata, pero **no activa agentes permanentemente entre chats** ni concede permiso para publicar en internet, gestionar cuentas o usar claves privadas. Ningún Work Item activo o Supervisor receptor se acredita por la publicación de este documento.

Etapas técnicas sugeridas para consideración del Supervisor: **línea base compilable → adaptación de bancos/idioma → 300 tableros válidos → interfaz y activos → progreso/estrellas/álbum/logros → pruebas Android → primera APK candidata**. Investigación de tecnologías actuales y control de licencias se realizarán antes de cada modificación material, sin añadir servicios innecesarios.

## Verificaciones, riesgos y decisiones todavía no cerradas
- **APK vs Play:** para prueba directa se necesita APK; nuevas apps de Google Play se publican normalmente como AAB. Firma, identificador, claves y distribución deben planificarse sin subir secretos a GitHub.
- **Niños:** declarar audiencias reales, política de privacidad, tratamiento de datos y clasificación cuando se prepare la publicación pública; no declarar cumplimiento no verificado.
- **RV1909:** verificar edición digital y permisos de redistribución de citas concretas; no copiar de «Biblia para Jóvenes».
- **Edades exactas, tratamiento doctrinal controvertido, representación definitiva de Jesús, nombre/ID definitivo de publicación y claves**: puntos materiales que deben registrarse como abiertos y elevarse solo cuando sean decisivos para el hito. No bloquear frentes técnicos independientes.
- **Drive:** el PNG está ubicado, pero el archivo reporta `shared:false`; cada agente debe verificar permisos. Un enlace no equivale a acceso público.
- **Pruebas:** no hay evidencia aún de 300 niveles cristianos probados ni de APK propia instalada en el teléfono del Humano.

Fuentes oficiales de consulta posterior: https://support.google.com/googleplay/android-developer/answer/9893335 ; https://support.google.com/googleplay/android-developer/answer/9867159?hl=es ; https://developer.android.com/guide/app-bundle/faq ; https://developer.android.com/studio/publish/app-signing.

**Esta especificación no ordena ejecución permanente ni autoriza publicaciones.**