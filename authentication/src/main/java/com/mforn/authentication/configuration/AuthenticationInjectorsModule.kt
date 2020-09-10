package com.mforn.authentication.configuration

import com.mforn.authentication.presentation.view.activity.AuthenticationLauncherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AuthenticationInjectorsModule {

    //region Activity
    @ContributesAndroidInjector(modules = [(AuthenticationModule::class)])
    abstract fun bindHomeActivity(): AuthenticationLauncherActivity
    //endregion


}