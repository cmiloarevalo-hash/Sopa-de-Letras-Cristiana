# Sopa de letras -Biblia Rv-1909 · Proyecto iOS

**Estado real:** código fuente de la adaptación inicial a iPhone. **Todavía no existe una IPA compilada, firmada y probada en un iPhone.** La APK Android no puede convertirse cambiando la extensión.

## Contenido reutilizado

Este proyecto SwiftUI comparte los datos originales de Android: 300 niveles y diez mundos, treinta configuraciones de palabra misteriosa para 6×6, 8×8 y 10×10, referencias bíblicas por palabra y la Biblia Reina-Valera 1909 con sus 66 libros para leer sin conexión. Reutiliza los mismos JSON desde app/src/main/assets al generar el proyecto Xcode. La versión iOS tiene lectura de pasajes pulsando la referencia, juego con arrastre sobre la cuadrícula, color de las palabras encontradas y progreso local sin cuenta.

La interfaz se ha reimplementado en SwiftUI, no se ha ejecutado la APK de Android en iPhone. Este primer port aún requiere comprobación de equivalencia del generador en los 300 niveles, de temporizador, acceso físico y revisión visual. No está publicada ni instala Google.

## Cómo abrir el proyecto en un Mac

Se requiere un Mac con Xcode y la herramienta gratuita XcodeGen. En una terminal del Mac, ejecuta:

    git clone https://github.com/cmiloarevalo-hash/Sopa-de-Letras-Cristiana.git
    cd Sopa-de-Letras-Cristiana
    git checkout supervisor/ios-swiftui-port-20261116
    brew install xcodegen
    cd ios
    bash bootstrap.sh
    open SopaBibliaIOS.xcodeproj

En Xcode, selecciona SopaBibliaIOS → Signing & Capabilities → Automatically manage signing → Team (tu cuenta Apple). Conecta el iPhone y pulsa Run. El proyecto requiere iOS 16 o posterior.

Para compilar solo en el simulador, sin firmar:

    xcodebuild -project SopaBibliaIOS.xcodeproj -scheme SopaBibliaIOS -sdk iphonesimulator -destination 'generic/platform=iOS Simulator' CODE_SIGNING_ALLOWED=NO build

## Firma e instalación

El archivo .ipa válido depende de una aplicación compilada para iOS y de un perfil y firma Apple compatibles con el teléfono. Con una cuenta Apple personal es posible instalar desde Xcode en tu propio dispositivo, con limitaciones de duración; para distribuir por TestFlight/App Store se necesita Apple Developer Program. No solicitar contraseñas ni certificados mediante este repositorio.

**No llamar instalable a la carpeta de código fuente ni al resultado del simulador.** Una IPA firmada y probada en el dispositivo es una etapa separada.

## Identidad y reglas

- Nombre: Sopa de letras -Biblia Rv-1909.
- Desarrollador: Camilo Arévalo.
- Correo: apkcristiana@gmail.com.
- Aplicación relacionada: Guía pastoral - Biblia (sin enlace inventado).
- Sin anuncios, cuentas obligatorias, permisos extra ni sobrediseño.
- La Biblia RV1909 está identificada en los recursos originales como de dominio público.

## Pendientes antes de presentar una IPA

1. Ejecutar el flujo de macOS y resolver cualquier fallo real de Swift/Xcode.
2. Verificar los 300 tableros y las treinta variantes de misterio, sin palabras imposibles.
3. Probar interacción táctil, pistas, colores, persistencia y lectura del versículo correcto en un iPhone.
4. Compilar, firmar y distribuir con el método Apple autorizado para el dispositivo; comprobar instalación.

**Rama de trabajo:** supervisor/ios-swiftui-port-20261116. El APK Android 1.0.10 continúa siendo la última versión Android de prueba; no es compatible con iOS.
