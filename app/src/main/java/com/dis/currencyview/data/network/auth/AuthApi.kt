package com.dis.currencyview.data.network.auth

import com.dis.currencyview.data.network.auth.model.LoginBody
import com.dis.currencyview.data.network.auth.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AuthApi {

    @POST("api/users/security/login")
    suspend fun login(@Body loginBody: LoginBody): Response<LoginResponse>
}