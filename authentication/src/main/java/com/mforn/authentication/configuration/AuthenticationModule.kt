package com.mforn.authentication.configuration

import android.app.Activity
import com.mforn.authentication.presentation.view.activity.AuthenticationLauncherActivity
import com.mforn.common.configuration.ActivityModule
import dagger.Binds
import dagger.Module

@Module
abstract class AuthenticationActivityModule {

    @Binds
    abstract fun bindActivity(activity: AuthenticationLauncherActivity): Activity

}

@Module(includes = [(ActivityModule::class), (AuthenticationActivityModule::class)])
class AuthenticationModule