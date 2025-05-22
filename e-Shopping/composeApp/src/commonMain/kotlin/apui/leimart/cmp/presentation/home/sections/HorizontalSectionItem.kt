package apui.leimart.cmp.presentation.home.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.presentation.theme.appColor.leimartBlue
import apui.leimart.cmp.presentation.theme.appColor.leimartGreen
import apui.leimart.cmp.presentation.theme.appColor.primary
import apui.leimart.cmp.presentation.theme.appColor.secondary
import coil3.compose.AsyncImage
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.plus
import org.jetbrains.compose.resources.painterResource

@Composable
fun HorizontalItem(sectionItem: Section) {
    Column(modifier = Modifier.padding(end = 10.dp)) {
        Box(modifier = Modifier.clip(RoundedCornerShape(10.dp)).height(150.dp).width(200.dp)) {
            AsyncImage(
                model = Res.getUri(sectionItem.imageUrl),
                contentDescription = "Item",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.align(Alignment.Center).matchParentSize()//.padding(10.dp)
            )
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .size(35.dp)
                    .clip(CircleShape)
                    .background(color = Color.White)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.plus), contentDescription = "Add Button",
                    modifier = Modifier.align(Alignment.Center).size(18.dp),
                    tint = secondary
                )
            }
        }
    }
}