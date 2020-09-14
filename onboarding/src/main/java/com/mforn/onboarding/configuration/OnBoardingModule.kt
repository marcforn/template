package com.mforn.onboarding.configuration

import android.content.res.Resources
import com.mforn.common.data.resources.repository.ResourcesRepositoryImpl
import com.mforn.common.domain.repository.ResourcesRepository
import com.mforn.common.presentation.coroutines.CoroutineDispatchers
import com.mforn.common.presentation.model.mapper.ViewMapper
import com.mforn.onboarding.data.repository.OnBoardingRepositoryImpl
import com.mforn.onboarding.domain.interactor.OnBoardingInteractor
import com.mforn.onboarding.domain.interactor.OnBoardingInteractorImpl
import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.domain.repository.OnBoardingRepository
import com.mforn.onboarding.presentation.model.OnboardingStepView
import com.mforn.onboarding.presentation.model.mapper.OnboardingMapper
import com.mforn.onboarding.presentation.view.viewmodel.OnboardingViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val onBoardingModule = module {

    single { CoroutineDispatchers(Dispatchers.Main, Dispatchers.Default, Dispatchers.IO) }
    single<ViewMapper<List<OnboardingStepView>, List<OnboardingStep>>> { OnboardingMapper() }
    single<Resources> { androidApplication().resources }
    single<ResourcesRepository> { ResourcesRepositoryImpl(get()) }
    single<OnBoardingRepository> { OnBoardingRepositoryImpl(get()) }
    single<OnBoardingInteractor> { OnBoardingInteractorImpl(get()) }

    // MyViewModel ViewModel
    viewModel { OnboardingViewModel(get(), get(), get()) }
}
