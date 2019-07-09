package com.mbmc.template.core.di.module

import com.mbmc.template.core.Constants
import com.mbmc.template.core.di.scope.CoreScope
import com.mbmc.template.core.session.SessionManager
import dagger.Module
import dagger.Provides

@Module
object MainModule {
    @Provides
    @CoreScope
    @JvmStatic
    fun provideSessionManager(): SessionManager = SessionManager(Constants.TOKEN)
}
