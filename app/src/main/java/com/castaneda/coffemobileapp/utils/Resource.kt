package com.castaneda.coffemobileapp.utils

// Una forma muy facil
//sealed class Resource<out T> {
//    data class Error(val exception: Exception) : Resource<Nothing>()
//    data class Success<T>(val data: T) : Resource<T>()
//
//}

sealed class Resource<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
    class Loading<T>: Resource<T>()

}