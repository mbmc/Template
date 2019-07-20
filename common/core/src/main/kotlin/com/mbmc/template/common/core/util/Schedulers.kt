package com.mbmc.template.common.core.util

import com.mbmc.template.common.core.di.scope.CoreScope
import com.mbmc.template.common.core.util.RxScheduler.Type.IO
import com.mbmc.template.common.core.util.RxScheduler.Type.MAIN
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer
import javax.inject.Inject

@CoreScope
class Schedulers @Inject constructor(
    @RxScheduler(IO) val workerThread: Scheduler,
    @RxScheduler(MAIN) val observerThread: Scheduler
) {
    fun <T> ioToMain(): SingleTransformer<T, T> =
        SingleTransformer { observer ->
            observer.subscribeOn(workerThread).observeOn(observerThread)
        }
}