package com.dis.currencyview.domain.interactors.sharedprefs

interface CurrencySharedPrefsDao {

    var loggedIn: Boolean
    var tokenOne: String
    var tokenTwo: String
}