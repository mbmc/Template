package com.mbmc.template.core.di.module

import com.mbmc.template.core.di.scope.CoreScope
import com.mbmc.template.core.util.RxScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

// Separate module, as abstract modules can't be overridden
@Module
open class SchedulerModule {
    @Provides
    @CoreScope
    @RxScheduler(RxScheduler.Type.IO)
    open fun provideWorkerThread(): Scheduler = io.reactivex.schedulers.Schedulers.io()

    @Provides
    @CoreScope
    @RxScheduler(RxScheduler.Type.MAIN)
    open fun provideObserverThread(): Scheduler = AndroidSchedulers.mainThread()
}