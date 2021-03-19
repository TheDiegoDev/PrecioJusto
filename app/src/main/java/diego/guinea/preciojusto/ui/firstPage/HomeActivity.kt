package diego.guinea.preciojusto.ui.firstPage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.ui.gamePage.GamePage
import diego.guinea.preciojusto.ui.presenter.ExoPlayerView
import diego.guinea.preciojusto.ui.settings.Settings
import diego.guinea.preciojusto.utils.VideoFondo
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        prepareBackground()
    }

//    override fun onPause() {
//        super.onPause()
//        videoDeFondo.onPause()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        videoDeFondo.onResume()
//    }

    private fun prepareBackground() {

//        val playText = findViewById<TextView>(R.id.play_text)
//        //val fondo = findViewById<ExoPlayerView>(R.id.videoDeFondo)
        val playButton = findViewById<ImageView>(R.id.play_button)
        val settingsButton = findViewById<ImageView>(R.id.settings_button)
//        val animationLeft = AnimationUtils.loadAnimation(this, R.anim.animacion_left)
//        val animationBottom = AnimationUtils.loadAnimation(this, R.anim.animacion_bottom)
//
        playButton.setOnClickListener{
            val intent = Intent(this, GamePage::class.java)
            startActivity(intent)
        }
        settingsButton.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
//        settingsButton.animation = animationLeft
//        playText.animation = animationBottom
//        playButton.animation = animationBottom

        //fondo.prepare(Uri.parse(VideoFondo))
    }
}

