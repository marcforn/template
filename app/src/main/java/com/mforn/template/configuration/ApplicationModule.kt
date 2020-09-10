package com.mforn.template.configuration

import android.app.Application
import com.mforn.template.presentation.application.ApplicationController
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindApplication(application: ApplicationController): Application

}