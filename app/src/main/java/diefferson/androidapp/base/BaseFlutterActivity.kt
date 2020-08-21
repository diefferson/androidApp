package diefferson.androidapp.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import diefferson.androidapp.BuildConfig
import diefferson.androidapp.R
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

abstract class BaseFlutterActivity : FlutterActivity() {

    abstract val customInitialRoute: String

    abstract fun setupChannels(flutterEngine: FlutterEngine)

    override fun getBackgroundMode() = FlutterActivityLaunchConfigs.BackgroundMode.transparent

    override fun getCachedEngineId() = BuildConfig.FLUTTER_ENGINE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.statusBarColor = Color.parseColor("#00FFFFFF");
        }
        flutterEngine?.navigationChannel?.pushRoute(customInitialRoute)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        baseFlutterChannel(flutterEngine.dartExecutor.binaryMessenger)
        setupChannels(flutterEngine)
    }

    private fun baseFlutterChannel(binaryMessenger: BinaryMessenger) {
        MethodChannel(binaryMessenger,BASE_CHANNEL).setMethodCallHandler { call, result ->
            when(call.method){
                CLOSE_FLUTTER_CHANNEL -> closeFlutter()
            }
        }
    }

    private fun closeFlutter(){
        finish()
        overridePendingTransition(0, android.R.anim.fade_out)
    }

    companion object{
        private const val BASE_CHANNEL = "diefferson.androidapp.base_channel"
        private const val CLOSE_FLUTTER_CHANNEL = "close_flutter"

    }
}
