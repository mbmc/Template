package com.mbmc.template.common.core.di.component

import com.mbmc.template.common.core.di.module.ApiModule
import com.mbmc.template.common.core.di.module.MainModule
import com.mbmc.template.common.core.di.module.SchedulerModule
import com.mbmc.template.common.core.di.module.ViewModelFactoryModule
import com.mbmc.template.common.core.di.scope.CoreScope
import com.mbmc.template.common.core.session.SessionManager
import com.mbmc.template.common.core.util.Schedulers
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [ApiModule::class, MainModule::class, SchedulerModule::class, ViewModelFactoryModule::class])
@CoreScope
interface CoreComponent {
    fun provideSessionManager(): SessionManager
    fun provideRetrofit(): Retrofit
    fun provideSchedulers(): Schedulers
}

interface CoreComponentProvider {
    fun getCoreComponent(): CoreComponent
}
