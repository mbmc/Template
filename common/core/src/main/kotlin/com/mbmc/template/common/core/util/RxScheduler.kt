package com.mbmc.template.common.core.util

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class RxScheduler(val value: String = "") {
    object Type {
        const val IO = "workerThread"
        const val MAIN = "observerThread"
    }
}