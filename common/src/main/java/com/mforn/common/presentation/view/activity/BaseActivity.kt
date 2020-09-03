package com.mforn.common.presentation.view.activity

import android.os.Bundle
import com.mforn.common.presentation.view.viewmodel.BaseViewModel
import com.mforn.common.presentation.view.viewmodel.BaseViewState
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<S, VM : BaseViewModel<S>> : DaggerAppCompatActivity() {

    private lateinit var viewModel: VM


    abstract fun setupComponent()

    abstract val layout: Int

    abstract fun provideViewModel(): VM

    abstract fun updateUi(state: BaseViewState<S>)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupComponent()
        setContentView(layout)
        viewModel = provideViewModel()
        //        viewModel.state.observe(this::getLifecycle, ::updateUi)
    }

}