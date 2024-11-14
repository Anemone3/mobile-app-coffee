package com.castaneda.coffemobileapp.data.remote

import com.castaneda.coffemobileapp.data.model.ResponseProducts
import retrofit2.http.GET

interface ProductsApi {


    @GET("products")
    suspend fun getProducts(): ResponseProducts
}