package com.vityaz.aero.data.network.retrofit.exception

import java.io.IOException

open class ApiException(val code: Int, message: String) : IOException(message)