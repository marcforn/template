package com.mforn.onboarding.configuration

import android.app.Application
import android.content.res.Resources
import com.mforn.common.configuration.ActivityModule
import com.mforn.common.data.resources.repository.ResourcesRepositoryImpl
import com.mforn.common.domain.repository.ResourcesRepository
import com.mforn.common.presentation.coroutines.CoroutineDispatchers
import com.mforn.common.presentation.model.mapper.ViewMapper
import com.mforn.common.presentation.view.activity.BaseActivity
import com.mforn.onboarding.data.repository.OnBoardingRepositoryImpl
import com.mforn.onboarding.domain.interactor.OnBoardingInteractor
import com.mforn.onboarding.domain.interactor.OnBoardingInteractorImpl
import com.mforn.onboarding.domain.model.OnboardingStep
import com.mforn.onboarding.domain.repository.OnBoardingRepository
import com.mforn.onboarding.presentation.model.OnboardingStepView
import com.mforn.onboarding.presentation.model.mapper.OnboardingMapper
import com.mforn.onboarding.presentation.view.activity.OnboardingActivity
import com.mforn.onboarding.presentation.view.viewmodel.OnboardingViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class OnBoardingActivityModule {

    @Binds
    abstract fun bindOnBoardingActivity(activity: OnboardingActivity): BaseActivity

}

@Module(includes = [(ActivityModule::class), (OnBoardingActivityModule::class)])
class OnBoardingModule {

    @Provides
    @Singleton
    internal fun provideResources(application: Application): Resources {
        return application.resources // TODO mforn: 14/09/20 move to common
    }

    @Provides
    @Singleton
    internal fun provideResourcesRepository(resources: Resources): ResourcesRepository {
        return ResourcesRepositoryImpl(resources) // TODO mforn: 14/09/20 move to common
    }

    @Provides
    internal fun provideOnBoardingRepository(resourcesRepository: ResourcesRepository): OnBoardingRepository {
        return OnBoardingRepositoryImpl(resourcesRepository)
    }

    @Provides
    internal fun provideOnboardingInteractor(onBoardingRepository: OnBoardingRepository): OnBoardingInteractor {
        return OnBoardingInteractorImpl(onBoardingRepository)
    }

    @Provides
    internal fun provideOnboardingMapper(): ViewMapper<List<OnboardingStepView>, List<OnboardingStep>> {
        return OnboardingMapper()
    }

    @Provides
    internal fun provideOnBoardingViewModel(
        coroutineDispatchers: CoroutineDispatchers,
        mapper: ViewMapper<List<OnboardingStepView>, List<OnboardingStep>>,
        interactor: OnBoardingInteractor
    ): OnboardingViewModel {

        return OnboardingViewModel(
            coroutineDispatchers,
            mapper,
            interactor
        )
    }
}