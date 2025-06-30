package dev.gaddal.notemark

import android.app.Application
import dev.gaddal.feature.auth.presentation.di.authViewModelModule
import dev.gaddal.notemark.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class NoteMarkApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@NoteMarkApp)
            workManagerFactory()
            modules(
//                authDataModule,
                authViewModelModule,
                appModule,
            )
        }
    }
}