package com.mforn.onboarding.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OnboardingStepView(
        val title: String,
        val subtitle: String,
        val imageRes: Int,
        val colorResStart: Int,
        val colorResEnd: Int
) : Parcelable
