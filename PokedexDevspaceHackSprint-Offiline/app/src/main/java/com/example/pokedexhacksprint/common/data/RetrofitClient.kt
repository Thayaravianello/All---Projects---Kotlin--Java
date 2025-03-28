package com.example.pokedexhacksprint.common.data


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
private const val BASE_URL: String = "https://pokeapi.co/api/v2/"

object RetrofitClient {

    private val httpClient: OkHttpClient
        get(){
            val clientBuilder = OkHttpClient.Builder()


            clientBuilder.addInterceptor{ chain ->
                val original: Request = chain.request()
                val requestBuilder: Request.Builder = original.newBuilder()
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
            return clientBuilder.build()
        }

    val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


}