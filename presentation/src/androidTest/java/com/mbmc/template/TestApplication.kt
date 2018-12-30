package com.mbmc.template

import com.mbmc.template.di.ApplicationComponent
import com.mbmc.template.di.DaggerApplicationComponent
import com.mbmc.template.di.TestApiModule

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun getComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .apiModule(TestApiModule())
            .build()

    }

}