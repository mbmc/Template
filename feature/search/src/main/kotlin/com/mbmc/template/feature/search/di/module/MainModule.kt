package com.mbmc.template.feature.search.di.module

import com.mbmc.template.feature.search.data.api.ApiService
import com.mbmc.template.feature.search.data.entity.Mapper
import com.mbmc.template.feature.search.data.repository.RepoDataRepository
import com.mbmc.template.feature.search.di.scope.SearchScope
import com.mbmc.template.feature.search.domain.repository.RepoRepository
import dagger.Module
import dagger.Provides

@Module
object MainModule {
    @Provides
    @SearchScope
    @JvmStatic
    fun provideRepoRepository(apiService: ApiService, mapper: Mapper): RepoRepository =
        RepoDataRepository(apiService, mapper)
}