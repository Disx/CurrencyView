package com.dis.currencyview.data.storage

import android.annotation.SuppressLint
import android.content.Context
import com.dis.currencyview.domain.interactors.sharedprefs.CurrencySharedPrefsDao

private const val CURRENCY_SHARED_PREFS = "currency_shared_prefs_key"
private const val LOGGED_IN = "logged_in_key"
private const val TOKEN_ONE = "token_one_key"
private const val TOKEN_TWO = "token_two_key"

internal class CurrencySharedPrefs(context: Context) : CurrencySharedPrefsDao {

    private val prefs = context.getSharedPreferences(CURRENCY_SHARED_PREFS, Context.MODE_PRIVATE)

    override var loggedIn: Boolean
        get() = prefs.getBoolean(LOGGED_IN, false)
        set(value) {
            prefs.edit().putBoolean(LOGGED_IN, value).apply()
        }
    override var tokenOne: String
        get() = prefs.getString(TOKEN_ONE, "").toString()
        @SuppressLint("ApplySharedPref")
        set(value) {
            prefs.edit().putString(TOKEN_ONE, value).apply()
        }
    override var tokenTwo: String
        get() = prefs.getBoolean(TOKEN_TWO, false).toString()
        @SuppressLint("ApplySharedPref")
        set(value) {
            prefs.edit().putString(TOKEN_TWO, value).apply()
        }
}