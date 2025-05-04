package apui.shopping.kmp.di

import apui.shopping.kmp.data.remote.registration.repository.RegisterApiServiceImpl
import apui.shopping.kmp.domain.repository.RegisterApiService
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