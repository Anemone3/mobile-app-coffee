package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.surface

@Composable
fun ChooseSize() {

                                                            //Luego lo regreso en null
    var selectedSize by rememberSaveable { mutableStateOf<Char?>('M') } // Estado para el tamaño seleccionado


    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Size", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, fontFamily = sora)
        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
            SizeButton(size = 'S', isSelected = selectedSize == 'S') { selectedSize = 'S' }
            SizeButton(size = 'M', isSelected = selectedSize == 'M') { selectedSize = 'M' }
            SizeButton(size = 'L', isSelected = selectedSize == 'L') { selectedSize = 'L' }
        }
    }
}


@Composable
fun SizeButton(size: Char, isSelected: Boolean, onSelect: () -> Unit) {
    val buttonColor = if (isSelected) primary.copy(0.1f) else Color.White
    val borderColor = if (isSelected) Color(0xFFC67C4E) else surface
    Button(onClick = { onSelect() }, // Llama a la función lambda para actualizar el estado
        modifier = Modifier
            .width(96.dp)
            .height(41.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = Color.Black
        ),
        border = BorderStroke(1.dp, color = borderColor),
        shape =RoundedCornerShape(12.dp)
    ) {
        Text(text = "$size", color = if(isSelected) primary else Color.Black)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ChooseSizePreview() {
    ChooseSize()
}