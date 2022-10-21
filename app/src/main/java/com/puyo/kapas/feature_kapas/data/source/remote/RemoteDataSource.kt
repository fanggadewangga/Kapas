package com.puyo.kapas.feature_kapas.data.source.remote

import android.net.Uri
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobBody
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobListResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.leaderboard.LeaderboardResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserBody
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.service.KapasApi
import com.puyo.kapas.feature_kapas.data.source.remote.firebase.FirebaseService
import com.puyo.kapas.feature_kapas.data.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(
    private val apiService: KapasApi,
    private val firebaseService: FirebaseService
) {
    fun isLoggedIn() = firebaseService.isLoggedIn()

    fun getCurrentUserId() = firebaseService.getCurrentUserId()

    fun logOut() = firebaseService.logout()

    suspend fun signUpUser(
        email: String,
        password: String,
        body: UserBody,
    ): Flow<Resource<UserResponse?>> = flow {
        firebaseService.createUserWithEmailAndPassword(email, password).collect { response ->
            when (response) {
                is Resource.Success -> {
                    body.uid = response.data.toString()
                    body.email = email
                    try {
                        apiService.postNewUser(body).data
                        val user = apiService.fetchUserDetail(response.data.toString()).data
                        emit(Resource.Success(user))
                    } catch (e: Exception) {
                        emit(Resource.Error(e.message.toString()))
                    }
                }
                is Resource.Error -> emit(Resource.Error(response.message.toString()))
                is Resource.Empty -> emit(Resource.Empty())
                else -> {
                    emit(Resource.Loading())
                }
            }
        }
    }

    suspend fun signInUser(email: String, password: String): Flow<Resource<UserResponse?>> =
        flow {
            firebaseService.signInWithEmailAndPassword(email, password).collect { response ->
                when (response) {
                    is Resource.Success -> {
                        try {
                            val userResponse =
                                apiService.fetchUserDetail(response.data.toString()).data
                            emit(Resource.Success(userResponse))
                        } catch (e: Exception) {
                            emit(Resource.Error(e.message.toString()))
                        }
                    }
                    is Resource.Error -> emit(Resource.Error(response.message.toString()))
                    is Resource.Empty -> emit(Resource.Empty())
                    else -> {
                        emit(Resource.Loading())
                    }
                }
            }
        }

    suspend fun updateUserAvatar(uid: String, imageUri: Uri): Flow<Resource<UserResponse>> =
        flow {
            firebaseService.uploadUserAvatar(uid, imageUri).collect { response ->
                when (response) {
                    is Resource.Success -> {
                        try {
                            val user = apiService.fetchUserDetail(uid).data
                            user!!.avatarUrl = response.data
                            emit(Resource.Success(user))
                        } catch (e: Exception) {
                            emit(Resource.Error(e.message.toString()))
                        }
                    }
                    is Resource.Error -> emit(Resource.Error(response.message.toString()))
                    is Resource.Empty -> emit(Resource.Empty())
                    else -> {
                        emit(Resource.Loading())
                    }
                }
            }
        }

    suspend fun fetchUserDetail(uid: String): Flow<Resource<UserResponse?>> = flow {
        apiService.fetchUserDetail(uid)
    }

    suspend fun fetchLeaderboard(): Flow<Resource<List<LeaderboardResponse>>> = flow {
        apiService.fetchLeaderboard()
    }

    suspend fun updateUserDetail(uid: String, body: UserBody): Flow<Resource<UserResponse>> = flow {
        apiService.updateUserDetail(uid, body)
    }

    suspend fun postJob(body: JobBody): Flow<Resource<JobResponse>> = flow {
        apiService.postNewJob(body)
    }

    suspend fun fetchJobs(): Flow<Resource<List<JobListResponse>>> = flow {
        apiService.fetchJobs()
    }

    suspend fun fetchSearchJob(query: String): Flow<Resource<List<JobResponse>>> = flow {
        apiService.fetchSearchJob(query)
    }

    suspend fun fetchJobDetail(jobId: String): Flow<Resource<JobResponse>> = flow {
        apiService.fetchJobDetail(jobId)
    }

    suspend fun updateJobDetail(jobId: String, body: JobBody): Flow<Resource<JobResponse>> = flow {
        apiService.updateJobDetail(jobId, body)
    }

    suspend fun updateJobImage(jobId: String, imageUri: Uri): Flow<Resource<JobResponse>> =
        flow {
            firebaseService.uploadJobImage(jobId, imageUri).collect { response ->
                when (response) {
                    is Resource.Success -> {
                        try {
                            val job = apiService.fetchJobDetail(jobId).data
                            job!!.imageUrl = response.data.toString()
                            emit(Resource.Success(job))
                        } catch (e: Exception) {
                            emit(Resource.Error(e.message.toString()))
                        }
                    }
                    is Resource.Error -> emit(Resource.Error(response.message.toString()))
                    is Resource.Empty -> emit(Resource.Empty())
                    else -> {
                        emit(Resource.Loading())
                    }
                }
            }
        }

    suspend fun deleteJob(jobId: String): Flow<Resource<JobResponse>> = flow {
        apiService.deleteJob(jobId)
    }
}