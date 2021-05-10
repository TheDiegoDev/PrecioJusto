package diego.guinea.preciojusto.ui.settings

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R
import kotlinx.android.synthetic.main.activity_settings.*


class Settings : AppCompatActivity() {

    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        prepareBackground()
       /* mp = MediaPlayer.create(this, R.raw.preciojusto)
        btnSound.setOnClickListener{
           mp.stop()
        }*/
    }

    private fun prepareBackground() {

    }
}