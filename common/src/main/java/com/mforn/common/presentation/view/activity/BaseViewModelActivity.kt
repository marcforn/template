package com.mforn.common.presentation.view.activity

import android.os.Bundle
import com.mforn.common.presentation.view.viewmodel.BaseViewModel
import com.mforn.common.presentation.view.viewmodel.BaseViewState

abstract class BaseViewModelActivity<S, VM : BaseViewModel<S>> : BaseActivity() {

    private lateinit var viewModel: VM


    abstract fun provideViewModel(): VM

    abstract fun updateUi(state: BaseViewState<S>)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
        viewModel.state.observe(this::getLifecycle, ::updateUi)
    }

}