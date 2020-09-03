package com.mforn.template.presentation.application

import com.mforn.template.presentation.application.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import com.mforn.template.presentation.application.view.BaseApplication

class ApplicationController : BaseApplication() {


    override fun applicationInjector(): AndroidInjector<out dagger.android.DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }


}