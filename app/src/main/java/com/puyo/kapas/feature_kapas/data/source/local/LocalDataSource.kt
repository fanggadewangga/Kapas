package com.puyo.kapas.feature_kapas.data.source.local

import com.puyo.kapas.feature_kapas.data.source.local.database.entity.JobEntity
import com.puyo.kapas.feature_kapas.data.source.local.database.room.JobDao
import com.puyo.kapas.feature_kapas.data.source.local.datastore.KapasDataStore

class LocalDataSource(
    private val dao: JobDao,
    private val dataStore: KapasDataStore
) {
    suspend fun savePrefIsVerified(isVerified: Boolean){
        dataStore.savePrefIsVerified(isVerified)
    }

    suspend fun savePrefUid(uid: String){
        dataStore.savePrefUid(uid)
    }

    fun readPrefIsVerified() = dataStore.readPrefIsVerified()

    fun readPrefUid() = dataStore.readPrefUid()

    suspend fun insertJob(job: JobEntity) = dao.insertJob(job)

    fun getBookmarkedJobs(): List<JobEntity?> = dao.getJobs()
    suspend fun getBookmarkedJobDetail(jobId: String): JobEntity? = dao.getJobById(jobId)
    suspend fun deleteBookmarkedJob(job: JobEntity) = dao.deleteJob(job)
}