package com.mbmc.template.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

// https://github.com/googlesamples/android-architecture-components/blob/master/GithubBrowserSample/
// app/src/main/java/com/android/example/github/di/ViewModelKey.kt
@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)