package apui.leimart.cmp

import android.app.Application
import apui.leimart.cmp.di.loginModule
import apui.leimart.cmp.di.registerModule
import apui.leimart.cmp.di.registerUserModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LeimartApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LeimartApplication)
            modules(loginModule, registerUserModule, registerModule)
        }
    }
}
