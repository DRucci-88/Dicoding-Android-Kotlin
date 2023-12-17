package com.example.submission_02

import android.content.res.TypedArray
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book (
    val title: String,
    val description: String,
    val image: Int
): Parcelable