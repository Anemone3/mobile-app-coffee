package com.castaneda.coffemobileapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.components.CoffeeCartItem
import com.castaneda.coffemobileapp.ui.components.DividerComponent
import com.castaneda.coffemobileapp.ui.theme.bg_black
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.textgray

@Composable
fun OrderScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(top = 16.dp)){
            Header()


            //Deliver - Pick up
            Deliver(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp, top = 24.dp)
                .background(color = Color(0xFFEDEDED), shape = RoundedCornerShape(12.dp)))

            Text(text = "Delivery Address", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, fontFamily = sora)
            Column(verticalArrangement = Arrangement.spacedBy(4.dp),modifier = Modifier.padding(vertical = 16.dp)) {
                Text(text = "JL.Kpg Sutoyo", fontWeight = FontWeight.SemiBold, fontSize = 14.sp,fontFamily = sora)
                Text(
                    text = "Kpg Sutoyo No.620,Bilzen,Tanjungbalai.",
                    fontWeight = FontWeight.Normal,
                    fontFamily = sora,
                    fontSize = 12.sp,
                    color = textgray
                )
            }
            //Edit Address/Note
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                ButtonAddress(width = 120.dp, image = painterResource(id = R.drawable.edit_square), text = "Edit Address") {
                    /*TODO*/
                }
                ButtonAddress(width = 101.dp, image = painterResource(id = R.drawable.note), text = "Add Note"){
                    /*TODO*/
                }

            }
            DividerComponent(modifier = Modifier.padding(horizontal = 16.dp))

            //List products
            LazyColumn(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                items(1){
                    CoffeeCartItem(
                        title = "Caffee Mocha",
                        category = "Deep Foam",
                        cantidad = 1,
                        image = painterResource(id = R.drawable.coffe_detail),
                        onMinusClick = { /*TODO*/ },
                        onPlusClick = { /*TODO*/ }
                    )
                }
            }
        } //End column
        HorizontalDivider(color = Color(0xFFF9F2ED), thickness = 4.dp, modifier = Modifier.padding(vertical = 16.dp))

        // Price - etc
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)) {
            DiscountApplies(count = 1)
            //Payment Summary
            PaymentSummary(price = 4.53, deliveryFee = 1.0)
        }
    }
}

@Composable
fun PaymentSummary(
    price: Double = 0.0,
    deliveryFee: Double = 0.0
) {
    Column(modifier = Modifier.padding(vertical = 24.dp)) {
        Text(text = "Payment Summary",fontWeight = FontWeight.SemiBold, fontSize = 16.sp, fontFamily = sora, letterSpacing = 0.5.sp)
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Price",fontSize = 14.sp, fontWeight = FontWeight.Normal,fontFamily = sora, color = bg_black)
                Text(text = "$ $price",fontSize = 14.sp, fontWeight = FontWeight.SemiBold,fontFamily = sora, color = Color(0xFF242424))
            }
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Delivery Fee",fontSize = 14.sp, fontWeight = FontWeight.Normal,fontFamily = sora, color = bg_black)
                Text(text = "$ $deliveryFee", fontSize = 14.sp, fontWeight = FontWeight.SemiBold,fontFamily = sora,color = Color(0xFF242424))
            }
        }
    }
}

@Composable
 fun DiscountApplies(
    count: Int = 0
) {
    Row(
        modifier = Modifier
            .border(width = 1.dp, color = Color(0xFFEDEDED), RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .height(56.dp)
            ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.discount),
                contentDescription = "",
                modifier = Modifier.size(16.67.dp),
                tint = primary
            )
            Text(
                text = "$count  Discount is Applies",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                fontFamily = sora,
                color = bg_black
            )
        }
        Box(modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "arrow right",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}


@Composable
private fun ButtonAddress(
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
private fun Deliver(modifier: Modifier) {
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
private fun Header() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.arrow_left), contentDescription = "back", modifier = Modifier.size(24.dp))
        }
        Text(text = "Order", fontSize = 16.sp, fontFamily = sora, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.padding(horizontal = 24.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OrderScreenPreview() {
    OrderScreen()
}