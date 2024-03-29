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
import diego.guinea.preciojusto.utils.Sonido
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private var currentPositionSong: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        prepareBackground()
    }

    //Gestion de la salida de la Activity
    override fun onStop() {
            super.onStop()
            mp.stop()
    }

    //Gestion de la entrada a la Activity
    override fun onStart() {
        super.onStart()
            BackgroundSound()
    }

    //Sonido
    private fun BackgroundSound() {
        mp = MediaPlayer.create(this, R.raw.preciojusto)
        mp.isLooping = true
        mp.setVolume(100f, 100f)
        if (Sonido == 0) {
            mp.start()
        }
    }

    //Poner la vista en marcha
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

    //Gestion de los botones
    private fun btnClicks(playButton: ImageView, settingsButton: ImageView) {
        playButton.setOnClickListener {
            val intent = Intent(this, ChoseGame::class.java)
            currentPositionSong = mp.currentPosition
            intent.putExtra("song", currentPositionSong)
            startActivity(intent)
        }
        settingsButton.setOnClickListener {
            if (mp.isPlaying){
                settingsButton.setImageDrawable(resources.getDrawable(R.mipmap.soundoff))
                Sonido = 1
                mp.stop()
            }else{
                settingsButton.setImageDrawable(resources.getDrawable(R.mipmap.soundon))
                Sonido = 0
                BackgroundSound()
            }
        }
    }
}

