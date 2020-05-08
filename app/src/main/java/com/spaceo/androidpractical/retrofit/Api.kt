package com.spaceo.androidpractical.retrofit


import com.spaceo.androidpractical.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET


interface Api {
    @GET("demo_api.json")
    fun getDatas(): Call<ResponseData>


}