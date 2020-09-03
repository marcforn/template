package com.mforn.common.presentation.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mforn.common.domain.exception.CustomException
import com.mforn.common.presentation.coroutines.CoroutineDispatchers
import com.mforn.common.presentation.coroutines.launchTask
import kotlinx.coroutines.Job


abstract class BaseViewModel<T>(
    private val coroutineDispatchers: CoroutineDispatchers,
) : ViewModel() {

    private lateinit var job: Job


    val state: MutableLiveData<BaseViewState<T>> by lazy { MutableLiveData() }

    protected fun updateState(newState: BaseViewState<T>) {
        state.value = newState
    }

    protected fun runTask(block: suspend (() -> T), onSuccess: ((T) -> Unit)? = null, onError: ((CustomException) -> Unit)? = null) {
        updateState(BaseViewState.Loading)

        job = launchTask(
            block = block,
            onSuccess = onSuccess,
            onError = onError,
            dispatchers = coroutineDispatchers
        )
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}