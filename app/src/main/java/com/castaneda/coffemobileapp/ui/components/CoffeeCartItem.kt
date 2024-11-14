package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.text_title
import com.castaneda.coffemobileapp.ui.theme.textgray

@Composable
fun CoffeeCartItem(
    modifier: Modifier = Modifier,
    title: String,
    cantidad: Int,
    category: String,
    image: Painter,
    onMinusClick: () -> Unit = {},
    onPlusClick: () -> Unit = {}
) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Box(modifier = Modifier
                .size(54.dp)
                .clip(RoundedCornerShape(8.dp))) {
                Image(painter = image, contentDescription = "", contentScale = ContentScale.Crop)
            }
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, fontFamily = sora, color = text_title)
                Text(text = category, color = textgray, fontSize = 12.sp, fontFamily = sora, fontWeight = FontWeight.Normal)
            }

        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(18.dp)) {
            Image(
                painter = painterResource(id = R.drawable.minuscircle),
                contentDescription = "minus icon",
                modifier = Modifier
                    .size(24.dp)
                    .clickable{
                        onMinusClick()
                    }
            )
            Text(text = cantidad.toString(), fontWeight = FontWeight.SemiBold, fontSize = 14.sp, fontFamily = sora)
            Image(
                painter = painterResource(id = R.drawable.pluscircle),
                contentDescription = "plus icon",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onPlusClick()
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CoffeeCartItemPreview() {
    CoffeeCartItem(title = "Caffee Mocha", category = "Deep Foam", cantidad = 1, image = painterResource(id = R.drawable.coffe_detail))
}