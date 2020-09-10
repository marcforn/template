package com.mforn.onboarding.configuration

import com.mforn.common.configuration.ActivityModule
import com.mforn.common.presentation.view.activity.BaseActivity
import com.mforn.onboarding.presentation.view.activity.OnboardingActivity
import dagger.Binds
import dagger.Module

@Module
abstract class OnBoardingActivityModule {

    @Binds
    abstract fun bindOnBoardingActivity(activity: OnboardingActivity): BaseActivity

}

@Module(includes = [(ActivityModule::class), (OnBoardingActivityModule::class)])
class OnBoardingModule