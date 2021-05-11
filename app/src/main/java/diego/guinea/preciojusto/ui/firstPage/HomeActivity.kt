package diego.guinea.preciojusto.ui.firstPage

import android.animation.ValueAnimator
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.ui.gameLevels.ChoseGame
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        BackgroundSound()
        prepareBackground()
    }

//        override fun onStop() {
//            super.onStop()
//            mp.stop()
//    }

    private fun BackgroundSound() {
        mp = MediaPlayer.create(this, R.raw.preciojusto)
        mp.isLooping = true
        mp.setVolume(100f, 100f)
        mp.start()
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

        btnClicks(playButton, settingsButton)

    }

    private fun btnClicks(playButton: ImageView, settingsButton: ImageView) {
        playButton.setOnClickListener {
            val intent = Intent(this, ChoseGame::class.java)
            startActivity(intent)
        }
        settingsButton.setOnClickListener {
            if (mp.isPlaying){
                settingsButton.setImageDrawable(resources.getDrawable(R.mipmap.soundoff))
                mp.stop()
            }else{
                settingsButton.setImageDrawable(resources.getDrawable(R.mipmap.soundon))
                BackgroundSound()
            }
        }
    }
}

