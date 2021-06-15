package com.vityaz.aero.data.network.auth.model

import androidx.annotation.Keep

@Keep
internal data class LoginForm(
    val login: String,
    val password: String
)