package com.puyo.kapas.feature_kapas.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "job")
data class Job(
   val title: String,
   val posterId: String?,
   val posterName: String?,
   val posterAvatarUrl: String?,
   val location: String,
   val wage: Double,
   val address: String,
   val description: String,
   val imageUrl: String,
   val latitude: Double,
   val longitude: Double,
   @PrimaryKey val jobId: String? = null
)
