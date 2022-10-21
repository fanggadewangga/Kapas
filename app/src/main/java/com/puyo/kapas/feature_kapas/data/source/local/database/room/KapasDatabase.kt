package com.puyo.kapas.feature_kapas.data.source.local.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.puyo.kapas.feature_kapas.data.source.local.database.entity.JobEntity

@Database(
    entities = [JobEntity::class],
    version = 1
)
abstract class KapasDatabase: RoomDatabase() {
    abstract fun jobDao(): JobDao
}