package apui.leimart.cmp.utils.uiComponents

import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun LeimartBottomSheet() {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val showBottomSheet = remember { mutableStateOf(false) }
    //val scope = rememberCoroutineScope()

}
