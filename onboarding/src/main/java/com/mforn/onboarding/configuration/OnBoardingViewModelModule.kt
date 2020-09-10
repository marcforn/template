package com.mforn.onboarding.configuration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mforn.common.configuration.ViewModelFactory
import com.mforn.common.configuration.ViewModelKey
import com.mforn.onboarding.presentation.view.viewmodel.OnboardingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class OnBoardingViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory // TODO mforn: 9/09/20 move to common

    @Binds
    @IntoMap
    @ViewModelKey(OnboardingViewModel::class)
    internal abstract fun sectorPerformanceViewModel(viewModel: OnboardingViewModel): ViewModel
}