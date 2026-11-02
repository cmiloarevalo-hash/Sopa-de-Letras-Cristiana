# Handoff de arranque — Jefe de Agente IA → Supervisor

**Proyecto:** Sopa de Letras Cristiana · **Emisor real:** Jefe de Agente IA · **Lectura destinada a:** Supervisor responsable, una vez que el Humano transporte el aviso breve · **Fecha:** 2026-11-02 · **Versión de este handoff:** v001.

**Naturaleza del registro:** handoff **documental de producto y organización**, publicado en GitHub por el Jefe a petición expresa del Humano. **No es** un mensaje técnico enrutado Supervisor ↔ Implementer, no es una revisión/aceptación del Supervisor, ni un Work Item ni activación de ejecución. Para no falsificar enrutamiento V3, este archivo **no usa `SEND_TO`, `FROM_ROLE: Supervisor` ni `TARGET_ROLE` de un canal no verificado**. El Humano transportará el **aviso corto con el enlace exacto** a la sesión del Supervisor; la publicación no acredita recepción.

## 1. Autoridad: decisiones expresas del Humano

- **Objetivo de primera entrega:** una **APK Android propia, liviana, offline, instalable y comprobable** para que el Humano la pruebe en su teléfono. **No** constituye autorización de publicación pública ni de despliegue en Google Play.
- **Producto:** `10 mundos × 30 niveles = 300` tableros con contenido cristiano en español y dificultad progresiva para niños y jóvenes; Jesús como guía pedagógica y referencia editorial Reina-Valera 1909. El Diluvio está en el **mundo 3** de los cinco del Antiguo Testamento.
- **Experiencia:** pistas suficientes para avanzar, tres estrellas máximas por nivel (900), perfil por apodo **local**, progreso persistente, álbum bíblico e insignias/logros. Sin anuncios, compras, donaciones, cuenta online, backend o conexión obligatoria.
- **Diseño:** identidad **«Aventura Bíblica Moderna»** aprobada como referencia de estilo. No copiar el estilo visual de «Biblia para Jóvenes». La imagen es una maqueta estética, no especificación literal de los nombres antiguos de sus mundos.
- **Participación del Humano:** **una única revisión visual consolidada antes de cerrar el diseño para la primera APK** y, después, **instalación/prueba de la APK candidata**. No formular consultas de rutina sobre diseño de código, bancos, tests, ajustes menores o tecnologías. Elevar solo cambios materiales reservados, permisos/recursos sensibles o bloqueos verdaderamente críticos.
- **Autonomía:** el Supervisor responde por la planificación e ingeniería, los Work Items, la asignación técnica a Delfín (si procede) y la revisión independiente. Decidir el detalle técnico dentro de alcances autorizados; **no pedir aprobaciones innecesarias** ni crear una nueva capa de autoridad.
- **Ingeniería mínima suficiente:** reutilizar/adaptar el juego original y sus componentes; no imponer rediseño total, nuevos servicios, múltiples capas, infraestructura cloud, marcos de seguridad desproporcionados ni documentación redundante. Seguridad adecuada al riesgo de una app infantil **sin red**. **Medir** el tamaño real del APK, no prometer ni imponer un límite arbitrario de MB.
- **Dos IA interlocutoras para el Humano:** Jefe y Supervisor; Delfín es subordinado técnico del Supervisor, no interlocutor del Jefe. **Las IA publican sus registros completos/handoffs** por el canal de GitHub que su actividad tenga realmente autorizado; **el Humano solo transporta el aviso corto** entre sesiones. Supervisor → Jefe: el Supervisor publica la evidencia pertinente y prepara el puntero que el Humano transporta. No presumir comunicación automática entre chats.

Estas decisiones son **del Humano**, no preferencias técnicas del Jefe. Los nombres afinados de los diez mundos y la agrupación en cinco actividades son **organización documental propuesta por el Jefe**, subordinada a los objetivos humanos.

## 2. Cinco actividades principales para orientar el trabajo

| ID | Resultado esperado | Subcategorías de trabajo |
|---|---|---|
| **A1 Base Android e ingeniería** | Línea base comprobada, código reutilizado y estrategia mínima del Supervisor | Auditoría, compilación/CI, dependencias, motor, persistencia y permisos/scopes |
| **A2 Contenido y 300 niveles** | Campaña cristiana en español y tableros válidos | Edición RV1909 y derechos, mundos, banco, dificultad, referencias, pistas y validadores |
| **A3 Visual y UX** | Propuesta gráfica unificada lista para **una sola validación humana** | Portada, inicio, mapa, tablero, victoria, álbum/logros, exploradores, legibilidad |
| **A4 Juego offline y progreso** | Mecánicas integradas, ayudas, perfil local, persistencia y recompensas | Motor y selección, DataStore, estrellas, álbum, insignias, modos útiles |
| **A5 Calidad y APK** | APK candidata verificable y guía de instalación | Regresión, pruebas de los 300 tableros, integración, rendimiento/peso, CI, hash, firma de prueba |

**No imponer fases secuenciales rígidas.** El Supervisor decide precedencias y paralelización real según Work Items, recursos y autorización. Evitar microtareas y reuniones/reportes de rutina.

## 3. Ingeniería básica: código existente inspeccionado

Repositorio: [`cmiloarevalo-hash/Sopa-de-Letras-Cristiana`](https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana). Línea base documental consultada al preparar este handoff: `main` = `21431fa1649a7fc3265b7d1ca93e846cd0c7aafe` **antes de añadir el propio handoff**. El Supervisor deberá recuperar el **HEAD actual**, no usar este SHA como orden fija de checkout.

- `app/src/main/java/app/sopadeletras/core/`: campaña, generador de tableros, selección, puntajes y dificultad; `Campaign.kt` ya define 300 niveles y 10 mundos, **todavía con nombres portugueses**.
- `app/src/main/java/app/sopadeletras/data/`: `CampaignContent.kt` sigue apuntando a categorías originales y `APP_LANGUAGE = "pt-PT"`; `GameDataStore.kt` ya incorpora persistencia con DataStore.
- `app/src/main/java/app/sopadeletras/ui/`: pantallas Jetpack Compose, todavía con rótulos portugueses visibles. La primera APK cristiana debe presentarse en español.
- `app/src/main/assets/words/`: bancos iniciales `pt-PT` y `en-US`, no la campaña bíblica española definitiva. `tools/validate_words.py` valida explícitamente esos idiomas y necesitará adaptación justificada.
- `.github/workflows/ci.yml`: configura validación de bancos, tests unitarios y generación de `assembleDebug`. **Esto describe la configuración, no acredita que la rama cristiana compile o haya pasado las pruebas.**
- `app/build.gradle.kts`: identificador original `app.sopadeletras` y configuración de firma; la identidad de APK propia y su firma de prueba corresponden a ingeniería del Supervisor. Nunca introducir secretos privados en Git.

**Recomendación de ingeniería, NO arquitectura impuesta:** preservar el esquema ya disponible de **UI Compose ↔ motor `core` ↔ bancos bíblicos locales/almacenamiento DataStore**. Si el Supervisor identifica otra alternativa más simple o un riesgo verificable, conserva criterio técnico y lo registra en el Work Item correspondiente.

## 4. Fuentes canónicas de producto

- [Objetivos y diez mundos](../OBJETIVO_PRODUCTO_CRISTIANO.md).
- [Alcance y criterios de la primera APK](../ALCANCE_PRIMER_APK_V1.md).
- [Plan de cinco actividades e ingeniería mínima](../PLAN_BASE_5_ACTIVIDADES_APK.md).
- [Continuidad del Supervisor y handoffs](../CONTINUIDAD_SUPERVISOR_APK_V1.md).
- [Marco visual](../MARCO_VISUAL.md), [marco editorial](../MARCO_EDITORIAL.md), [marco literario](../MARCO_LITERARIO.md).
- [Registro de recursos Drive](../RECURSOS_DRIVE_VERSIONADO.md) y [referencias visuales](../REFERENCIAS_VISUALES.md).
- **Imagen madre real:** [PNG original aprobado en Google Drive](https://drive.google.com/file/d/1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03/view?usp=drivesdk), `SLC-VIS-001/v001`, nombre real `aventura_biblica_moderna_aprobada.png`, `image/png`, 2.362.665 bytes. **El archivo es privado** y la ubicación verificada no demuestra acceso del Supervisor; si el permiso falta, no sustituir por otra referencia visual arbitraria.

**Norma superior:** aplicar Workflow V3 **vigente y aprobado en su repositorio oficial** respecto a autoridad, Work Items, scopes, revisión, enrutamiento e integración. Este handoff no modifica V3 ni crea un `SEND_TO: ProjectLead` funcional. No obligar a usar GoFlow; no hay evidencia de que opere.

## 5. Qué debe hacer el Supervisor al recibir el aviso

1. **Verificar identidad y ruta:** destinatario Supervisor, repositorio exacto, versión actual de Workflow V3, decisiones humanas, autoridad de la sesión, canal, HEAD/ramas, Work Item y scopes realmente disponibles. **Aún no hay Work Item ni receptor verificados por este documento.**
2. **Reconstruir el estado técnico:** comprobar compilación base y CI; determinar lo conservable, dependencias, limitaciones y plan mínimo de integración.
3. **Planificar y gobernar:** traducir las cinco actividades en Work Items **solo cuando tenga autorización real para crearlos y dirigirlos**; definir criterios comprobables, rutas/recursos autorizados, base SHA y evidencia. Coordinar a Delfín por el protocolo interno correcto si lo utiliza. No simular que el desarrollo ya está iniciado.
4. **Resolver ingeniería internamente:** evitar bloquear otros trabajos autorizados por una dependencia aislada; tratar seguridad, rendimiento y peso proporcionalmente a riesgos/beneficios; comprobar fuente RV1909 y derechos antes de redistribuir material.
5. **Checkpoint humano visual:** preparar **una propuesta visual consolidada**, suficiente para la decisión del Humano, y publicar su referencia/evidencia; remitir un aviso corto al Jefe/Humano solo por el canal realmente disponible. No exigir microaprobaciones.
6. **Primera APK candidata:** después de la revisión visual, completar y verificar integración, generar APK para instalación, anotar versión, commit, SHA-256, pruebas, tamaño real y pasos de instalación. **Compilación exitosa ≠ instalación probada por el Humano.**
7. **Handoffs de retorno al Jefe:** cuando correspondan por hito material o excepción, el **Supervisor** publica su registro completo en el GitHub/Work Item autorizado y emite el **aviso breve** con URL exacta, estado, actividad, HEAD/PR y acción solicitada. El Humano transporta solamente ese aviso; no atribuir recepción automática. El Supervisor no simula el papel de Implementer para este mensaje.

## 6. Estado factual al publicar

**Documentado:** intención del Humano, cinco ejes de proyecto, requisitos de primera APK, arquitectura orientativa y PNG en Drive. **No verificado/iniciado:** recepción de este handoff por Supervisor, Work Item activo, pruebas cristianas, primera APK producida, integración cristiana o instalación en el teléfono del Humano.

**Regla de salida de este documento:** publicación por el Jefe a petición del Humano = **PUBLISHED / DELIVERY PENDING**; el Humano transportará el aviso corto. La recepción, autorización de Work Items, actividad técnica, revisión e integración deben acreditarse por separado.
