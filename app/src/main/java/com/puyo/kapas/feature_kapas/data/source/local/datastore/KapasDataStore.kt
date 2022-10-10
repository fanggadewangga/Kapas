package com.puyo.kapas.feature_kapas.data.source.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class KapasDataStore(private val context: Context) {

    private val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore(
        name = DataStoreUtil.DATA_STORE_NAME
    )

    suspend fun savePrefIsVerified(isVerified: Boolean){
        context.userPreferenceDataStore.edit {
            it[DataStoreUtil.IS_VERIFIED_PREF_KEY] = isVerified
        }
    }

    suspend fun savePrefUid(uid: String){
        context.userPreferenceDataStore.edit {
            it[DataStoreUtil.UID_PREF_KEY] = uid
        }
    }

    fun readPrefIsVerified(): Flow<Boolean> = context.userPreferenceDataStore.data
        .map {
            it[DataStoreUtil.IS_VERIFIED_PREF_KEY] ?: false
        }

    fun readPrefUid(): Flow<String?> = context.userPreferenceDataStore.data
        .map {
            it[DataStoreUtil.UID_PREF_KEY]
        }
}