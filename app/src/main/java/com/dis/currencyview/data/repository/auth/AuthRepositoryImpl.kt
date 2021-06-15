package com.dis.currencyview.data.repository.auth

import com.dis.currencyview.data.network.auth.AuthApi
import com.dis.currencyview.data.network.auth.model.LoginBody
import com.dis.currencyview.data.network.bodyOrError
import com.dis.currencyview.data.storage.token.TokenDao
import com.dis.currencyview.domain.interactors.repository.AuthRepository
import com.vityaz.aero.data.network.auth.model.LoginForm

internal class AuthRepositoryImpl(
    private val tokenDao: TokenDao,
    private val api: AuthApi
) : AuthRepository {

    override suspend fun signIn(login: String, password: String) {
        val loginResponse = api.login(LoginBody(LoginForm(login, password))).bodyOrError()
        tokenDao.accessToken = loginResponse.authKey
    }

    override fun isAuthorized(): Boolean = tokenDao.accessToken != null

    override fun logout() {
        tokenDao.accessToken = null
    }
}