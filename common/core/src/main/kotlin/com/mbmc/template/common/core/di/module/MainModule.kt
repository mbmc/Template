package com.mbmc.template.common.core.di.module

import com.mbmc.template.common.core.Constants
import com.mbmc.template.common.core.di.scope.CoreScope
import com.mbmc.template.common.core.session.SessionManager
import dagger.Module
import dagger.Provides

@Module
object MainModule {
    @Provides
    @CoreScope
    @JvmStatic
    fun provideSessionManager(): SessionManager = SessionManager(Constants.TOKEN)
}
