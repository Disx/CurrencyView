package com.dis.currencyview

import android.app.Application
import com.dis.currencyview.data.di.Data
import com.dis.currencyview.domain.di.Domain
import com.dis.currencyview.ui.di.CurrencyApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App() : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(CurrencyApp.currencyViewApp+Domain.currrencyDomain+ Data.currencyData)
        }
    }
}