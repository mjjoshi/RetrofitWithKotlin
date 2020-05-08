package com.spaceo.androidpractical.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient  {

    //https://dl.dropboxusercontent.com/s/p57gxwqm84zkp96/demo_api.json
    private const val BASE_URL = "https://dl.dropboxusercontent.com/s/p57gxwqm84zkp96/"
    val instance: Api by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(Api::class.java)
    }
}