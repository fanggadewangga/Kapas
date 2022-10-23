package com.puyo.kapas.feature_kapas.data.source.remote.api.service

import com.puyo.kapas.feature_kapas.data.source.remote.api.response.BaseResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobBody
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobListResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.leaderboard.LeaderboardResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserBody
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserResponse
import retrofit2.http.*

interface KapasApi {

    // User
    @POST("/user")
    suspend fun postNewUser(
        @Body body: UserBody
    ): BaseResponse<String>

    @GET("/user/{uid}")
    suspend fun fetchUserDetail(
        @Path("uid") uid: String
    ): BaseResponse<UserResponse>

    @PUT("/user/{uid}")
    suspend fun updateUserDetail(
        @Path("uid") uid: String,
        @Body userBody: UserBody
    ): BaseResponse<String>

    @GET("/leaderboard")
        suspend fun fetchLeaderboard(): BaseResponse<List<LeaderboardResponse>>

    // Job
    @POST("/job")
    suspend fun postNewJob(
        @Body body: JobBody
    ): BaseResponse<String>

    @GET("/job")
    suspend fun fetchJobs(): BaseResponse<List<JobListResponse>>

    @GET("/job")
    suspend fun fetchSearchJob(
        @Query("q") query: String
    ): BaseResponse<List<JobListResponse>>

    @GET("/job/{jobId}")
    suspend fun fetchJobDetail(
        @Path("jobId") jobId: String
    ): BaseResponse<JobResponse>

    @DELETE("/job/{jobId}")
    suspend fun deleteJob(
        @Path("jobId") jobId: String
    ): BaseResponse<String>

    @PUT("/job/{jobId}")
    suspend fun updateJobDetail(
        @Path("jobId") jobId: String,
        @Body jobBody: JobBody
    ): BaseResponse<String>
}