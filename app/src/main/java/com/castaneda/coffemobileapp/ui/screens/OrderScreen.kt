package com.castaneda.coffemobileapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.theme.bg_black
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.textgray

@Composable
fun OrderScreen() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp, vertical = 20.dp)){
        Header(text = "Order")

        Spacer(modifier = Modifier.padding(vertical = 19.dp))
        //Deliver - Pick up
        Deliver(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFEDEDED), shape = RoundedCornerShape(12.dp)))


            Text(text = "Delivery Address")
            Text(text = "JL.Kpg Sutoyo")
            Text(text = "Kpg Sutoyo No.620,Bilzen,Tanjungbalai.")

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                ButtonAddress(width = 120.dp, image = painterResource(id = R.drawable.edit_square), text = "Edit Address") {
                    /*TODO*/
                }
                ButtonAddress(width = 101.dp, image = painterResource(id = R.drawable.note), text = "Add Note"){
                    /*TODO*/
                }

            }

    }
}


@Composable
fun ButtonAddress(
    modifier: Modifier = Modifier,
    width: Dp,
    image: Painter,
    text: String,
    onClick: () -> Unit,
) {
    Button(onClick = onClick,modifier = Modifier
        .width(width)
        .height(26.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(contentColor = bg_black, containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, color = textgray)
        ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(4.dp,Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = image,
                contentDescription = "edit addreess note",
                modifier = Modifier.size(14.dp)
            )
            Text(text = text, fontSize = 12.sp, fontWeight = FontWeight.Normal, fontFamily = sora)

        }
    }
}

@Composable
fun Deliver(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .size(width = 153.dp, height = 35.dp)
                    .background(color = primary, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Deliver", fontSize = 16.sp, fontFamily = sora, fontWeight = FontWeight.SemiBold, color = Color.White)
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = "Pick up", fontSize = 16.sp, fontFamily = sora, fontWeight = FontWeight.SemiBold, color = Color.Black, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun Header(text: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.arrow_left), contentDescription = "back", modifier = Modifier.size(24.dp))
        }
        Text(text = text, fontSize = 16.sp, fontFamily = sora, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OrderScreenPreview() {
    OrderScreen()
}