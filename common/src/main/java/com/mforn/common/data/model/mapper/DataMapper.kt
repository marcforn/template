package com.mforn.common.data.model.mapper


interface DataMapper<out V, in D> {

    fun mapToDomain(data: D): V

}