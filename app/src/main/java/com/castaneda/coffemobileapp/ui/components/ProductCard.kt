package com.castaneda.coffemobileapp.ui.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.castaneda.coffemobileapp.R
import com.castaneda.coffemobileapp.data.model.Category
import com.castaneda.coffemobileapp.data.model.Product
import com.castaneda.coffemobileapp.ui.theme.background
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.text_title
import com.castaneda.coffemobileapp.ui.theme.textgray



@Composable
fun ProductCard(modifier: Modifier = Modifier, product: Product) {
    Card(
        modifier = Modifier
            .size(width = 156.dp, height = 238.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Imagen del producto
            AsyncImage(
                model =  product.image_url,
                contentDescription = product.titulo,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
            )

            // Título y categoría
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = product.titulo,
                    fontSize = 16.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold,
                    color = text_title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.category.name_category,
                    color = textgray,
                    fontSize = 12.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Precio y botón
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Precio a la izquierda y botón a la derecha
            ) {
                Text(
                    text = "$ ${product.price}",
                    fontSize = 18.sp,
                    fontFamily = sora,
                    fontWeight = FontWeight.SemiBold,
                    color = text_title
                )
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Add to cart",
                    tint = Color.Unspecified, // Mantén el color original del ícono
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            // TODO: Add product to cart
                        }
                )
            }
        }
    }
}


@Preview
@Composable
private fun ProductCardPreview() {
    ProductCard(product = Product(Category(1,"bedidas"),"xdxd",3,
       "","Limón, agua, azúcar","7.00","Limonada C / Hierba Buena"))
}