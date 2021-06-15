package com.dis.currencyview.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dis.currencyview.domain.interactors.repository.AuthRepository
import com.dis.currencyview.domain.interactors.sharedprefs.CurrencySharedPrefsDao

class HomeViewModel(
    private val sharedPrefsDao: CurrencySharedPrefsDao,
private val authRepository: AuthRepository) : ViewModel() {

    val isLoggedIn = MutableLiveData<Boolean>().apply {
        sharedPrefsDao.loggedIn
    }
    val tokenOne = MutableLiveData<Boolean>().apply {
        sharedPrefsDao.tokenOne
    }
    val tokenTwo = MutableLiveData<Boolean>().apply {
        sharedPrefsDao.tokenTwo
    }

    fun isAuthorized() = authRepository.isAuthorized()
}