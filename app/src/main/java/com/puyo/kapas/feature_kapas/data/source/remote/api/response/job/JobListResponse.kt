package com.puyo.kapas.feature_kapas.data.source.remote.api.response.job

import com.google.gson.annotations.SerializedName

data class JobListResponse(
    @field:SerializedName("job_id")
    val jobId: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("description")
    val description: String
)