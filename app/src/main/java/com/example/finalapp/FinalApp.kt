package com.example.finalapp

import android.app.Application
import com.example.finalapp.di.networkModule
import com.example.finalapp.di.rootModule
import com.github.terrakok.modo.ModoDevOptions
import logcat.AndroidLogcatLogger
import logcat.LogPriority
import logcat.logcat
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FinalApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
        ModoDevOptions.onIllegalScreenModelStoreAccess = ModoDevOptions.ValidationFailedStrategy { throwable ->
            throw throwable
        }
        ModoDevOptions.onIllegalClearState = ModoDevOptions.ValidationFailedStrategy { _ ->
            logcat(priority = LogPriority.ERROR) { "Cleaning state of composable, which still can be visible for user." }
        }

        startKoin {
            androidLogger()
            androidContext(this@FinalApp)
            modules(rootModule, networkModule)
        }
    }
}