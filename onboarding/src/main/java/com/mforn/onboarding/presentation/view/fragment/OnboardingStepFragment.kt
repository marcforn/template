package com.mforn.onboarding.presentation.view.fragment

import android.os.Bundle
import com.mforn.common.presentation.view.fragment.BaseFragment
import com.mforn.onboarding.R
import com.mforn.onboarding.presentation.model.OnboardingStepView


private const val ARGUMENT_STEP = "ARGUMENT_STEP"


class OnboardingStepFragment : BaseFragment() {

    companion object {
        fun newInstance(step: OnboardingStepView) =
            OnboardingStepFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARGUMENT_STEP, step)
                }
            }
    }

    override val layout: Int = R.layout.fragment_onboarding_step

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val step = arguments?.getParcelable<OnboardingStepView>(ARGUMENT_STEP)

        step?.let {
//            iv_onboarding.setImageResource(it.imageRes)
//            tv_title.text = it.title
//            tv_subtitle.text = it.subtitle
        }
    }

}
