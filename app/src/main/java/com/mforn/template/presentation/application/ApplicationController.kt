package com.mforn.template.presentation.application

import com.mforn.authentication.configuration.authenticationModule
import com.mforn.common.configuration.commonModule
import com.mforn.onboarding.configuration.onBoardingModule
import com.mforn.template.configuration.appModule
import com.mforn.template.presentation.application.view.BaseApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationController : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ApplicationController)
            modules(
                commonModule,
                appModule,
                onBoardingModule,
                authenticationModule
            )
        }
    }


}