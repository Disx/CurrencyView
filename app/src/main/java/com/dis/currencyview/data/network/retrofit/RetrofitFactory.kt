package com.dis.currencyview.data.network.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Fields from login: dev
const val PEANUT_API_BASE_URL = "https://peanut.ifxdb.com/docs/clientcabinet/"
const val PARTNER_API_BASE_URL = "https://client-api.contentdatapro.com/api/Authentication/RequestMobileCabinetApiToken"

internal object RetrofitFactory {
    fun buildRetrofitPeanut(
        tokenInterceptor: TokenInterceptor
    ): Retrofit {
        val httpClientBuilder = OkHttpClient.Builder().apply {
            addInterceptor(tokenInterceptor)
            addInterceptor(getLoggingInterceptor())
        }
        return buildRetrofitPeanut(
            httpClientBuilder.build()
        )
    }

    fun buildCleanRetrofit(): Retrofit =
        buildRetrofitPeanut(
            OkHttpClient.Builder().apply {
                addInterceptor(getLoggingInterceptor())
            }.build()
        )

    private fun getLoggingInterceptor() =
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("Retrofit_LOG", message)
            }
        })
            .apply { level = HttpLoggingInterceptor.Level.BODY }

    private fun buildRetrofitPeanut(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(PEANUT_API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun buildRetrofitPartner(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(PARTNER_API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}