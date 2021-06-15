package com.dis.currencyview.domain.interactors

import com.dis.currencyview.domain.interactors.sharedprefs.CurrencySharedPrefsDao

class LoginInteractorImpl(private val sharedRepo: CurrencySharedPrefsDao): LoginInteractor {

    override fun getLoginState(): Boolean =
        sharedRepo.loggedIn

    override fun getOneToken(): String =
        sharedRepo.tokenOne

    override fun getTowToken(): String =
        sharedRepo.tokenTwo

}