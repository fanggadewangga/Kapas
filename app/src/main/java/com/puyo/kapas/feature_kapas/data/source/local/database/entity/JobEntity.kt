package com.puyo.kapas.feature_kapas.data.source.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "job_table")
data class JobEntity(

    @PrimaryKey
    @ColumnInfo(name = "job_id")
    val jobId: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "poster_id")
    val posterId: String?,

    @ColumnInfo(name = "poster_name")
    val posterName: String?,

    @ColumnInfo(name = "poster_avatar")
    val posterAvatarUrl: String?,

    @ColumnInfo(name = "location")
    val location: String,

    @ColumnInfo(name = "wage")
    val wage: Double,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

    @ColumnInfo(name = "latitude")
    val latitude: Double,

    @ColumnInfo(name = "longitude")
    val longitude: Double
)
