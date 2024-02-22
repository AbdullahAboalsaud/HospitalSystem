package com.example.hospitalsystem.network

import com.example.hospitalsystem.data.ModelLogin
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded

import retrofit2.http.POST

interface ApiCalls {
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("device_token") deviceToken:String
    ):ModelLogin

}