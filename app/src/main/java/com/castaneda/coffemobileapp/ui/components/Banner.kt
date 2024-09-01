package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.theme.bg_black
import com.castaneda.coffemobileapp.ui.theme.sora

@Composable
fun Banner() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)
        .clip(shape = RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner promo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        DetailBox()
    }
}

@Composable
private fun DetailBox() {
    Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 13.dp)) {
        Box(modifier = Modifier
            .size(width = 60.dp, height = 26.dp)
            .background(color = Color(0xFFED5151), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Promo",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = sora,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
                )
        }
        Box(modifier = Modifier.fillMaxWidth()){
            Box(modifier = Modifier
                .padding(top = 15.dp)
                .size(width = 200.dp, height = 27.dp)
                .background(bg_black)
            )
            Text(
                text = "Buy one get",
                color = Color.White,
                fontFamily = sora,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
        Box(modifier = Modifier.fillMaxWidth()){
            Box(modifier = Modifier
                .padding(top = 15.dp)
                .size(width = 149.dp, height = 23.dp)
                .background(bg_black)
            )
            Text(
                text = "one FREE",
                color = Color.White,
                fontFamily = sora,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BannerPreview() {
    Banner()
}