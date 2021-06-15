package com.dis.currencyview.data.di

import com.dis.currencyview.data.network.auth.AuthApi
import com.dis.currencyview.data.network.retrofit.RetrofitFactory
import com.dis.currencyview.data.network.retrofit.TokenInterceptor
import com.dis.currencyview.data.repository.auth.AuthRepositoryImpl
import com.dis.currencyview.data.storage.CurrencySharedPrefs
import com.dis.currencyview.data.storage.token.TokenDao
import com.dis.currencyview.data.storage.token.TokenDaoImpl
import com.dis.currencyview.domain.interactors.sharedprefs.CurrencySharedPrefsDao
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import retrofit2.Retrofit

object Data {
    private const val PEANUT_API = "PEANUT_API"
    private const val PARTNER_API = "PARTNER_API"

    private const val CLEAN_RETROFIT = "CLEAN_RETROFIT"

    val currencyData = module {
        //Shared Preferences
        single<CurrencySharedPrefsDao> { CurrencySharedPrefs(get()) }

        //Auth
        single<TokenDao> { TokenDaoImpl(get()) }
        single { TokenInterceptor(get()) }

        //Network
        single(qualifier(PEANUT_API)) { RetrofitFactory.buildRetrofitPeanut(get()) }
        single(qualifier(CLEAN_RETROFIT)) { RetrofitFactory.buildCleanRetrofit() }
        single<AuthApi> { get<Retrofit>(qualifier(PEANUT_API)).create(AuthApi::class.java)}
//        single<AuthApi> { get<Retrofit>(qualifier(PARTNER_API)).create(AuthApi::class.java)}
    }
}