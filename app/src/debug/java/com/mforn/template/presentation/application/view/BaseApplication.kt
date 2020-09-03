package com.mforn.template.presentation.application.view

import com.facebook.stetho.Stetho
import dagger.android.DaggerApplication
import timber.log.Timber
import timber.log.Timber.DebugTree


abstract class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
        initializeStetho()
    }

    private fun initializeStetho() {
        val initializerBuilder = Stetho.newInitializerBuilder(this)

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
            Stetho.defaultInspectorModulesProvider(this)
        )

        // Enable command line interface
        initializerBuilder.enableDumpapp(
            Stetho.defaultDumperPluginsProvider(this)
        )

        // Use the InitializerBuilder to generate an Initializer
        val initializer = initializerBuilder.build()

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer)
        Timber.i("Stetho initialized")
    }

    private fun setupTimber() {
        Timber.plant(DebugTree())
    }

}