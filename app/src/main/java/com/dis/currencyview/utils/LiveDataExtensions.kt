package com.dis.currencyview.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.clear() {
    value = null
}

fun <T> MutableLiveData<T>.asLiveData(): LiveData<T> = this

fun <T> MutableLiveData<T>.isEmpty() = value == null

