package apui.leimart.cmp.di

import apui.leimart.cmp.data.remote.repository.registration.RegisterApiServiceImpl
import apui.leimart.cmp.domain.remote.repository.RegisterApiService
import apui.leimart.cmp.domain.usecase.registration.RegisterUseCase
import apui.leimart.cmp.presentation.registration.RegisterViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val registerUserModule =
    module {
        single<RegisterApiService> {
            RegisterApiServiceImpl(get())
        }
        single {
            RegisterUseCase(get())
        }
        viewModel {
            RegisterViewModel(get())
        }
    }
