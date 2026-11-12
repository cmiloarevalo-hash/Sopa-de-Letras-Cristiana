package app.sopadeletras.data

/** Ordered one-to-one with the ten worlds of core.Campaign. */
val CAMPAIGN_BANK_IDS = listOf(
    "creacion",
    "origenes",
    "diluvio",
    "patriarcas",
    "exodo",
    "infancia",
    "ensenanzas",
    "amigos",
    "resurreccion",
    "comunidad",
)

const val APP_LANGUAGE = "es-ES"

/** Editorial references, not literal Scripture quotations. */
data class WorldGuide(val name: String, val reference: String, val introduction: String)

val CAMPAIGN_GUIDES = listOf(
    WorldGuide("La creación y la vida", "Génesis 1:1–2:3", "Descubre la luz, la tierra y la vida. Podemos aprender a cuidar la naturaleza."),
    WorldGuide("Las primeras familias", "Génesis 2:4–5:32", "Las primeras familias nos invitan a pensar en el respeto y nuestras decisiones."),
    WorldGuide("Noé y la esperanza", "Génesis 6:9–9:17", "Con Noé, conoce el arca, el pacto y la esperanza de un nuevo comienzo."),
    WorldGuide("Abraham y las promesas", "Génesis 12:1–50:26", "Abraham, Sara, Isaac, Jacob y José nos hablan de confianza y reconciliación."),
    WorldGuide("Moisés, libertad y justicia", "Éxodo 1–20; 1 Samuel 16; Isaías 6", "El camino de Moisés nos invita a valorar la libertad, la ayuda y la justicia."),
    WorldGuide("Jesús y su familia", "Lucas 1:26–2:52; Mateo 1–2", "Conoce los relatos de los Evangelios sobre la familia y la infancia de Jesús."),
    WorldGuide("Jesús nos enseña a amar", "Mateo 5–7; Lucas 10:25–37", "Jesús enseña a amar al prójimo, perdonar y tratar a todos con paz."),
    WorldGuide("Jesús y sus amigos", "Marcos 1:16–20; Lucas 5:1–11; Juan 11", "La amistad y la escucha son valores presentes en los encuentros de Jesús."),
    WorldGuide("Jesús vive: amor y esperanza", "Lucas 22–24; Juan 19–20", "El relato de la entrega y resurrección de Jesús invita a la esperanza."),
    WorldGuide("Una comunidad que comparte", "Hechos 2:42–47; 1 Corintios 13", "Las primeras comunidades nos recuerdan el valor de compartir y ayudar."),
)

fun guideForLevel(level: Int): WorldGuide {
    require(level in 1..300)
    return CAMPAIGN_GUIDES[(level - 1) / 30]
}
