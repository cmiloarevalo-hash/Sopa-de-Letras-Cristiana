# Biblioteca de recursos del proyecto — Google Drive y trazabilidad

**Proyecto:** Sopa de Letras Cristiana. **Decisión del Humano:** 2026-11-01. **Uso:** punto de entrada común para Jefe, Supervisor, Delfín y agentes de IA que trabajen en este repositorio, dentro de sus autorizaciones y Workflow V3.

**Regla esencial:** GitHub/`main` mantiene **objetivos, marcos, decisiones, documentación canónica y código** con historial de commits. **Google Drive** mantiene **imágenes originales, referencias visuales y archivos complementarios**, sin sustituir la autoridad de los documentos aprobados de GitHub. En caso de divergencia, no inferir que una imagen altera decisiones de producto: contrastar con el objetivo y el marco visual vigentes y elevar la discrepancia por el canal autorizado.

## Ubicaciones reales de la biblioteca

| Área | Ubicación comprobada | Uso |
|---|---|---|
| Carpeta principal | [Sopa de Letras Cristiana](https://drive.google.com/drive/folders/1iENoEGadHyTbCkZlgjK1z2jf4FMQssrK) | Contenedor de recursos |
| Imágenes | [Imágenes y referencias visuales](https://drive.google.com/drive/folders/1Z-jU3IMoVOffDqAqVaypPEyqJc59dhdr) | PNG, WEBP, recursos gráficos, versiones de diseños |
| Documentos | [Documentos del proyecto](https://drive.google.com/drive/folders/1O5kEzYPuhzXwaKcQb8iRfasUfHx2Zb44) | Materiales auxiliares, estudios y archivos de referencia |

**Verificación actualizada del 2026-11-01:** las tres carpetas existen; la carpeta de imágenes **contiene el PNG original** [aventura_biblica_moderna_aprobada.png](https://drive.google.com/file/d/1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03/view?usp=drivesdk), ID de Drive `1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03`, tipo `image/png`, 2.362.665 bytes. La carpeta de documentos permanece vacía. El PNG no está comprobado como archivo físico en GitHub. El acceso a estos enlaces depende de los permisos de Google Drive del propietario: la existencia del enlace **no implica acceso público, acceso de todos los agentes ni autorización para modificar**. No cambiar permisos de compartición sin decisión del Humano.

## Convención de nombres versionados (archivos alojados en Drive)

Patrón recomendado para archivos nuevos o transferidos:

`slc_<tipo>_<descripcion_corta>_vNNN_AAAA-MM-DD.<extension>`

- `slc`: identificador del proyecto Sopa de Letras Cristiana.
- `tipo`: `visual`, `ilustracion`, `icono`, `documento`, `investigacion` o un tipo descriptivo simple.
- `descripcion_corta`: minúsculas sin espacios ni tildes, palabras separadas por guion bajo, tema reconocible.
- `vNNN`: versión de **tres dígitos** (`v001`, `v002`, ...). Nueva revisión material o imagen distinta = nuevo archivo versionado, **sin sobrescribir el anterior**.
- `AAAA-MM-DD`: fecha de creación/aprobación de la versión, según quede documentado; no inventarla.
- Mantener la extensión y formato originales, especialmente para imágenes y material técnico.

**Alias versionado de catálogo de la imagen conceptual ya aprobada (el nombre real en Drive sigue siendo `aventura_biblica_moderna_aprobada.png`):**
`slc_visual_aventura_biblica_moderna_v001_2026-11-01.png`.
Se refiere al PNG de **1536 × 1024** producido y aprobado en el chat, cuyo nombre local original era `aventura_biblica_moderna_aprobada.png`. No se ha renombrado ni duplicado el archivo real: `v001` es la **versión lógica** que corresponde a este ID único de Drive. Reutilizar esa referencia en documentos y agentes.

Ejemplos de revisiones hipotéticas (no existen): `slc_ilustracion_mundo_03_diluvio_v001_2026-11-01.png`; `slc_visual_aventura_biblica_moderna_v002_AAAA-MM-DD.png` (fecha real al crearla). Una corrección de nombre sin alterar contenido debe registrarse como **renombre**, no como nuevo diseño aprobado.

**Excepción necesaria:** `README.md`, `MARCO_VISUAL.md`, `MARCO_EDITORIAL.md`, `MARCO_LITERARIO.md` y demás documentos canónicos de GitHub **conservan rutas estables**. Su control de versiones es **Git (commit SHA + historial)**, no duplicar archivos como `README_v003.md` o romper enlaces. Las exportaciones o copias a Drive sí se nombran con versión identificable y referencia al commit de origen.

## Registro mínimo de cada recurso

Para cada recurso real, mantener una entrada **en este mismo archivo** que indique:

`ID lógico | archivo versionado | tipo/propósito | ubicación Drive: URL o ID verificado | versión | estado | origen/licencia | vínculo con marco/decisión | fecha de verificación | huella SHA-256 si disponible`.

Estados: **PENDIENTE DE CARGA**, **SUBIDO / NO VERIFICADO**, **VERIFICADO** (existencia, formato e identidad), **APROBADO POR EL HUMANO** (uso previsto), **SUSTITUIDO** (retener historial). La aprobación de una **imagen conceptual** no equivale a aprobación de su incorporación en el APK ni a pruebas de pantalla.

| ID | Archivo lógico / nombre previsto | Ubicación | Estado factual y autoridad | Relación |
|---|---|---|---|---|
| `SLC-VIS-001` | **Real:** `aventura_biblica_moderna_aprobada.png`; alias `slc_visual_aventura_biblica_moderna_v001_2026-11-01.png` | [Drive: archivo original](https://drive.google.com/file/d/1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03/view?usp=drivesdk) — ID `1UoKEDuhx5SPDALaVMUQs66sxoMmz9z03` | **Aprobado por el Humano, presente y verificado por metadatos en Drive** (2.362.665 bytes, PNG, v001, 2026-11-01); privado; no se comprobó igualdad SHA-256 contra Drive | [Marco visual](MARCO_VISUAL.md), [Referencias visuales](REFERENCIAS_VISUALES.md) |
| `SLC-DOC-001` | Marcos y objetivos canónicos (archivos Markdown de GitHub) | Repositorio `main` | **VERSIONADOS EN GIT**; no se han cargado copias a Drive | [Objetivo](OBJETIVO_PRODUCTO_CRISTIANO.md) |

Una vez que un archivo esté realmente subido: **leer la carpeta, obtener su ID y enlace de Drive, verificar nombre, tamaño/formato, registrar el estado y enlazarlo desde el marco correspondiente**. Si la subida fue con nombre anterior, registrar equivalencia sin inventar un nuevo recurso. No afirmar «guardado» o «compartido» hasta observar la evidencia correspondiente. No crear duplicaciones ni sobrescribir versiones sin motivo.

## Consulta obligada en cada tarea relacionada con recursos (orientación para agentes)

1. Leer [README](../README.md), [objetivos](OBJETIVO_PRODUCTO_CRISTIANO.md) y el marco pertinente **desde GitHub vigente**.
2. Consultar este registro para localizar la **versión exacta**, ID, estado y procedencia del recurso; no depender de la memoria de un chat ni de un nombre aproximado.
3. Consultar Drive **solo si la conexión y los permisos del agente lo permiten**. Si no puede acceder, informar ese límite y facilitar el enlace al Humano/Supervisor; nunca suponer que todos los agentes ven sus archivos.
4. Antes de producir una variante, conservar referencia del original, documentar propósito y relación con la versión previa. Proponer sin sustituir una referencia aprobada hasta autorización del Humano.
5. No replicar código, herramientas de Workflow o fuente normativa a Drive por preferencia. No crear inventarios paralelos, automatizaciones ni trabajo continuo: aplicar las reglas de Workflow V3 y las autorizaciones del Humano.

**Estado comprobado:** el Humano subió el PNG a Drive y su presencia fue verificada mediante listado y metadatos; esta actualización **no sube ni altera el binario o sus permisos**. La imagen no fue añadida como blob a GitHub.