package com.dis.currencyview.data.storage.token

import android.content.Context

private const val NAME = "common_auth"
private const val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"

internal class TokenDaoImpl(context: Context) : TokenDao {

    private val prefs = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)

    override var accessToken: String?
        get() = prefs.getString(KEY_ACCESS_TOKEN, null)
        set(value) {
            prefs.edit().putString(KEY_ACCESS_TOKEN, value).apply()
        }
}