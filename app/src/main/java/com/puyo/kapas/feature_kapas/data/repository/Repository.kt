package com.puyo.kapas.feature_kapas.data.repository

import android.net.Uri
import com.puyo.kapas.feature_kapas.data.source.local.LocalDataSource
import com.puyo.kapas.feature_kapas.data.source.local.database.entity.JobEntity
import com.puyo.kapas.feature_kapas.data.source.remote.RemoteDataSource
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobBody
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserBody

class Repository(
    private val localRepository: LocalDataSource,
    private val remoteRepository: RemoteDataSource
) {
    // User
    suspend fun signUpUser(email: String, password: String) = remoteRepository.signUpUser(email, password)
    fun signInUser(email: String, password: String) = remoteRepository.signInUser(email, password)
    suspend fun fetchUserDetail(uid: String) = remoteRepository.fetchUserDetail(uid).data
    suspend fun fetchLeaderboard() = remoteRepository.fetchLeaderboard().data
    suspend fun updateUserDetail(uid: String, body: UserBody) = remoteRepository.updateUserDetail(uid, body).data
    fun updateUserAvatar(uid: String, imageUri: Uri) = remoteRepository.updateUserAvatar(uid, imageUri)
    fun getCurrentUserId() = remoteRepository.getCurrentUserId()
    fun isLoggedIn() = remoteRepository.isLoggedIn()
    fun logOut() = remoteRepository.logOut()

    // Job
    suspend fun postJob(body: JobBody) = remoteRepository.postJob(body)
    suspend fun fetchJobs() = remoteRepository.fetchJobs().data
    suspend fun fetchJobDetail(jobId: String) = remoteRepository.fetchJobDetail(jobId)
    suspend fun fetchSearchJobs(query: String) = remoteRepository.fetchSearchJob(query)
    suspend fun updateJobDetail(jobId: String, body: JobBody) = remoteRepository.updateJobDetail(jobId, body)
    suspend fun updateJobImage(jobId: String, imageUri: Uri) = remoteRepository.updateJobImage(jobId, imageUri)
    suspend fun deleteJob(jobId: String) = remoteRepository.deleteJob(jobId)
    suspend fun insertBookmarkedJob(jobEntity: JobEntity) = localRepository.insertJob(jobEntity)
    suspend fun getBookmarkedJobDetail(jobId: String) = localRepository.getBookmarkedJobDetail(jobId)
    suspend fun deleteBookmarkedJob(jobEntity: JobEntity) = localRepository.deleteBookmarkedJob(jobEntity)
    fun getBookmarkedJobs() = localRepository.getBookmarkedJobs()

    // Preference
    suspend fun saveIsVerified(isVerified: Boolean) = localRepository.savePrefIsVerified(isVerified)
    suspend fun savePrefUid(uid: String) = localRepository.savePrefUid(uid)
    fun readPrefUid() = localRepository.readPrefUid()
    fun readIsVerified() = localRepository.readPrefIsVerified()
}