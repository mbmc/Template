package com.mbmc.template.di.component

import com.mbmc.template.Application
import com.mbmc.template.di.module.ActivityModule
import com.mbmc.template.di.module.ApiModule
import com.mbmc.template.di.module.MainModule
import com.mbmc.template.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector

import javax.inject.Singleton

@Component (modules = [ActivityModule::class, ApiModule::class, MainModule::class, ViewModelModule::class])
@Singleton
interface ApplicationComponent : AndroidInjector<Application>
