package com.mforn.onboarding.data.repository

import com.mforn.common.domain.repository.ResourcesRepository
import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.domain.repository.OnBoardingRepository

class OnBoardingRepositoryImpl(val resourcesRepository: ResourcesRepository) : OnBoardingRepository {

    override fun getOnBoardingCards(): List<OnboardingStep> {
        TODO("Not yet implemented")
    }
}