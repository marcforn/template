package com.mforn.common.domain.repository

import androidx.annotation.BoolRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

interface ResourcesRepository {

    fun getString(@StringRes resourceId: Int): String

    fun getInt(@IntegerRes resourceId: Int): Int

    fun getBoolean(@BoolRes resourceId: Int): Boolean

}