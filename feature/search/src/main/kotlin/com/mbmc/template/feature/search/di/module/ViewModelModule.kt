package com.mbmc.template.feature.search.di.module

import androidx.lifecycle.ViewModel
import com.mbmc.template.common.core.di.ViewModelKey
import com.mbmc.template.feature.search.presentation.ui.RepoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    abstract fun bindRepoViewModel(repoViewModel: RepoViewModel): ViewModel
}