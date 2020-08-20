package diefferson.androidapp.base

import android.os.Bundle
import diefferson.androidapp.BuildConfig
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant

abstract class BaseFlutterActivity : FlutterActivity() {

    abstract val customInitialRoute: String

    abstract fun setupChannels(flutterEngine: FlutterEngine)

    override fun getBackgroundMode() = FlutterActivityLaunchConfigs.BackgroundMode.transparent

    override fun getCachedEngineId() = BuildConfig.FLUTTER_ENGINE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flutterEngine?.navigationChannel?.pushRoute(customInitialRoute)
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        setupChannels(flutterEngine)
    }
}
