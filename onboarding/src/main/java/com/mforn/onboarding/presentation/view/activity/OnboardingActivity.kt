package com.mforn.onboarding.presentation.view.activity

import android.animation.ArgbEvaluator
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.mforn.common.presentation.view.activity.BaseActivity
import com.mforn.common.presentation.view.viewmodel.BaseViewState
import com.mforn.onboarding.R
import com.mforn.onboarding.presentation.model.OnboardingStepView
import com.mforn.onboarding.presentation.view.viewmodel.OnboardingViewModel
import kotlinx.android.synthetic.main.activity_onboarding.*
import java.util.*
import javax.inject.Inject


//class OnboardingActivity : BaseActivity<List<OnboardingStepView>, OnboardingViewModel>(),
//        ViewPager.OnPageChangeListener {
//
//    override val layout = R.layout.activity_onboarding
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun setupComponent() {
//        DaggerOnboardingComponent.builder()
//                .applicationComponent(applicationComponent)
//                .activityModule(activityModule)
//                .onboardingModule(OnboardingModule())
//                .build()
//                .inject(this)
//    }
//
//    private val factory = object : ViewModelProvider.Factory {
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            return OnboardingViewModel(interactor, mapper, ZinioCoroutineDispatchers()) as T
//        }
//    }
//
//    override fun provideViewModel() = ViewModelProviders.of(this, factory)[OnboardingViewModel::class.java]
//
//
//    override fun updateUi(state: BaseViewState<List<OnboardingStepView>>) {
//        when (state) {
//            is BaseViewState.Loading -> onboarding_text.text = "Loading"
//            is BaseViewState.DataLoaded -> onboarding_text.text = "Data Loaded"
//        }
//    }
//
//
//}
