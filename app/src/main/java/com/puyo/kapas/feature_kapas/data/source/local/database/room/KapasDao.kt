package com.puyo.kapas.feature_kapas.data.source.local.database.room

import androidx.room.*
import com.puyo.kapas.feature_kapas.data.source.local.database.entity.JobEntity
import com.puyo.kapas.feature_kapas.domain.model.job.Job
import kotlinx.coroutines.flow.Flow

@Dao
interface KapasDao {
    @Query("SELECT * FROM job_table")
    fun getJobs(): Flow<List<Job>>

    @Query("SELECT * FROM job_table WHERE job_id = :jobId")
    suspend fun getJobById(jobId: String): Job?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJob(job: JobEntity)

    @Delete
    suspend fun deleteJob(job: JobEntity)
}