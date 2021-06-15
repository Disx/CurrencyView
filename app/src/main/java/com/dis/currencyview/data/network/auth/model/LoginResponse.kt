package com.dis.currencyview.data.network.auth.model

import androidx.annotation.Keep

@Keep
internal data class LoginResponse(
    val authKey: String
)