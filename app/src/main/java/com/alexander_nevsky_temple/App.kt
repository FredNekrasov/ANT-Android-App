package com.alexander_nevsky_temple

import android.app.Application
import com.alexander_nevsky_temple.data.di.dataModule
import com.alexander_nevsky_temple.di.domainModule
import com.alexander_nevsky_temple.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 *   Application class.
 *   Initializes Koin for dependency injection.
 *   @see dataModule
 *   @see domainModule
 *   @see vmModule
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(dataModule, domainModule, vmModule)
        }
    }
}