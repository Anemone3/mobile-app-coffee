package com.castaneda.coffemobileapp.di


import com.castaneda.coffemobileapp.data.remote.ProductsApi
import com.castaneda.coffemobileapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Para que se use la misma instancia
object AppModule {

    //Creamos un proveedor
    @Provides
    @Singleton
    fun provideApi(): ProductsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApi::class.java)
    }
}