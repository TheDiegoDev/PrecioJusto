package diego.guinea.preciojusto.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.ui.presenter.ExoPlayerView
import diego.guinea.preciojusto.utils.VideoFondo
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        prepareBackground()
    }

    override fun onPause() {
        super.onPause()
        videoDeFondo.onPause()
    }

    override fun onResume() {
        super.onResume()
        videoDeFondo.onResume()
    }

    private fun prepareBackground() {

        val playText = findViewById<TextView>(R.id.play_text)
        val fondo = findViewById<ExoPlayerView>(R.id.videoDeFondo)
        val playButton = findViewById<ImageView>(R.id.play_button)
        val animationBottom = AnimationUtils.loadAnimation(this, R.anim.animacion_bottom)

        playText.animation = animationBottom
        playButton.animation = animationBottom

        fondo.prepare(Uri.parse(VideoFondo))
    }
}

