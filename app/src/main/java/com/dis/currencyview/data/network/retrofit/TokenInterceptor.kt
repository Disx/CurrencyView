package com.dis.currencyview.data.network.retrofit

import com.dis.currencyview.data.storage.token.TokenDao
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Invocation
import java.io.IOException

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthRequired

internal class TokenInterceptor(
    private val tokenDao: TokenDao
) : Interceptor {

    companion object {
        const val AUTH_HEADER = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        if (originalRequest.isAuthRequired()) {
            val token = tokenDao.accessToken ?: throw  IOException("Access token is null!")
            val request = chain
                .request()
                .newBuilder()
                .addHeader(AUTH_HEADER, "Bearer $token")
                .build()

            return chain.proceed(request)
        }

        return chain.proceed(chain.request())
    }
}

private fun Request.isAuthRequired(): Boolean {
    val invocation = tag(Invocation::class.java)
    return invocation?.method()?.getAnnotation(AuthRequired::class.java) != null
}