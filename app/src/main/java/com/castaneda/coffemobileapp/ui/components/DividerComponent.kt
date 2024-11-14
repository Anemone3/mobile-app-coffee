package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DividerComponent(modifier: Modifier = Modifier) {
    HorizontalDivider(color = Color(0xFFE3E3E3), thickness = 1.dp, modifier = modifier.padding(vertical = 16.dp))
}