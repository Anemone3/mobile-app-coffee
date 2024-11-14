package com.castaneda.coffemobileapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.castaneda.coffemobileapp.data.model.Product
import com.castaneda.coffemobileapp.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
):ViewModel() {
    private val _productState = MutableStateFlow(emptyList<Product>())

    val stateProduct: StateFlow<List<Product>>
        get() = _productState

    init {
        viewModelScope.launch {
            _productState.value = productsRepository.getProducts().products
        }
    }



}