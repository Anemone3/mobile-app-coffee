package com.castaneda.coffemobileapp.data.model

data class Product(
    val category: Category,
    val descripcion: String,
    val id: Int,
    val image_url: String,
    val ingredientes: String,
    val price: String,
    val titulo: String
)