package com.mbmc.template

import com.mbmc.template.di.component.ApplicationComponent
import com.mbmc.template.di.TestApiModule
import com.mbmc.template.di.component.DaggerApplicationComponent

class TestApplication : Application() {
    override fun getComponent(): ApplicationComponent =
        DaggerApplicationComponent.builder()
            .apiModule(TestApiModule())
            .build()
}