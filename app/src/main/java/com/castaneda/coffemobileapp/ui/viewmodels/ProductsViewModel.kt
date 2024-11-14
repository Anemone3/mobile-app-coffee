package com.castaneda.coffemobileapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.castaneda.coffemobileapp.data.model.Product
import com.castaneda.coffemobileapp.data.repository.ProductsRepository
import com.castaneda.coffemobileapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
):ViewModel() {
    private val _productState = MutableStateFlow<Resource<List<Product>>>(Resource.Loading())

    val stateProduct: StateFlow<Resource<List<Product>>>
        get() = _productState

    init {
       fetchProducts()
    }


    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                // Emitimos el estado de carga
                _productState.value = Resource.Loading()

                // Llamamos al repositorio para obtener los datos
                val response = productsRepository.getProducts()

                // Verificamos si la respuesta es exitosa
                if (response.products.isNotEmpty()) {
                    _productState.value = Resource.Success(response.products)
                } else {
                    _productState.value = Resource.Error("No se encontraron productos.")
                }
            } catch (e: Exception) {
                // En caso de error, emitimos el estado de error
                _productState.value = Resource.Error("Error al cargar los productos: ${e.message}")
            }
        }
    }



}