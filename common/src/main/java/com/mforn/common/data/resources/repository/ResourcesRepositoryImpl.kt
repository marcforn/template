package com.mforn.common.data.resources.repository

import android.content.res.Resources
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import com.mforn.common.domain.repository.ResourcesRepository


class ResourcesRepositoryImpl(private val resources: Resources) : ResourcesRepository {

    override fun getString(@StringRes resourceId: Int): String = resources.getString(resourceId)

    override fun getInt(@IntegerRes resourceId: Int): Int = resources.getInteger(resourceId)

    override fun getBoolean(resourceId: Int): Boolean = resources.getBoolean(resourceId)

}
