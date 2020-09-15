package com.mforn.onboarding.configuration

import com.mforn.common.presentation.model.mapper.ViewMapper
import com.mforn.onboarding.data.repository.OnBoardingRepositoryImpl
import com.mforn.onboarding.domain.interactor.OnBoardingInteractor
import com.mforn.onboarding.domain.interactor.OnBoardingInteractorImpl
import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.domain.repository.OnBoardingRepository
import com.mforn.onboarding.presentation.model.OnboardingStepView
import com.mforn.onboarding.presentation.model.mapper.OnboardingMapper
import com.mforn.onboarding.presentation.view.viewmodel.OnboardingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val onBoardingModule = module {

    single<ViewMapper<List<OnboardingStepView>, List<OnboardingStep>>> { OnboardingMapper() }
    single<OnBoardingRepository> { OnBoardingRepositoryImpl(get()) }
    single<OnBoardingInteractor> { OnBoardingInteractorImpl(get()) }

    // MyViewModel ViewModel
    viewModel { OnboardingViewModel(get(), get(), get()) }
}
