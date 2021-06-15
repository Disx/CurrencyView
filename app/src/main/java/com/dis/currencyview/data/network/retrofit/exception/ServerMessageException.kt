package com.vityaz.aero.data.network.retrofit.exception

import com.dis.currencyview.data.network.toStringError
import okhttp3.ResponseBody

class ServerMessageException(code: Int, body: ResponseBody) :
    ApiException(code, body.toStringError())

