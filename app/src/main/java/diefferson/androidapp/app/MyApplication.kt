package diefferson.androidapp.app

import android.app.Application
import diefferson.androidapp.app.configurators.AppConfigurator
import diefferson.androidapp.app.configurators.FlutterConfigurator

class MyApplication : Application(){

    private val configurators : List<AppConfigurator> by lazy {
        listOf(
            FlutterConfigurator()
        )
    }

    override fun onCreate() {
        super.onCreate()
        configurators.forEach {
            it.configure(this@MyApplication)
        }
    }
}