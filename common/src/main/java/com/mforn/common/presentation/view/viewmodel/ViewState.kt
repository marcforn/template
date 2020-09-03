package com.mforn.common.presentation.view.viewmodel

sealed class BaseViewState<out T> {
    object Loading : BaseViewState<Nothing>()
    data class DataLoaded<T>(val data: T) : BaseViewState<T>()
    data class Error<T>(val exception: T) : BaseViewState<T>()
}
