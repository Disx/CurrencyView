package com.dis.currencyview.data.network

import com.vityaz.aero.data.network.retrofit.exception.ApiException
import com.vityaz.aero.data.network.retrofit.exception.ServerMessageException
import com.vityaz.aero.data.network.retrofit.exception.ServerTroublesException
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

internal fun <T> Response<T>.bodyOrError(): T {
    val responseCode = code()

    if (isSuccessful) {
        body()?.let { body ->
            return body
        }
    }

    if (responseCode == 401) {
        throw ServerMessageException(responseCode, errorBody() ?: error("Error body can't be null"))
    }

    if (responseCode == 422) {
        throw ServerMessageException(responseCode, errorBody() ?: error("Error body can't be null"))
    }

    if (responseCode in 500 until 600) {
        throw ServerTroublesException(responseCode, message().orEmpty())
    }

    throw ApiException(responseCode, message().orEmpty())
}

internal fun ResponseBody.toStringError(): String {
    var returnString = ""
    val jsonObject = JSONObject(this.charStream().readText())
    try {
        val errors = jsonObject.getJSONObject("errors")
        errors.keys().forEach { key ->
            try {
                val keyArray = errors.getJSONArray(key)
                for (i in 0 until keyArray.length()) {
                    returnString += keyArray[i]
                }
            } catch (e: JSONException) {
                returnString += errors.getString(key) + "\n"
            }
        }
    } catch (e: JSONException) {
        try {
            val message = jsonObject.getString("message")
            returnString = message.toString()
        } catch (e: JSONException) {
        }
    }
    return returnString
}