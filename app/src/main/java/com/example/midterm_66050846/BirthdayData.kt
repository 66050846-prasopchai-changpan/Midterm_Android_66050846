package com.example.midterm_66050846

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BirthdayData(
    val name: String,
    val date: String,
    val fromName: String
) : Parcelable

