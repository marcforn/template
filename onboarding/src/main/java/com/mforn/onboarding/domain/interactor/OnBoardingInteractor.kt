package com.mforn.onboarding.domain.interactor

import com.mforn.onboarding.domain.model.OnboardingStep


interface OnBoardingInteractor {

    suspend fun getOnBoardingCards(): List<OnboardingStep>

    fun setOnBoardingFinished()

}
