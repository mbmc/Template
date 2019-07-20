package com.mbmc.template.common.core.api

import com.mbmc.template.common.core.session.SessionManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkInterceptor(private val sessionManager: SessionManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = if (sessionManager.isLoggedIn()) {
            Request.Builder().addHeader("Authorization", sessionManager.token).build()
        } else {
            chain.request()
        }

        return chain.proceed(request)
    }
}
