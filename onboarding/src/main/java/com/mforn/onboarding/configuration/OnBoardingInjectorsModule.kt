package com.mforn.onboarding.configuration

import com.mforn.onboarding.presentation.view.activity.OnboardingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class OnBoardingInjectorsModule {

    //region Activity
    @ContributesAndroidInjector(modules = [(OnBoardingModule::class)])
    abstract fun bindOnBoardingActivity(): OnboardingActivity
    //endregion


}