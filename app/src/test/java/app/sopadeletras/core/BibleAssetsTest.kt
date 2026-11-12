package app.sopadeletras.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class BibleAssetsTest {
    private val bible = File("src/main/assets/bible/rv1909")

    @Test fun includesAll66BibleBooksWithPublicDomainAttribution() {
        assertTrue("Missing RV1909 Bible index", File(bible, "index.json").isFile)
        assertEquals(66, bible.listFiles { file -> file.name.endsWith(".json") && file.name != "index.json" }?.size)
        val index = File(bible, "index.json").readText(Charsets.UTF_8)
        assertEquals(66, Regex("\"chapterCount\"").findAll(index).count())
        assertTrue(index.contains("ebible.org"))
        assertTrue(index.contains("Dominio público"))
    }

    @Test fun genesisAndJesusAccountsExistUnmodified() {
        val genesis = File(bible, "GEN.json").readText(Charsets.UTF_8)
        val luke = File(bible, "LUK.json").readText(Charsets.UTF_8)
        assertTrue(genesis.contains("EN el principio"))
        assertTrue(luke.contains("Bethlehem"))
        assertTrue(luke.contains("Jerusalem") || luke.contains("Jerusalén"))
    }

    @Test fun exactAppNameAnd300BiblicalHintsArePackaged() {
        val xml = File("src/main/res/values/strings.xml").readText(Charsets.UTF_8)
        assertTrue(xml.contains("Sopa de letras -Biblia Rv-1909"))
        val levels = File("src/main/assets/campaign/es-ES/levels-v1.json").readText(Charsets.UTF_8)
        assertEquals(300, Regex("\"bibleHint\"").findAll(levels).count())
        assertEquals(20, Regex("\"mystery\"\\s*:\\s*\\{").findAll(levels).count())
    }
}

