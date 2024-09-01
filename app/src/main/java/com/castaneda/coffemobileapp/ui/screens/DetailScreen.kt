package com.castaneda.coffemobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush.Companion.horizontalGradient
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.components.BackNav
import com.castaneda.coffemobileapp.ui.components.ChooseSize
import com.castaneda.coffemobileapp.ui.components.ExpandableText
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.text_title
import com.castaneda.coffemobileapp.ui.theme.textgray

@Composable
fun DetailScreen() {
    Scaffold(
        bottomBar = {
            //Hacer la confirmación de la compra y la muestra del precio
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(118.dp),
                contentAlignment = Alignment.Center) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment =Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)) {
                    Column(modifier = Modifier.align(Alignment.Top), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(text = "Price", fontSize = 14.sp, fontWeight = FontWeight.Normal, fontFamily = sora, color = Color(0xFF909090))
                        Text(text = "$ 4.53", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, fontFamily = sora, color = primary)
                    }
                    Button(onClick = { /*TODO*/ },modifier = Modifier
                        .width(217.dp)
                        .height(56.dp), shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = primary)) {
                        Text(text = "Buy Now")
                    }
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(modifier = Modifier.padding(24.dp)) {
                BackNav(title = "Detail")
                Box(
                    modifier = Modifier

                        .padding(vertical = 16.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.coffe_detail),
                        contentDescription = "Detail product",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(202.dp),
                        contentScale = ContentScale.FillWidth
                    )
                }
                TitleRating(title = "Cappuccino", rating = "4.5")
                HorizontalDivider(color = Color(0xFFE3E3E3), thickness = 1.dp, modifier = Modifier.padding(vertical = 16.dp))
                DescriptionCoffe()
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                DetailContent()
                ChooseSize()
            }
        }
    }

}

@Composable
fun DetailContent(){
    var isExpanded by remember {
        mutableStateOf(false)
    }
    ExpandableText(
        text = "A cappuccino is an approximately 150 ml (5 oz) beverage, with 25 ml of espresso coffee and 85ml of fresh milk the fo..is an approximately 150 ml (5 oz) beverage, with 25 ml of espresso coffee and 85ml of fresh milk",
        fontSize = 14.sp,
        onTextExpanded = { isExpanded = true },
        onTextCollapsed = { isExpanded = false }
    )
    Spacer(modifier = Modifier.padding(vertical = if (isExpanded) 10.dp else 24.dp))
}

@Composable 
fun DescriptionCoffe() {
    Text(
        text = "Description",
        color = text_title,
        fontFamily = sora,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
}

@Composable
fun TitleRating(title: String, rating: String) {
    Column(modifier = Modifier
        .fillMaxWidth()) {
        Text(text = title, color = text_title, fontFamily = sora, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, textAlign = TextAlign.End)
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Ice/Hot",
                color = textgray,
                fontFamily = sora,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(156.dp)) {
                OptionsButtons(R.drawable.bike, size = 32)
                OptionsButtons(R.drawable.bean, size = 24)
                OptionsButtons(R.drawable.milk,size = 24)
            }
        }
        StarRatingC(rating= "4.8", review = "200")
    }
}

@Composable
fun StarRatingC(rating: String, review: String) {
    Row( verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {

        Icon(
            painter = painterResource(id = R.drawable.star),
            contentDescription = "Star",
            tint = Color(0xFFFBBE21),
            modifier = Modifier.size(20.dp)
        )
        Text(text = rating,
            color = Color(0xFF2A2A2A),
            fontFamily = sora,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp)
        Text(text = "(${review})", color = textgray, fontFamily = sora, fontWeight = FontWeight.Normal, fontSize = 12.sp)
    }
}

@Composable
fun OptionsButtons(image: Int, size: Int) {
    Box(modifier = Modifier
        .size(44.dp)
        .background(
            brush = linearGradient(
                colors = listOf(
                    Color(0xFFEDEDED).copy(alpha = 0.35f),  // Color con 35% de opacidad
                    Color.Transparent
                )

            ), shape = RoundedCornerShape(12.dp)
        ), contentAlignment = Alignment.Center) {
        Icon(painter = painterResource(image), contentDescription = "delivery buttons", modifier = Modifier.size(size.dp), tint = primary)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DetailScreenPreview() {
    DetailScreen()
}