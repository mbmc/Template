package com.mbmc.template.common.core

import com.mbmc.template.common.core.di.component.CoreComponent
import com.mbmc.template.common.core.di.component.CoreComponentProvider
import com.mbmc.template.common.core.di.component.DaggerCoreComponent

open class Application : android.app.Application(), CoreComponentProvider {
    private val _coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun getCoreComponent(): CoreComponent = _coreComponent
}