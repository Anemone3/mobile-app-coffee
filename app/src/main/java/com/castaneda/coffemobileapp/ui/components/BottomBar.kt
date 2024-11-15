package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.utils.ROUTES


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

data class BottomNavigationItem(
    val icon: Int,
    val route: String
)

@Composable
fun BottomBar(modifier: Modifier = Modifier, navController: NavController) {
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),
        containerColor = Color.White,
    ) {
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
                    Box(
                        modifier = Modifier
                            .width(10.dp)
                            .height(5.dp)
                            .background(
                                color = primary,
                                shape = RoundedCornerShape(18.dp)
                            )
                    )
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