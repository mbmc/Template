package com.mbmc.template.feature.search.di.component

import com.mbmc.template.common.core.di.component.CoreComponent
import com.mbmc.template.feature.search.di.module.ApiModule
import com.mbmc.template.feature.search.di.scope.SearchScope
import com.mbmc.template.feature.search.di.module.MainModule
import com.mbmc.template.feature.search.di.module.ViewModelModule
import com.mbmc.template.feature.search.presentation.ui.SearchActivity
import dagger.Component

@Component(
    modules = [ApiModule::class, MainModule::class, ViewModelModule::class],
    dependencies = [CoreComponent::class]
)
@SearchScope
interface SearchComponent {
    fun inject(activity: SearchActivity)
}