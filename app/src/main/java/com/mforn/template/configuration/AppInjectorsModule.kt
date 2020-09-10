package com.mforn.template.configuration

import com.mforn.template.presentation.view.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class  AppInjectorsModule {

    //region Activity
    @ContributesAndroidInjector(modules = [(HomeModule::class)])
    abstract fun bindHomeActivity(): HomeActivity
    //endregion


}