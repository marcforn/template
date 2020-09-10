package com.mforn.template.configuration

import com.mforn.authentication.configuration.AuthenticationInjectorsModule
import com.mforn.onboarding.configuration.OnBoardingInjectorsModule
import com.mforn.onboarding.configuration.OnBoardingViewModelModule
import com.mforn.template.presentation.application.ApplicationController
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        // Application
        (AndroidSupportInjectionModule::class),
        (ApplicationModule::class),
        // App Module
        (AppInjectorsModule::class),
        (AppViewModelModule::class),
        // OnBoarding Module
        (OnBoardingInjectorsModule::class),
        (OnBoardingViewModelModule::class),
        // Authentication Module
        (AuthenticationInjectorsModule::class)
    ]
)
internal interface ApplicationComponent : AndroidInjector<ApplicationController> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ApplicationController>()
}

