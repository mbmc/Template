package com.mbmc.template.feature.search.di.module

import com.mbmc.template.feature.search.data.api.ApiService
import com.mbmc.template.feature.search.helper.TestApiService
import com.mbmc.template.feature.search.di.scope.SearchScope
import retrofit2.Retrofit

class TestApiModule : ApiModule() {
    @SearchScope
    override fun provideApiService(retrofit: Retrofit): ApiService =
        TestApiService()
}