package apui.shopping.kmp.di

import apui.shopping.kmp.data.remote.registration.RegisterApiService
import org.koin.dsl.module

val registerUserModule = module {
    single {
        RegisterApiService(get())
    }
}