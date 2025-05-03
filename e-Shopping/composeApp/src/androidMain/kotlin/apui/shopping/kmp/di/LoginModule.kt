package apui.shopping.kmp.di

import apui.shopping.kmp.presentation.login.LoginViewModel
import org.koin.dsl.module

val loginModule = module {
    single {
        LoginViewModel()
    }
}
