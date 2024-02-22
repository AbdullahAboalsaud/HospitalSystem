package com.example.hospitalsystem.repository

import com.example.hospitalsystem.data.ModelLogin
import com.example.hospitalsystem.network.RetroConnection
import retrofit2.http.Field

class Repo {
    suspend fun login(email: String, password: String, deviceToken: String) =
        RetroConnection.api.login(email, password, deviceToken)


}