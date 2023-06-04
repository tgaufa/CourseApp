package com.example.course.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicNameResourceId: Int,
    val topicNumberResourceId: Int,
    @DrawableRes val imageResourceId: Int

)
