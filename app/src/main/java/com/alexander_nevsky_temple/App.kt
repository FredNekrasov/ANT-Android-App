package com.alexander_nevsky_temple

import android.app.Application
import com.alexander_nevsky_temple.di.data.repositoryModule
import com.alexander_nevsky_temple.di.data.serviceModule
import com.alexander_nevsky_temple.di.domain.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                serviceModule,
                repositoryModule,
                useCaseModule
            )
        }
    }
}