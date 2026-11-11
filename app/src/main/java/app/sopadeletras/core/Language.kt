package app.sopadeletras.core

object Language {
    const val PT_CODE = "pt-PT"
    const val EN_CODE = "en-US"
    const val ES_CODE = "es-ES"
    const val PT_FILL = "AAAEEEIIOOOSSRRMNDTLCPUBG"
    const val EN_FILL = "EEEEAAARRIIOOTTNNSSLLCUDPMHGBF"
    const val ES_FILL = "AAAEEEIIOOOSSNNRRLLTTCCDDMPUÑBG"

    fun fillFor(code: String): String = when (code) {
        EN_CODE -> EN_FILL
        ES_CODE -> ES_FILL
        else -> PT_FILL
    }
}
