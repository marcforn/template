package com.mforn.onboarding.presentation.view.viewmodel

import com.mforn.common.presentation.coroutines.CoroutineDispatchers
import com.mforn.common.presentation.model.mapper.ViewMapper
import com.mforn.common.presentation.view.viewmodel.BaseViewModel
import com.mforn.common.presentation.view.viewmodel.BaseViewState
import com.mforn.onboarding.domain.interactor.OnBoardingInteractor
import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.presentation.model.OnboardingStepView
import timber.log.Timber
import javax.inject.Inject


class OnboardingViewModel(
    coroutineDispatchers: CoroutineDispatchers,
    private val mapper: ViewMapper<List<OnboardingStepView>, List<OnboardingStep>>,
    private val interactor: OnBoardingInteractor,
) : BaseViewModel<List<OnboardingStepView>>(coroutineDispatchers) {


    fun execute() {
        runTask(
            block = { mapper.mapToView(interactor.getOnBoardingCards()) },
            onSuccess = { updateState(BaseViewState.DataLoaded(it)) },
            onError = { Timber.e(it) }
        )
    }

}