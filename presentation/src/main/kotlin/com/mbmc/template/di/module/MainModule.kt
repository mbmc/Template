package com.mbmc.template.di.module

import com.mbmc.template.data.Constants
import com.mbmc.template.data.api.ApiService
import com.mbmc.template.data.entity.Mapper
import com.mbmc.template.data.repository.RepoDataRepository
import com.mbmc.template.data.session.SessionManager
import com.mbmc.template.domain.repository.RepoRepository
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

import javax.inject.Singleton

@Module
class MainModule {
    @Provides
    @Singleton
    fun sessionManager(): SessionManager = SessionManager(Constants.TOKEN)

    @Provides
    @Singleton
    fun repoRepository(apiService: ApiService, mapper: Mapper): RepoRepository = RepoDataRepository(apiService, mapper)

    @Provides
    @Singleton
    @Named("workerThread")
    fun workerThread(): Scheduler = Schedulers.io()

    @Provides
    @Singleton
    @Named("observerThread")
    fun observerThread(): Scheduler = AndroidSchedulers.mainThread()
}
