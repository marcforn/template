package com.mforn.onboarding.presentation.view.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mforn.common.presentation.view.activity.BaseViewModelActivity
import com.mforn.common.presentation.view.viewmodel.BaseViewState
import com.mforn.onboarding.R
import com.mforn.onboarding.presentation.model.OnboardingStepView
import com.mforn.onboarding.presentation.view.viewmodel.OnboardingViewModel
import kotlinx.android.synthetic.main.activity_onboarding.*
import org.koin.android.viewmodel.ext.android.viewModel


class OnboardingActivity : BaseViewModelActivity<List<OnboardingStepView>, OnboardingViewModel>() {

    val onboardingViewModel : OnboardingViewModel by viewModel()

    override val layout = R.layout.activity_onboarding

    override fun provideViewModel() = onboardingViewModel // TODO mforn: 9/09/20 review deprecation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onboardingViewModel.execute()
    }

    override fun updateUi(state: BaseViewState<List<OnboardingStepView>>) {
        when (state) {
            is BaseViewState.Loading -> onboarding_text.text = "Loading"
            is BaseViewState.DataLoaded -> onboarding_text.text = "Data Loaded"
        }
    }

}
