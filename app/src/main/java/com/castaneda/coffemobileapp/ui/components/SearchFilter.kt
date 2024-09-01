package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.textgray

@Composable
fun SearchFilter() {
    Row(modifier = Modifier.padding(vertical = 24.dp), verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        //Buscador
        Search()
        //Botón de filtrado
        FilterButton()
    }
}

@Composable
private fun Search() {
    var textState by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.size(width = 259.dp, height = 52.dp),
        value = textState,
        onValueChange = {
            textState = it
        },
        shape = RoundedCornerShape(12.dp),
        placeholder = {
            Row(horizontalArrangement = Arrangement.spacedBy(9.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search coffe",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
                Text(
                    text = "Search Coffe",
                    fontFamily = sora,
                    fontSize = 14.sp,
                    color = textgray
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF2A2A2A),
            unfocusedContainerColor = Color(0xFF2A2A2A),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
//            errorIndicatorColor = Color.Transparent,
//            cursorColor = Color.White
        )
    )

}


@Composable
private fun FilterButton() {
    Box(
        modifier = Modifier
            .size(52.dp)
            .background(
                primary, RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "Filter",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun oreview() {
    SearchFilter()
}