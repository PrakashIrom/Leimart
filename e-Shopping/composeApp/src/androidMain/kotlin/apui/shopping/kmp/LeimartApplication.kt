package apui.shopping.kmp

import android.app.Application
import apui.shopping.kmp.di.loginModule
import apui.shopping.kmp.di.registerUserAndroidModule
import apui.shopping.kmp.di.registerUserModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LeimartApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LeimartApplication)
            modules(loginModule, registerUserModule, registerUserAndroidModule)
        }
    }
}