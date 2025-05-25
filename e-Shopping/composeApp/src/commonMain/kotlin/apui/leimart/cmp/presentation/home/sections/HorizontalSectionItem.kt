package apui.leimart.cmp.presentation.home.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.domain.model.Section
import apui.leimart.cmp.presentation.theme.appColor.primary
import apui.leimart.cmp.presentation.theme.appColor.secondary
import apui.leimart.cmp.presentation.theme.typography.GetBodyResource
import apui.leimart.cmp.utils.uiComponents.LeimartText
import coil3.compose.AsyncImage
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.plus
import org.jetbrains.compose.resources.painterResource

@Composable
fun HorizontalItem(sectionItem: Section) {
    Surface(
        tonalElevation = 20.dp, // Standard elevation
        //shadowElevation = 8.dp, // Stronger shadow effect
        shape = MaterialTheme.shapes.medium, // Rounded corners
        color = primary.copy(alpha = 0.1f),
        modifier = Modifier.padding(end = 15.dp),
        border = _root_ide_package_.androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = secondary
        )
    ) {
        Box(
            modifier = Modifier.height(190.dp).width(210.dp)
            //.background(color = secondary.copy(alpha = 0.1f))
        ) {
            AsyncImage(
                model = Res.getUri(sectionItem.imageUrl),
                contentDescription = "Item",
                //contentScale = ContentScale.FillBounds,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp).fillMaxWidth()
                    .height(110.dp).clip(
                        RoundedCornerShape(10.dp)
                    ).align(Alignment.TopCenter)
            )
            Column(
                modifier = Modifier.align(alignment = Alignment.BottomStart)
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                LeimartText(sectionItem.itemName, fontResource = GetBodyResource.italic)
                LeimartText(sectionItem.itemPrice, fontResource = GetBodyResource.extraBoldInter)
            }

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