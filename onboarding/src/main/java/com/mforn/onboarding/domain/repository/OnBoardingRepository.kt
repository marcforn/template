package com.mforn.onboarding.domain.repository

import com.mforn.onboarding.domain.model.OnboardingStep

interface OnBoardingRepository {

    fun getOnBoardingCards(): List<OnboardingStep>
}