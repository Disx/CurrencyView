package com.dis.currencyview.data.network.auth.model

import com.google.gson.annotations.SerializedName
import com.vityaz.aero.data.network.auth.model.LoginForm

internal data class LoginBody(
    @SerializedName("login-form")
    val loginForm: LoginForm
)