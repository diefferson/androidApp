package diefferson.androidapp.ui

import android.content.Context
import android.content.Intent
import diefferson.androidapp.base.BaseFlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class LoginActivity : BaseFlutterActivity(){

    override val customInitialRoute = "/login"

    override fun setupChannels(flutterEngine: FlutterEngine) {

    }

    companion object{
        fun launch(context: Context?){
            context?.startActivity(Intent(context, LoginActivity::class.java))
        }
    }

}
