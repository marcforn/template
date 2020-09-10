package com.mforn.template.configuration

import com.mforn.common.configuration.ActivityModule
import com.mforn.common.presentation.view.activity.BaseActivity
import com.mforn.template.presentation.view.activity.HomeActivity
import dagger.Binds
import dagger.Module

@Module
abstract class HomeActivityModule {

    @Binds
    abstract fun bindHomeActivity(activity: HomeActivity): BaseActivity

}

@Module(includes = [(ActivityModule::class), (HomeActivityModule::class)])
class HomeModule