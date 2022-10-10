package com.puyo.kapas.feature_kapas.data.source.local

import com.puyo.kapas.feature_kapas.data.source.local.database.entity.JobEntity
import com.puyo.kapas.feature_kapas.data.source.local.database.room.KapasDao
import com.puyo.kapas.feature_kapas.data.source.local.datastore.KapasDataStore
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val dao: KapasDao,
    private val dataStore: KapasDataStore
) {

    suspend fun savePrefIsVerified(isVerified: Boolean){
        dataStore.savePrefIsVerified(isVerified)
    }

    suspend fun savePrefUid(uid: String){
        dataStore.savePrefUid(uid)
    }

    fun readPrefIsVerified(): Flow<Boolean> = dataStore.readPrefIsVerified()

    fun readPrefUid(): Flow<String?> = dataStore.readPrefUid()

    suspend fun insertJob(job: JobEntity) = dao.insertJob(job)

    fun getBookmarkedJob() = dao.getJobs()
    suspend fun getJobById(jobId: String) = dao.getJobById(jobId)
    suspend fun deleteJob(job: JobEntity) = dao.deleteJob(job)

}