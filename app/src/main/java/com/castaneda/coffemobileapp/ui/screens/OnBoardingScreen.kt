package com.castaneda.coffemobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.utils.ROUTES
import com.castaneda.coffemobileapp.ui.components.LargeButton
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.textgray

@Composable
fun OnBoardingScreen(navController: NavController) {


    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart){
            Image(
                painter = painterResource(id = R.drawable.coffe_bg),
                contentDescription = "coffe home",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                //Arreglar aqui el tamaño, en el celular se mira mal TODO
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(390.dp)
            .align(Alignment.BottomEnd)
            .drawBehind { // Dibuja el degradado detrás del contenido
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color(0xFF050505)),
                    startY = 60f,
                    endY = size.height * 0.29f // Ajusta la alturadel degradado
                )
                drawRect(brush = gradient)
            }
        )

            //Title
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 24.dp
                    )
                    .padding(bottom = 25.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                TitleText(title = "Fall in Love with")
                TitleText(title = " Coffee in Blissful ")
                TitleText(title = "Delight!")
                Spacer(modifier = Modifier.padding(bottom = 13.dp))
                //Desc
                DescText(desc = "Welcome to our cozy coffee corner, where")
                DescText(desc = "every cup is a delightful for you.")
                Spacer(modifier = Modifier.padding(bottom = 44.dp))
                LargeButton(text = "Get Started") {
                    navController.navigate(ROUTES.HOME)
                }
            }




    }


}


@Composable
private fun TitleText(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontFamily = sora,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        letterSpacing = 2.6.sp,
        lineHeight = 53.sp
    )
}

@Composable
private fun DescText(desc: String) {
    Text(
        text = desc,
        color = textgray,
        fontFamily = sora,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        letterSpacing = 0.6.sp
    )
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
private fun OnBoardingScreenPreview() {
    OnBoardingScreen(navController = NavController(LocalContext.current))
}