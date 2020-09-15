package com.mforn.onboarding.presentation.view.activity

import android.os.Bundle
import com.mforn.common.presentation.view.activity.BaseViewModelActivity
import com.mforn.common.presentation.view.viewmodel.BaseViewState
import com.mforn.common.presentation.view.viewmodel.BaseViewState.*
import com.mforn.onboarding.R
import com.mforn.onboarding.presentation.model.OnboardingStepView
import com.mforn.onboarding.presentation.view.adapter.OnboardingPagerAdapter
import com.mforn.onboarding.presentation.view.viewmodel.OnboardingViewModel
import kotlinx.android.synthetic.main.activity_onboarding.*
import org.koin.android.viewmodel.ext.android.getViewModel


class OnboardingActivity : BaseViewModelActivity<List<OnboardingStepView>, OnboardingViewModel>() {

    private lateinit var adapter : OnboardingPagerAdapter


    override val layout = R.layout.activity_onboarding

    override fun getViewModelX(): OnboardingViewModel = getViewModel() // TODO mforn: 15/09/20 review getViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModelX().getData()
        iv_close.setOnClickListener {
            finish()
        }
    }

    override fun updateUi(state: BaseViewState<List<OnboardingStepView>>) {
        when (state) {
            is DataLoaded -> onDataLoaded(state.data)
        }
    }

    private fun onDataLoaded(data: List<OnboardingStepView>) {
        adapter = OnboardingPagerAdapter(supportFragmentManager, lifecycle, data)
        view_pager.adapter = adapter
    }

}
