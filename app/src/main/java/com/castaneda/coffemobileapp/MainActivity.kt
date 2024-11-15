package com.castaneda.coffemobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.castaneda.coffemobileapp.utils.ROUTES
import com.castaneda.coffemobileapp.ui.screens.DeliveryScreen
import com.castaneda.coffemobileapp.ui.screens.DetailScreen
import com.castaneda.coffemobileapp.ui.screens.HomeScreen
import com.castaneda.coffemobileapp.ui.screens.OnBoardingScreen
import com.castaneda.coffemobileapp.ui.screens.OrderScreen
import com.castaneda.coffemobileapp.ui.theme.CoffeMobileAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            CoffeMobileAppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    NavHost(navController = navController, startDestination = ROUTES.ONBOARDING) {
                        composable(route = ROUTES.ONBOARDING){
                            OnBoardingScreen(navController)
                        }
                        composable(route = ROUTES.HOME){
                            HomeScreen(navController)
                        }
                        composable(
                            route = ROUTES.DETAIL,
                            arguments = listOf(navArgument("productId"){type= NavType.IntType})
                        ){navBackEntry ->
                            val idProduct = navBackEntry.arguments?.getInt("productId") ?: -1
                            DetailScreen(navController, idProduct)
                        }
                        composable(route = ROUTES.DELIVERY){
                            DeliveryScreen()
                        }
                        composable(route = ROUTES.ORDER) {
                            OrderScreen()
                        }
                    }
                }
            }
        }
    }
}

