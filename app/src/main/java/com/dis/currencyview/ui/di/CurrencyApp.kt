package com.dis.currencyview.ui.di

import com.dis.currencyview.domain.interactors.LoginInteractor
import com.dis.currencyview.domain.interactors.LoginInteractorImpl
import com.dis.currencyview.ui.main.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CurrencyApp {
    val currencyViewApp = module{
        single<LoginInteractor>{LoginInteractorImpl(get())}
        viewModel{HomeViewModel(get(), get())}
    }
}