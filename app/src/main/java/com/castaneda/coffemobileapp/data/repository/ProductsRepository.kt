package com.castaneda.coffemobileapp.data.repository

import com.castaneda.coffemobileapp.data.model.ProductDetail
import com.castaneda.coffemobileapp.data.model.ResponseProducts
import com.castaneda.coffemobileapp.data.remote.ProductsApi
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val productsApi: ProductsApi
){

    suspend fun getProducts(): ResponseProducts {
        return try {
            productsApi.getProducts()
        } catch (e: Exception) {
            throw Exception("Error al obtener los productos: ${e.localizedMessage}")
        }
    }


    suspend fun getProductsById(id: Int): ProductDetail {
        if (id <= 0) {
            throw IllegalArgumentException("El ID proporcionado no es válido: $id")
        }
        return productsApi.getProductById(id)
    }
}