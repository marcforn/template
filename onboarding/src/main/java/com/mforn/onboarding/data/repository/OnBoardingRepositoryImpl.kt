package com.mforn.onboarding.data.repository

import com.mforn.common.domain.repository.ResourcesRepository
import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.domain.repository.OnBoardingRepository
import kotlinx.coroutines.delay

class OnBoardingRepositoryImpl(val resourcesRepository: ResourcesRepository) : OnBoardingRepository {

    override suspend fun getOnBoardingCards(): List<OnboardingStep> {
        delay(5000) // TODO mforn: 9/09/20 temporal load simulation

        val onboardingList = arrayListOf<OnboardingStep>()
        val onboardingStep1 = OnboardingStep("Welcome", "Lorem Ipsum", 0, 0, 0)
        val onboardingStep2 = OnboardingStep("Screen 2", "Lorem Ipsum", 0, 0, 0)
        val onboardingStep3 = OnboardingStep("Screen 3", "Lorem Ipsum", 0, 0, 0)

        onboardingList.add(onboardingStep1)
        onboardingList.add(onboardingStep2)
        onboardingList.add(onboardingStep3)

        return onboardingList
    }
}