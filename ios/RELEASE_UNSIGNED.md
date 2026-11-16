# iPhone — paquete iOS sin firma (para instalar con AltServer)

**IMPORTANTE: NO ES UNA IPA DE INSTALACIÓN DIRECTA.** Es una compilación real para procesador iPhone (SDK iphoneos/arm64), sin firma de Apple. iOS no permite abrirla desde Safari y pulsar «Instalar». El paquete necesita que AltServer o Xcode lo firme con tu propia cuenta Apple y lo instale en tu dispositivo.

Versión experimental inicial de Sopa de letras -Biblia Rv-1909.
Origen: código SwiftUI del port iOS y catálogo editorial Android de 300 niveles, 30 misterios y biblioteca RV1909 de 66 libros.

**Para instalar desde Windows, sin Mac:**
1. En el PC instala AltServer para Windows desde el sitio oficial de AltStore y sus requisitos de Apple.
2. Conecta el iPhone con un cable, desbloquéalo y confía en el equipo.
3. En AltServer mantén **Mayús (Shift)** al hacer clic en su icono para elegir la opción «Sideload .ipa...».
4. Selecciona el archivo SopaBibliaIOS-v0.1-UNSIGNED.ipa que descargaste.
5. AltServer solicita autenticación Apple **en tu equipo**, firma la app e instala en tu dispositivo; no compartas tus credenciales en ChatGPT.
6. En el iPhone, sigue la indicación de confiar en la app y habilita el modo desarrollador si se solicita. Las instalaciones con cuenta Apple gratuita se renuevan periódicamente (habitualmente cada siete días).

Instrucciones oficiales AltStore Windows:
https://faq.altstore.io/altstore-classic/how-to-install-altstore-windows
https://faq.altstore.io/release-notes/altserver

**Estado de calidad:** el código iOS compiló primero en simulador Xcode16.4; la construcción iphoneos se verifica en CI. No se ha probado el paquete firmado en un iPhone físico, ni se ha comprobado la paridad de todos los niveles frente a Android. No confundir con APK, app del App Store o distribución definitiva.

**Desarrollador:** Camilo Arévalo · **Contacto:** apkcristiana@gmail.com.
