package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.theme.sora

@Composable
fun BackNav( title: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.arrow_left), contentDescription = "back", modifier = Modifier.size(24.dp))
        }
        Text(text = title, fontSize = 16.sp, fontFamily = sora, fontWeight = FontWeight.SemiBold)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.heart), contentDescription = "heart",modifier = Modifier.size(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BackNavPreview() {
    BackNav(title="Detail")
}