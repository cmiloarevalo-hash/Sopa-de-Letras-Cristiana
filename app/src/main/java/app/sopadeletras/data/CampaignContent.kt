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
    WorldGuide("La Creación", "Génesis 1:1–2:3", "Jesús nos invita a descubrir el relato bíblico de la creación."),
    WorldGuide("Los primeros tiempos", "Génesis 2:4–5:32", "Conocemos a las primeras familias en los relatos de Génesis."),
    WorldGuide("Noé y el Diluvio", "Génesis 6:9–9:17", "Exploramos el arca de Noé, el diluvio y la señal del pacto."),
    WorldGuide("Patriarcas y promesas", "Génesis 12:1–50:26", "Aprendemos sobre Abraham, Sara, Isaac, Jacob y José."),
    WorldGuide("Moisés, reyes y profetas", "Éxodo 1–20; 1 Samuel 16; Isaías 6", "Seguimos el éxodo y conocemos a líderes y profetas bíblicos."),
    WorldGuide("Jesús, su infancia y familia", "Lucas 1:26–2:52; Mateo 1–2", "Leemos lo que los evangelios sí cuentan de la infancia de Jesús."),
    WorldGuide("Jesús crece y enseña", "Mateo 5–7; Lucas 10:25–37", "Descubrimos las enseñanzas de Jesús sobre el amor y el Padre."),
    WorldGuide("Jesús, sus amigos y apóstoles", "Marcos 1:16–20; Lucas 5:1–11; Juan 11", "Conocemos a personas que acompañaron a Jesús."),
    WorldGuide("Redención, resurrección y salvación", "Lucas 22–24; Juan 19–20", "Aprendemos sobre la entrega, la resurrección y la esperanza."),
    WorldGuide("Comunidad y valores cristianos", "Hechos 2:42–47; 1 Corintios 13", "Compartimos la alegría de cuidar, servir y vivir en comunidad."),
)

fun guideForLevel(level: Int): WorldGuide {
    require(level in 1..300)
    return CAMPAIGN_GUIDES[(level - 1) / 30]
}
