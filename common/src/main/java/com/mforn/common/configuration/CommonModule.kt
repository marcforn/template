package com.mforn.common.configuration

import com.mforn.common.presentation.coroutines.CoroutineDispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class CommonModule {

    @Provides
    @Singleton
    internal fun provideCoroutineDispatchers(): CoroutineDispatchers {
        return CoroutineDispatchers(main = Dispatchers.Main, default = Dispatchers.Default, io = Dispatchers.IO)
    }

}