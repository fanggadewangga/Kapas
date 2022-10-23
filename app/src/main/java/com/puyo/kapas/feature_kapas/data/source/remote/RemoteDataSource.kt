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
import com.puyo.kapas.feature_kapas.data.source.remote.firebase.FirebaseService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    ): String {
        var uid = ""
        CoroutineScope(Dispatchers.IO).launch {
            uid = firebaseService.createUserWithEmailAndPassword(email, password)
        }
        if (uid != "") {
            val body = UserBody(
                uid = uid,
                email = email
            )
            apiService.postNewUser(body)
        }
        return if (uid != "") uid
        else ""
    }

    fun signInUser(email: String, password: String): String {
        return firebaseService.signInWithEmailAndPassword(email, password)
    }

    fun updateUserAvatar(uid: String, image: Uri): String {
        val imageUri = firebaseService.uploadUserAvatar(uid, image)
        /*TODO*/
        return ""
    }

    suspend fun fetchUserDetail(uid: String): BaseResponse<UserResponse> =
        apiService.fetchUserDetail(uid)

    suspend fun fetchLeaderboard(): BaseResponse<List<LeaderboardResponse>> =
        apiService.fetchLeaderboard()

    suspend fun updateUserDetail(uid: String, body: UserBody): BaseResponse<String> =
        apiService.updateUserDetail(uid, body)

    suspend fun postJob(body: JobBody): BaseResponse<String> = apiService.postNewJob(body)

    suspend fun fetchJobs(): BaseResponse<List<JobListResponse>> = apiService.fetchJobs()

    suspend fun fetchSearchJob(query: String): BaseResponse<List<JobListResponse>> =
        apiService.fetchSearchJob(query)

    suspend fun fetchJobDetail(jobId: String): BaseResponse<JobResponse> =
        apiService.fetchJobDetail(jobId)

    suspend fun updateJobDetail(jobId: String, body: JobBody): BaseResponse<String> =
        apiService.updateJobDetail(jobId, body)

    suspend fun updateJobImage(jobId: String, imageUri: Uri): String? {
        val imageUrl = firebaseService.uploadJobImage(jobId, imageUri)
        val job = apiService.fetchJobDetail(jobId).data
        job?.imageUrl = imageUrl

        return job?.imageUrl
    }

    suspend fun deleteJob(jobId: String): BaseResponse<String> = apiService.deleteJob(jobId)
}

