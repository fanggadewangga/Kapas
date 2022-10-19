package com.puyo.kapas.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.puyo.kapas.feature_kapas.data.source.local.datastore.DataStoreUtil
import com.puyo.kapas.feature_kapas.data.source.local.datastore.KapasDataStore
import com.puyo.kapas.feature_kapas.data.source.remote.api.service.KapasApi
import com.puyo.kapas.feature_kapas.data.source.remote.firebase.FirebaseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore(
    name = DataStoreUtil.DATA_STORE_NAME
)

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    // Provide Repository
    @Provides
    @Singleton
    fun provideKapasApi(): KapasApi {
        return Retrofit.Builder()
            .baseUrl("https://kapas-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KapasApi::class.java)
    }

    // Firebase Service Provider
    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseService(
        firebaseAuth: FirebaseAuth,
        firebaseStorage: FirebaseStorage
    ) = FirebaseService(firebaseAuth, firebaseStorage)

    // Datastore provider
    @Provides
    @Singleton
    fun provideDatastore(@ApplicationContext context: Context) =
        KapasDataStore(context)
}