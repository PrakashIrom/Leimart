package apui.shopping.kmp.di

import apui.shopping.kmp.data.remote.createHttpClient
import apui.shopping.kmp.presentation.registration.RegisterViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val registerUserAndroidModule = module {
    single {
        createHttpClient()
    }
    viewModel {
        RegisterViewModel(get())
    }
}