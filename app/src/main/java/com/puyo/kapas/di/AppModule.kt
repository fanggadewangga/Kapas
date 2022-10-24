package com.puyo.kapas.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.puyo.kapas.feature_kapas.data.repository.Repository
import com.puyo.kapas.feature_kapas.data.source.local.LocalDataSource
import com.puyo.kapas.feature_kapas.data.source.local.database.room.KapasDatabase
import com.puyo.kapas.feature_kapas.data.source.local.datastore.DataStoreUtil
import com.puyo.kapas.feature_kapas.data.source.local.datastore.KapasDataStore
import com.puyo.kapas.feature_kapas.data.source.remote.RemoteDataSource
import com.puyo.kapas.feature_kapas.data.source.remote.api.service.KapasApi
import com.puyo.kapas.feature_kapas.data.source.remote.firebase.FirebaseService
import com.puyo.kapas.feature_kapas.presentation.auth.LoginViewModel
import com.puyo.kapas.feature_kapas.presentation.auth.SignupViewModel
import com.puyo.kapas.feature_kapas.presentation.home.HomeViewModel
import com.puyo.kapas.feature_kapas.presentation.job_detail.JobDetailViewModel
import com.puyo.kapas.feature_kapas.presentation.jobs.JobsViewModel
import com.puyo.kapas.feature_kapas.presentation.leaderboard.LeaderboardViewModel
import com.puyo.kapas.feature_kapas.presentation.post_job.JobPaymentViewModel
import com.puyo.kapas.feature_kapas.presentation.post_job.PostJobViewModel
import com.puyo.kapas.feature_kapas.presentation.settings.email.ChangeEmailViewModel
import com.puyo.kapas.feature_kapas.presentation.settings.number.ChangeNumberViewModel
import com.puyo.kapas.feature_kapas.presentation.settings.password.ChangePasswordViewModel
import com.puyo.kapas.feature_kapas.presentation.verification.identity_verification.IdentityVerificationViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore(
    name = DataStoreUtil.DATA_STORE_NAME
)

val databaseModule = module {
    factory {
        get<KapasDatabase>().jobDao()
    }
    single {
        Room.databaseBuilder(
            androidContext(),
            KapasDatabase::class.java,
            "kapas_db"
        ).build()
    }
}

val datastoreModule = module {
    single {
        KapasDataStore(androidApplication())
    }
}

val networkModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://kapas-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(KapasApi::class.java)
    }
}

val firebaseModule = module {
    single {
        FirebaseService()
    }
}

val repositoryModule = module {
    single { LocalDataSource(get(), get()) }
    single { RemoteDataSource(get(), get()) }
    single { Repository(get(), get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { SignupViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { JobsViewModel(get()) }
    viewModel { JobDetailViewModel(get()) }
    viewModel { LeaderboardViewModel(get()) }
    viewModel { PostJobViewModel(get()) }
    viewModel { JobPaymentViewModel(get()) }
    viewModel { ChangeEmailViewModel(get()) }
    viewModel { ChangeNumberViewModel(get()) }
    viewModel { ChangePasswordViewModel(get()) }
    viewModel { IdentityVerificationViewModel(get()) }
}