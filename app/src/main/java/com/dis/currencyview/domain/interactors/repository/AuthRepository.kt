package com.dis.currencyview.domain.interactors.repository

interface AuthRepository {

    suspend fun signIn(login: String, password: String)

    fun isAuthorized(): Boolean

    fun logout()
}