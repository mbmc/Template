package com.mbmc.template.core.di.module

import com.mbmc.template.core.Constants
import com.mbmc.template.core.api.NetworkInterceptor
import com.mbmc.template.core.di.scope.CoreScope
import com.mbmc.template.core.session.SessionManager
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

import java.util.concurrent.TimeUnit

@Module
object ApiModule {
    private const val TIMEOUT = 10L // 10s

    @Provides
    @CoreScope
    @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.GITHUB_API)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    @CoreScope
    @JvmStatic
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(interceptor)
        return okHttpClientBuilder.build()
    }

    @Provides
    @CoreScope
    @JvmStatic
    fun provideInterceptor(sessionManager: SessionManager): Interceptor = NetworkInterceptor(sessionManager)
}
