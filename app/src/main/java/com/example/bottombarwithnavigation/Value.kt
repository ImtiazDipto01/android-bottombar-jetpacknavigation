package com.example.bottombarwithnavigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Value(val recipient : String, val money : String) : Parcelable

