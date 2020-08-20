package diefferson.androidapp.ui

import android.content.Context
import android.content.Intent
import diefferson.androidapp.base.BaseFlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class FlutterFullScreenActivity : BaseFlutterActivity(){

    override val customInitialRoute = "/fullScreen"

    override fun setupChannels(flutterEngine: FlutterEngine) {

    }

    companion object{
        fun launch(context: Context?){
            context?.startActivity(Intent(context, FlutterFullScreenActivity::class.java))
        }
    }

}
