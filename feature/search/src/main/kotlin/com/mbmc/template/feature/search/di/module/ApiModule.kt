package com.mbmc.template.feature.search.di.module

import com.mbmc.template.feature.search.data.api.ApiService
import com.mbmc.template.feature.search.di.scope.SearchScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
open class ApiModule {
    @Provides
    @SearchScope
    open fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}