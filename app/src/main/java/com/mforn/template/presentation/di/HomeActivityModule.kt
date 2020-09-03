package com.mforn.template.presentation.di

import android.app.Activity
import com.mforn.common.presentation.view.di.ActivityModule
import com.mforn.template.presentation.view.activity.HomeActivity
import dagger.Binds
import dagger.Module

@Module
abstract class HomeActivityModule {

    @Binds
    abstract fun bindActivity(activity: HomeActivity): Activity

}

@Module(includes = [(ActivityModule::class), (HomeActivityModule::class)])
class HomeModule