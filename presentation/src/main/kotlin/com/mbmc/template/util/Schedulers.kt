package com.mbmc.template.util

import io.reactivex.Scheduler
import io.reactivex.SingleTransformer
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class Schedulers @Inject constructor(
    @Named("workerThread") val workerThread: Scheduler,
    @Named("observerThread") val observerThread: Scheduler
) {
    fun <T> ioToMain(): SingleTransformer<T, T> =
        SingleTransformer { observer ->
            observer.subscribeOn(workerThread).observeOn(observerThread)
        }
}