package com.mforn.template.presentation.application.di

import com.mforn.template.presentation.application.ApplicationController
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        (AndroidInjectionModule::class),
        (ApplicationModule::class),
        (ViewModelModule::class),
        (InjectorsModule::class)
    ]
)
internal interface ApplicationComponent : AndroidInjector<ApplicationController> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ApplicationController>()
}

