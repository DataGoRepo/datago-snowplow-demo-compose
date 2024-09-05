package com.snowplowanalytics.snowplowdemokotlin

import android.app.Application
import com.snowplowanalytics.snowplowdemokotlin.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SnowPlowDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SnowPlowDemoApplication)
            modules(appModule)
        }
    }
}