package com.mbmc.template.di

import com.mbmc.template.data.api.ApiService
import com.mbmc.template.di.module.ApiModule
import retrofit2.Retrofit

class TestApiModule : ApiModule() {
    override fun apiService(retrofit: Retrofit): ApiService = TestApiService()
}