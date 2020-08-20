package diefferson.androidapp.app.configurators

import android.content.Context
import diefferson.androidapp.BuildConfig
import diefferson.androidapp.R
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.view.FlutterMain

class FlutterConfigurator : AppConfigurator {

    private lateinit var flutterEngine: FlutterEngine

    override fun configure(context: Context) {
        initFlutterEngine(context)
    }

    private fun initFlutterEngine(context: Context){

        flutterEngine = FlutterEngine(context)

        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), context.getString(R.string.flutter_entry))
        )

        FlutterEngineCache
            .getInstance()
            .put(BuildConfig.FLUTTER_ENGINE, flutterEngine)
    }

}