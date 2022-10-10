package com.puyo.kapas.feature_kapas.data.source.local.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object DataStoreUtil {
    const val DATA_STORE_NAME = "KAPAS_DATA_STORE"
    val IS_VERIFIED_PREF_KEY = booleanPreferencesKey("isVerified")
    val UID_PREF_KEY = stringPreferencesKey("uid")
}