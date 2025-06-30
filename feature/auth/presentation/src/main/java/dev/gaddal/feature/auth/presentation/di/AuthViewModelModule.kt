package dev.gaddal.feature.auth.presentation.di

import dev.gaddal.feature.auth.presentation.login.LoginViewModel
import dev.gaddal.feature.auth.presentation.registration.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}