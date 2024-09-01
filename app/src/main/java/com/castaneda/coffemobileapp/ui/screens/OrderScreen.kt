package com.castaneda.coffemobileapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OrderScreen() {
    Text(text = "Order Screen")
}


@Preview(showBackground = true)
@Composable
private fun OrderScreenPreview() {
    OrderScreen()
}