package com.dis.currencyview.domain.interactors

interface LoginInteractor{

    fun getLoginState(): Boolean
    fun getOneToken(): String
    fun getTowToken(): String

}