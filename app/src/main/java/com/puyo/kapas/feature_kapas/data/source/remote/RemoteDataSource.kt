package com.puyo.kapas.feature_kapas.data.source.remote

import android.net.Uri
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.BaseResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobBody
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobListResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.leaderboard.LeaderboardResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserBody
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.service.KapasApi
import com.puyo.kapas.feature_kapas.data.source.remote.firebase.FirebaseResponse
import com.puyo.kapas.feature_kapas.data.source.remote.firebase.FirebaseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(
    private val apiService: KapasApi,
    private val firebaseService: FirebaseService,
) {

    fun isLoggedIn() = firebaseService.isLoggedIn()

    fun getCurrentUserId() = firebaseService.getCurrentUserId()

    fun logOut() = firebaseService.logout()

    suspend fun signUpUser(
        email: String,
        password: String,
        body: UserBody,
    ): Flow<RemoteResponse<UserResponse?>> = flow {
        firebaseService.createUserWithEmailAndPassword(email, password).collect { response ->
            when (response) {
                is FirebaseResponse.Success -> {
                    body.uid = response.data
                    body.email = email
                    try {
                        apiService.postNewUser(body).data
                        val user = apiService.fetchUserDetail(response.data).data
                        emit(RemoteResponse.Success(user))
                    } catch (e: Exception) {
                        emit(RemoteResponse.Error(e.message.toString()))
                    }
                }
                is FirebaseResponse.Error -> emit(RemoteResponse.Error(response.errorMessage))
                is FirebaseResponse.Empty -> emit(RemoteResponse.Empty())
            }
        }
    }.flowOn(Dispatchers.IO)

    suspend fun signInUser(email: String, password: String): Flow<RemoteResponse<UserResponse?>> =
        flow {
            firebaseService.signInWithEmailAndPassword(email, password).collect { response ->
                when (response) {
                    is FirebaseResponse.Success -> {
                        try {
                            val userResponse = apiService.fetchUserDetail(response.data).data
                            emit(RemoteResponse.Success(userResponse))
                        } catch (e: Exception) {
                            emit(RemoteResponse.Error(e.message.toString()))
                        }
                    }
                    is FirebaseResponse.Error -> emit(RemoteResponse.Error(response.errorMessage))
                    is FirebaseResponse.Empty -> emit(RemoteResponse.Empty())
                }
            }
        }

    suspend fun updateUserAvatar(uid: String, imageUri: Uri): Flow<RemoteResponse<UserResponse>> =
        flow {
            firebaseService.uploadUserAvatar(uid, imageUri).collect { response ->
                when (response) {
                    is FirebaseResponse.Success -> {
                        try {
                            val user = apiService.fetchUserDetail(uid).data
                            user!!.avatarUrl = response.data
                            emit(RemoteResponse.Success(user))
                        } catch (e: Exception) {
                            emit(RemoteResponse.Error(e.message.toString()))
                        }
                    }
                    is FirebaseResponse.Error -> emit(RemoteResponse.Error(response.errorMessage))
                    is FirebaseResponse.Empty -> emit(RemoteResponse.Empty())
                }
            }
        }

    suspend fun fetchUserDetail(uid: String) =
        object : BaseRemoteResponse<UserResponse>() {
            override suspend fun call(): BaseResponse<UserResponse> {
                return apiService.fetchUserDetail(uid)
            }
        }.asFlow()

    suspend fun fetchLeaderboard() =
        object : BaseRemoteResponse<List<LeaderboardResponse>>() {
            override suspend fun call(): BaseResponse<List<LeaderboardResponse>> {
                return apiService.fetchLeaderboard()
            }
        }.asFlow()

    suspend fun updateUserDetail(uid: String, body: UserBody) =
        object : BaseRemoteResponse<UserResponse>() {
            override suspend fun call(): BaseResponse<UserResponse> {
                return apiService.updateUserDetail(uid, body)
            }
        }.asFlow()

    suspend fun postJob(body: JobBody) =
        object : BaseRemoteResponse<String>() {
            override suspend fun call(): BaseResponse<String> {
                return apiService.postNewJob(body)
            }
        }.asFlow()

    suspend fun fetchJobs() =
        object : BaseRemoteResponse<List<JobListResponse>>() {
            override suspend fun call(): BaseResponse<List<JobListResponse>> {
                return apiService.fetchJobs()
            }
        }.asFlow()

    suspend fun fetchSearchJob(query: String) =
        object : BaseRemoteResponse<List<JobListResponse>>() {
            override suspend fun call(): BaseResponse<List<JobListResponse>> {
                return apiService.fetchSearchJob(query)
            }
        }.asFlow()

    suspend fun fetchJobDetail(jobId: String) =
        object : BaseRemoteResponse<JobResponse>() {
            override suspend fun call(): BaseResponse<JobResponse> {
                return apiService.fetchJobDetail(jobId)
            }
        }.asFlow()

    suspend fun updateJobDetail(jobId: String, body: JobBody) =
        object : BaseRemoteResponse<JobResponse>() {
            override suspend fun call(): BaseResponse<JobResponse> {
                return apiService.updateJobDetail(jobId, body)
            }
        }.asFlow()

    suspend fun updateJobImage(jobId: String, imageUri: Uri): Flow<RemoteResponse<JobResponse>> =
        flow {
            firebaseService.uploadJobImage(jobId, imageUri).collect { response ->
                when (response) {
                    is FirebaseResponse.Success -> {
                        try {
                            val job = apiService.fetchJobDetail(jobId).data
                            job!!.imageUrl = response.data
                            emit(RemoteResponse.Success(job))
                        } catch (e: Exception) {
                            emit(RemoteResponse.Error(e.message.toString()))
                        }
                    }
                    is FirebaseResponse.Error -> emit(RemoteResponse.Error(response.errorMessage))
                    is FirebaseResponse.Empty -> emit(RemoteResponse.Empty())
                }
            }
        }

    suspend fun deleteJob(jobId: String) =
        object : BaseRemoteResponse<String>() {
            override suspend fun call(): BaseResponse<String> {
                return apiService.deleteJob(jobId)
            }
        }.asFlow()
}