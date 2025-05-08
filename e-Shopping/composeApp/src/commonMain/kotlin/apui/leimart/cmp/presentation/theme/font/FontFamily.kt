package apui.shopping.kmp.presentation.theme.font

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont

val headerFontName = GoogleFont("Playfair Display")
val bodyFontName = GoogleFont("Inter")

val bodyFontFamily = FontFamily(
    Font(googleFont = bodyFontName, fontProvider = provider)
)

val headerFontFamily = FontFamily(
    Font(googleFont = headerFontName, fontProvider = provider)
)