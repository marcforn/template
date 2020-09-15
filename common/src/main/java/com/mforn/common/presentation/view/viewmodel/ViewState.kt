package com.mforn.common.presentation.view.viewmodel

import com.mforn.common.domain.exception.CustomErrorType

sealed class BaseViewState<out T> {
    object Loading : BaseViewState<Nothing>()
    data class DataLoaded<T>(val data: T) : BaseViewState<T>()
    data class Error<T>(val exception: CustomErrorType) : BaseViewState<T>()
}
