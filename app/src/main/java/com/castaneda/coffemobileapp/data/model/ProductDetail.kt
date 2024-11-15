package com.castaneda.coffemobileapp.data.model

import com.google.gson.annotations.SerializedName

data class ProductDetail(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val price: String,
    @SerializedName("image_url")
    val image: String,
    val ingredientes: String,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("name_category")
    val nameCategory: String
)
