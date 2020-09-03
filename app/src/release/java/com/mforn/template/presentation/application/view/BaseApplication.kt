package com.mforn.template.presentation.application.view

import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import dagger.android.DaggerApplication
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

abstract class BaseApplication : DaggerApplication()