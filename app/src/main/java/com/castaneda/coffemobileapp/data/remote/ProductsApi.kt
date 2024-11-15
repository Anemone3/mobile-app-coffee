package com.castaneda.coffemobileapp.data.remote

import com.castaneda.coffemobileapp.data.model.ProductDetail
import com.castaneda.coffemobileapp.data.model.ResponseProducts
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi {


    @GET("products")
    suspend fun getProducts(): ResponseProducts

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): ProductDetail

}