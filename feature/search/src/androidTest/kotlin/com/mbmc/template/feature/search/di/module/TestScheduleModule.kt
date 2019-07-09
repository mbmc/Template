package com.mbmc.template.feature.search.di.module

import com.mbmc.template.core.di.module.SchedulerModule
import io.reactivex.Scheduler

class TestScheduleModule : SchedulerModule() {
    override fun provideWorkerThread(): Scheduler = io.reactivex.schedulers.Schedulers.trampoline()

    override fun provideObserverThread(): Scheduler = io.reactivex.schedulers.Schedulers.trampoline()
}