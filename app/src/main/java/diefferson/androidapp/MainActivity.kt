package diefferson.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import diefferson.androidapp.ui.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListeners()
    }

    private fun setupListeners(){
        openFlutter.setOnClickListener {
            LoginActivity.launch(this)
        }
    }
}
