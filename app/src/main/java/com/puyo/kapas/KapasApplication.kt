package com.puyo.kapas

import android.app.Application
import com.puyo.kapas.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class KapasApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KapasApplication)
            modules(
                databaseModule,
                datastoreModule,
                networkModule,
                firebaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}