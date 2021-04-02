package diego.guinea.preciojusto.ui.firstPage

import android.animation.ValueAnimator
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
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

    private fun prepareBackground() {
        val playButton = findViewById<ImageView>(R.id.play_button)
        val settingsButton = findViewById<ImageView>(R.id.settings_button)

        val valueAnimator = ValueAnimator.ofFloat(0f,360f)

        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            coinGif.rotation = value
            coinGif2.rotation = value
        }

        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.duration = 3000
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.start()

        playButton.setOnClickListener{
            val intent = Intent(this, GamePage::class.java)
            startActivity(intent)
        }
        settingsButton.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

    }
}

