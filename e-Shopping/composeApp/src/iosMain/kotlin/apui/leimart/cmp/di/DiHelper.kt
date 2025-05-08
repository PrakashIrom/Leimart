package apui.leimart.cmp.di

import org.koin.core.context.startKoin

/*
In Kotlin, a top-level function is a function that is defined outside of any class, object, or interface.
 These functions are directly accessible in the file where they are declared and can be imported and
 used in other files

This initKoin() function is written separately for IOS because,
Language Barrier:
-startKoin and Koin modules are Kotlin constructs
-Swift cannot directly execute Kotlin DSL code (startKoin { modules() } syntax)
Kotlin/Native Interop Rules:
-Swift can only call top-level Kotlin functions exposed via KMP's Objective-C interop
-Complex Kotlin DSLs/lambdas don't automatically bridge to Swift
*/
fun initKoin() {
    startKoin {
        modules(loginModule, registerUserModule, registerModule)
    }
}
