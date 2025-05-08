package apui.leimart.cmp.di

import apui.leimart.cmp.presentation.login.LoginViewModel
import org.koin.dsl.module

val loginModule =
    module {
        single {
            LoginViewModel()
        }
    }
