package com.alexander_nevsky_temple

import android.app.Application
import com.alexander_nevsky_temple.data.di.dataModule
import com.alexander_nevsky_temple.di.domain.useCaseModule
import com.alexander_nevsky_temple.di.presentation.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(dataModule, useCaseModule, vmModule)
        }
    }
}