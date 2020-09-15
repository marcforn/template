package com.mforn.common.presentation.view.activity

import android.os.Bundle
import com.mforn.common.presentation.view.viewmodel.BaseViewModel
import com.mforn.common.presentation.view.viewmodel.BaseViewState

abstract class BaseViewModelActivity<S, VM : BaseViewModel<S>> : BaseActivity() {

    abstract fun getViewModelX(): VM

    abstract fun updateUi(state: BaseViewState<S>)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModelX().state.observe(this::getLifecycle, ::updateUi)
    }

}