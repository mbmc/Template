package com.mbmc.template.data.api

import com.mbmc.template.data.session.SessionManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkInterceptor(private val sessionManager: SessionManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request
        if (sessionManager.isLoggedIn()) {
            request = Request.Builder()
                .addHeader("Authorization", sessionManager.token)
                .build()
        } else {
            request = chain.request()
        }

        return chain.proceed(request)
    }
}
