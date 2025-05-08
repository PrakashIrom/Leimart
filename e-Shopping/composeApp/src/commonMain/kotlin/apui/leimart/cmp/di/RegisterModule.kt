package apui.leimart.cmp.di

import apui.leimart.cmp.data.remote.createHttpClient
import org.koin.dsl.module

val registerModule =
    module {
        single {
            createHttpClient()
        }
    }
