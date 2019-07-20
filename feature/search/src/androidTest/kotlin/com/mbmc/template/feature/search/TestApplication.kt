package com.mbmc.template.feature.search

import com.mbmc.template.common.core.di.component.CoreComponent
import com.mbmc.template.common.core.di.component.DaggerCoreComponent
import com.mbmc.template.feature.search.di.module.TestScheduleModule

class TestApplication : com.mbmc.template.common.core.Application() {
    override fun getCoreComponent(): CoreComponent =
        DaggerCoreComponent.builder()
            .schedulerModule(TestScheduleModule())
            .build()
}