package com.castaneda.coffemobileapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.components.BackNav
import com.castaneda.coffemobileapp.ui.components.ChooseSize
import com.castaneda.coffemobileapp.ui.components.DetailProduct
import com.castaneda.coffemobileapp.ui.components.DividerComponent
import com.castaneda.coffemobileapp.ui.components.ExpandableText
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.text_title
import com.castaneda.coffemobileapp.ui.theme.textgray
import com.castaneda.coffemobileapp.ui.viewmodels.ProductsViewModel
import com.castaneda.coffemobileapp.utils.Resource

@Composable
fun DetailScreen(navController: NavController, idProduct: Int, viewModel: ProductsViewModel = hiltViewModel()) {

    val productDetail by viewModel.stateProductDetail.collectAsState()
    
    LaunchedEffect(idProduct) {
        viewModel.getProductById(idProduct)
        Log.d("DetailProduct",productDetail.data.toString())
    }
    Log.d("DetailProduct2",productDetail.data.toString())

    when(productDetail){
        is Resource.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                CircularProgressIndicator()
            }
        }
        is Resource.Success -> {
            DetailProduct(navController = navController, product = productDetail.data!!)
        }

        is Resource.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = productDetail.message ?: "An error occurred",
                        color = Color.Red
                    )
                    Button(onClick = { navController.popBackStack() }) {
                        Text("Go Back")
                    }
                }
            }
        }
    }


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DetailScreenPreview() {
    DetailScreen(navController = rememberNavController(), idProduct = 1)
}