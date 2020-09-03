package com.mforn.onboarding.presentation.view.viewmodel

import android.util.Log
import com.mforn.common.presentation.coroutines.CoroutineDispatchers
import com.mforn.common.presentation.model.mapper.ViewMapper
import com.mforn.common.presentation.view.viewmodel.BaseViewModel
import com.mforn.common.presentation.view.viewmodel.BaseViewState
import com.mforn.onboarding.domain.interactor.OnBoardingInteractor
import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.presentation.model.OnboardingStepView


private val TAG = OnboardingViewModel::class.java.name


class OnboardingViewModel(
    coroutineDispatchers: CoroutineDispatchers,
    private val mapper: ViewMapper<List<OnboardingStepView>, List<OnboardingStep>>,
    private val interactor: OnBoardingInteractor,
) : BaseViewModel<List<OnboardingStepView>>(coroutineDispatchers) {

    fun execute() {
        runTask(
            block = { mapper.mapToView(interactor.getOnBoardingCards()) },
            onSuccess = { updateState(BaseViewState.DataLoaded(it)) },
            onError = { Log.e(TAG, it.message, it) }
        )
    }

}