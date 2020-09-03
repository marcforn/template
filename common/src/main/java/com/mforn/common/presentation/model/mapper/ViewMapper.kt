package com.mforn.common.presentation.model.mapper


interface ViewMapper<out V, in D> {

    fun mapToView(data: D): V

}