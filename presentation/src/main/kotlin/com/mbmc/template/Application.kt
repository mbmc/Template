package com.mbmc.template

import android.app.Activity
import com.mbmc.template.di.component.ApplicationComponent
import com.mbmc.template.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

import javax.inject.Inject

open class Application : android.app.Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        getComponent().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    open fun getComponent(): ApplicationComponent = DaggerApplicationComponent.create()
}
