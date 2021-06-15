package com.dis.currencyview.domain.di

import com.dis.currencyview.data.repository.auth.AuthRepositoryImpl
import com.dis.currencyview.data.storage.CurrencySharedPrefs
import com.dis.currencyview.domain.interactors.repository.AuthRepository
import org.koin.dsl.module

object Domain {

    val currrencyDomain = module {
        single { CurrencySharedPrefs(get()) }
        factory<AuthRepository> { (AuthRepositoryImpl(get(), get())) }
    }
}