package app.sopadeletras.ui.bible

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.sopadeletras.data.BibleRepository
import app.sopadeletras.ui.theme.Bricolage
import app.sopadeletras.ui.theme.Figtree
import app.sopadeletras.ui.theme.LocalSopaColors

@Composable
fun BibleScreen(onBack: () -> Unit, initialBook: String = "GEN", initialChapter: Int = 1, initialVerse: Int = 1) {
    val colors = LocalSopaColors.current
    val context = LocalContext.current
    val bible = remember(context) { BibleRepository(context) }
    var bookId by remember(initialBook) {
        mutableStateOf(initialBook.takeIf { wanted -> bible.books.any { it.id == wanted } } ?: "GEN")
    }
    var chapter by remember(initialChapter) {
        mutableStateOf(initialChapter.coerceIn(1, bible.books.first { it.id == bookId }.chapters))
    }
    var chooseBook by remember { mutableStateOf(false) }
    val book = bible.books.first { it.id == bookId }
    val verses = remember(bookId, chapter) { bible.verses(bookId, chapter) }
    val readerList = rememberLazyListState()
    LaunchedEffect(bookId, chapter, initialVerse) {
        val index = if (bookId == initialBook && chapter == initialChapter) {
            verses.indexOfFirst { it.number >= initialVerse }.coerceAtLeast(0)
        } else 0
        readerList.scrollToItem(index)
    }
    BackHandler(onBack = onBack)

    Column(
        Modifier.fillMaxSize().background(colors.bg)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(onClick = onBack) { Text("← Volver") }
            Spacer(Modifier.weight(1f))
            Text("BIBLIA RV1909", fontFamily = Bricolage, color = colors.text, fontWeight = FontWeight.Bold)
        }
        Text("Lee y descubre la Biblia", fontFamily = Bricolage,
            fontWeight = FontWeight.Bold, fontSize = 23.sp, color = colors.text)
        Text("Texto original de 1909: se conserva su ortografía histórica.",
            fontFamily = Figtree, fontSize = 12.sp, color = colors.mute)
        OutlinedButton(onClick = { chooseBook = true }, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = colors.text)) {
            Text("Libro: " + book.name + "  ·  Cambiar")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            OutlinedButton(onClick = { chapter-- }, enabled = chapter > 1, modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = colors.text, disabledContentColor = colors.mute)) {
                Text("Anterior")
            }
            Text(chapter.toString() + " / " + book.chapters,
                fontFamily = Bricolage, fontWeight = FontWeight.Bold, color = colors.text)
            OutlinedButton(
                onClick = { chapter++ }, enabled = chapter < book.chapters,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = colors.text, disabledContentColor = colors.mute),
            ) { Text("Siguiente") }
        }
        LazyColumn(modifier = Modifier.weight(1f), state = readerList, verticalArrangement = Arrangement.spacedBy(14.dp)) {
            items(verses, key = { it.number }) { verse ->
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(verse.number.toString(), fontFamily = Bricolage,
                        fontWeight = FontWeight.Bold, color = colors.accent)
                    Text(verse.text, fontFamily = Figtree, fontSize = 16.sp,
                        lineHeight = 24.sp, color = colors.text,
                        modifier = Modifier.weight(1f))
                }
            }
            item {
                Text("Reina-Valera 1909 · Dominio público · eBible.org",
                    fontFamily = Figtree, fontSize = 12.sp, color = colors.mute)
            }
        }
    }
    if (chooseBook) {
        AlertDialog(
            onDismissRequest = { chooseBook = false },
            title = { Text("Selecciona un libro", fontFamily = Bricolage) },
            text = {
                LazyColumn(Modifier.heightIn(max = 420.dp)) {
                    items(bible.books, key = { it.id }) { option ->
                        Text(option.name + " · " + option.chapters + " capítulos",
                            fontFamily = Figtree, fontSize = 16.sp, color = colors.text,
                            modifier = Modifier.fillMaxWidth()
                                .clickable {
                                    bookId = option.id
                                    chapter = 1
                                    chooseBook = false
                                }.padding(vertical = 10.dp, horizontal = 4.dp))
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { chooseBook = false }) { Text("Cerrar") }
            },
            containerColor = colors.surface,
        )
    }
}

