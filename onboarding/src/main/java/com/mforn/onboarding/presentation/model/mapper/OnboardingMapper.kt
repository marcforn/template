package com.mforn.onboarding.presentation.model.mapper

import com.mforn.common.presentation.model.mapper.ViewMapper
import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.presentation.model.OnboardingStepView


class OnboardingMapper : ViewMapper<List<OnboardingStepView>, List<OnboardingStep>> {

    override fun mapToView(data: List<OnboardingStep>): List<OnboardingStepView> {
        val modelList = mutableListOf<OnboardingStepView>()
        for (step in data) {
            modelList.add(mapToView(step))
        }
        return modelList
    }

    private fun mapToView(onboardingStep: OnboardingStep): OnboardingStepView {
        return OnboardingStepView(
            onboardingStep.title,
            onboardingStep.subtitle,
            onboardingStep.imageRes,
            onboardingStep.colorResStart,
            onboardingStep.colorResEnd
        )
    }

}

