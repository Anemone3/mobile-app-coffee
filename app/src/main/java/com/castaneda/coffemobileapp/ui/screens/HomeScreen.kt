package com.castaneda.coffemobileapp.ui.screens


import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import com.castaneda.coffemobileapp.data.model.Product
import com.castaneda.coffemobileapp.utils.ROUTES
import com.castaneda.coffemobileapp.ui.components.Banner
import com.castaneda.coffemobileapp.ui.components.ProductCard
import com.castaneda.coffemobileapp.ui.components.SearchFilter
import com.castaneda.coffemobileapp.ui.theme.bg_black
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.subtitle
import com.castaneda.coffemobileapp.ui.theme.textgray
import com.castaneda.coffemobileapp.ui.viewmodels.ProductsViewModel


data class BottomNavigationItem(
    val icon: Int,
    val route: String
)


@Composable
fun HomeScreen(navController: NavController, viewModel: ProductsViewModel = hiltViewModel()) {
    val state by viewModel.stateProduct.collectAsState()
    Log.d("Cantidad.items", "${state.size}")

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {

            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                ,
                containerColor = Color.White,
            ){
                itemsList.forEachIndexed { index, bottomNavigationItem ->
                    NavigationBarItem(
                        modifier = Modifier.padding(PaddingValues(top = 40.dp)),
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(bottomNavigationItem.route)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = bottomNavigationItem.icon),
                                contentDescription = "",
                                modifier = Modifier.size(24.dp),
                                tint = when (selectedItemIndex) {
                                    index -> primary
                                    else -> Color.Gray
                                }
                            )
                        },
                        label = {
                            Box(modifier = Modifier
                                .width(10.dp)
                                .height(5.dp)
                                .background(color = primary, shape = RoundedCornerShape(18.dp)))
                        },
                        alwaysShowLabel = false,
                        enabled = true,
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) {
        HomeContent(modifier = Modifier.padding(it), state = state)
    }


}

val itemsList = listOf(
    BottomNavigationItem(
        icon = R.drawable.home,
        route = ROUTES.HOME
    ),
    BottomNavigationItem(
        icon = R.drawable.heart,
        route = ROUTES.DETAIL
    ),
    BottomNavigationItem(
        icon = R.drawable.bag,
        route = ROUTES.DELIVERY
    ),
    BottomNavigationItem(
        icon = R.drawable.notification,
        route = ROUTES.ORDER
    )
)

@Composable
private fun HomeContent(modifier: Modifier = Modifier, state: List<Product>) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            //Top Box
            Box(modifier = Modifier
                .height(236.dp + 44.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(0xFF050505)),
                        startY = 0f,
                        endY = 70f
                    )
                )) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(bg_black, Color(0xFF111111))
                            )
                        )
                        .padding(24.dp)
                ) {
                    Spacer(modifier = Modifier.padding(top = 44.dp))
                    Text(
                        text = "Location",
                        fontFamily = sora,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = textgray
                    )

                    //Dropdown - Locales
                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        TargetLocalization()
                    }

                    //Buscador y botón de filter
                    SearchFilter()
                }
            }
        }


        //Promo card
        Box(modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 176.dp + 44.dp)) {
            Banner()

        }

        //Detail Box
        DetailBox(state)
    }
}




@Composable
private fun DetailBox(state: List<Product>) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 24.dp)
        .padding(top = 340.dp + 44.dp)) {

        val category = listOf(
            "Machiato","Latte","Americano","Cappuccino"
        )
    Column {

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(bottom = 12.dp)) {
            item {
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primary,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.height(29.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    Text(text = "All Coffe", textAlign = TextAlign.Center,fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp, color = Color.White, fontFamily = sora)
                } }
            items(category.size){
                Button(
                    onClick = {
                        /*TODO*/
                    },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFEDEDED),
                        contentColor = bg_black
                    ),
                    modifier = Modifier.height(29.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    Text(text = category[it], textAlign = TextAlign.Center, fontWeight = FontWeight.Normal,
                        fontSize = 14.sp, color = bg_black, fontFamily = sora)
                }
            }
        }
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            items(state){product->
                ProductCard(product = product)
            }
        }
    }

    }
}

@Composable
private fun TargetLocalization() {
    Text(text = "Bilzen, Tanjungbalai",
        fontFamily = sora,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = subtitle)
    Icon(
        painter = painterResource(id = R.drawable.arrow_down),
        contentDescription = "arrow down",
        tint = Color.White)


}

@Preview(showBackground = true,showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}