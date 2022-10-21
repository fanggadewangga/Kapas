package com.puyo.kapas.feature_kapas.data.source.local.database.room

import androidx.room.*
import com.puyo.kapas.feature_kapas.data.source.local.database.entity.JobEntity

@Dao
interface JobDao {
    @Query("SELECT * FROM job_table")
    fun getJobs(): List<JobEntity>

    @Query("SELECT * FROM job_table WHERE job_id = :jobId")
    suspend fun getJobById(jobId: String): JobEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJob(job: JobEntity)

    @Delete
    suspend fun deleteJob(job: JobEntity)
}