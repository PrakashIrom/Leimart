package apui.shopping.kmp.di

import apui.shopping.kmp.data.remote.repository.registration.RegisterApiServiceImpl
import apui.shopping.kmp.domain.remote.repository.RegisterApiService
import apui.shopping.kmp.domain.usecase.registration.RegisterUseCase
import org.koin.dsl.module

val registerUserModule = module {
    single<RegisterApiService> {
        RegisterApiServiceImpl(get())
    }
    single {
        RegisterUseCase(get())
    }
}