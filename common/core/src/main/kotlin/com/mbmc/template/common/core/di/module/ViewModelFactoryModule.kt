package com.mbmc.template.common.core.di.module

import androidx.lifecycle.ViewModelProvider
import com.mbmc.template.common.core.di.ViewModelFactory
import com.mbmc.template.common.core.di.scope.CoreScope
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    @CoreScope
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}