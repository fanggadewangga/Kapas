package com.puyo.kapas.feature_kapas.domain.model.job

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
   val job_id: String = "",
   val title: String = "",
   val posterId: String? = "",
   val posterName: String? = "",
   val posterAvatarUrl: String? = "",
   val location: String = "",
   val wage: Double = 0.0,
   val address: String = "",
   val description: String = "",
   val image_url: String = "",
   val latitude: Double = 0.0,
   val longitude: Double = 0.0
): Parcelable
