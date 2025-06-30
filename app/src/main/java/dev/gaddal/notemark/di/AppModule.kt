package dev.gaddal.notemark.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dev.gaddal.notemark.NoteMarkApp
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single<SharedPreferences>(named("encrypted")) {
        EncryptedSharedPreferences(
            androidApplication(),
            "auth_pref",
            MasterKey(androidApplication()),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    single<SharedPreferences>(named("normal")) {
        androidApplication().getSharedPreferences(
            "settings_pref",
            Context.MODE_PRIVATE
        )
    }

    single<CoroutineScope> {
        (androidApplication() as NoteMarkApp).applicationScope
    }
}