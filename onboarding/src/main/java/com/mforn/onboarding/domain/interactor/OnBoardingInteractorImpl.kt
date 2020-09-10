package com.mforn.onboarding.domain.interactor


import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.domain.repository.OnBoardingRepository

class OnBoardingInteractorImpl(private val onBoardingRepository: OnBoardingRepository) : OnBoardingInteractor {

    override suspend fun getOnBoardingCards(): List<OnboardingStep> = onBoardingRepository.getOnBoardingCards()

    override fun setOnBoardingFinished() {
    }

}
