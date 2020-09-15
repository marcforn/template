package com.mforn.onboarding.presentation.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mforn.onboarding.presentation.model.OnboardingStepView
import com.mforn.onboarding.presentation.view.fragment.OnboardingStepFragment

class OnboardingPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val data: List<OnboardingStepView>
) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int = data.size

    override fun createFragment(position: Int): Fragment = OnboardingStepFragment.newInstance(data[position])

}