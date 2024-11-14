package com.castaneda.coffemobileapp.data.repository

import com.castaneda.coffemobileapp.data.model.ResponseProducts
import com.castaneda.coffemobileapp.data.remote.ProductsApi
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val productsApi: ProductsApi
){
    suspend fun getProducts(): ResponseProducts{
        return productsApi.getProducts()
    }
}