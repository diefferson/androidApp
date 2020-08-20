package diefferson.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import diefferson.androidapp.ui.FlutterBottomSheetActivity
import diefferson.androidapp.ui.FlutterFullScreenActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListeners()
    }

    private fun setupListeners(){
        openFullScreen.setOnClickListener {
            FlutterFullScreenActivity.launch(this)
        }

        openBottomSheet.setOnClickListener {
            FlutterBottomSheetActivity.launch(this)
        }
    }
}
