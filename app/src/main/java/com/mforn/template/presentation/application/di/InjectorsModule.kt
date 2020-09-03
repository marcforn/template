package com.mforn.template.presentation.application.di

import com.mforn.template.presentation.di.HomeModule
import com.mforn.template.presentation.view.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class InjectorsModule {

    //region Activity
    @ContributesAndroidInjector(modules = [(HomeModule::class)])
    abstract fun bindHomeActivity(): HomeActivity
    //endregion


}