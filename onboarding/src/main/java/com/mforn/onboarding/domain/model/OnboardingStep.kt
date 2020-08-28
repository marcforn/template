package com.mforn.onboarding.domain.model

data class OnboardingStep(
        val title: String,
        val subtitle: String,
        val imageRes: Int,
        val colorResStart: Int,
        val colorResEnd: Int
)
