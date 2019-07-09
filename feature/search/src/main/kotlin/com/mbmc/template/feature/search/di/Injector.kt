package com.mbmc.template.feature.search.di

import androidx.annotation.VisibleForTesting
import com.mbmc.template.core.di.component.CoreComponentProvider
import com.mbmc.template.feature.search.di.component.DaggerSearchComponent
import com.mbmc.template.feature.search.di.module.ApiModule
import com.mbmc.template.feature.search.presentation.ui.MainActivity

object Injector {
    private var _apiModule = ApiModule()

    // Until there's a better solution...
    @VisibleForTesting
    public fun setApiModule(apiModule: ApiModule) {
        _apiModule = apiModule
    }

    fun MainActivity.inject() {
        DaggerSearchComponent.builder()
            .coreComponent((applicationContext as CoreComponentProvider).getCoreComponent())
            .apiModule(_apiModule)
            .build()
            .inject(this)
    }
}