package com.mforn.common.configuration

import com.mforn.common.data.network.configuration.RetrofitAdapter
import com.mforn.common.data.resources.repository.ResourcesRepositoryImpl
import com.mforn.common.domain.repository.ResourcesRepository
import com.mforn.common.presentation.coroutines.CoroutineDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val commonModule = module {
    // Resources
    single<ResourcesRepository> { ResourcesRepositoryImpl(androidApplication().resources) }
    single<CoroutineDispatchers> { CoroutineDispatchers(Dispatchers.Main, Dispatchers.Default, Dispatchers.IO) }

    //Network
    single<RetrofitAdapter> { RetrofitAdapter() }
}
