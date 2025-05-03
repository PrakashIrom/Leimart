package apui.shopping.kmp.presentation.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apui.shopping.kmp.R
import apui.shopping.kmp.presentation.theme.appColor.primary
import apui.shopping.kmp.presentation.theme.font.headerFontFamily
import apui.shopping.kmp.utils.ui.LeimartText

@Composable
fun SignUpPageContent() {
    val userName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val phoneNo = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LeimartText(
            text = stringResource(R.string.sign_up),
            fontFamily = headerFontFamily,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = primary
        )
    }
}