package diego.guinea.preciojusto.ui.shop


import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.ui.presenter.WebView
import diego.guinea.preciojusto.utils.GitHub
import diego.guinea.preciojusto.utils.Linkedin
import diego.guinea.preciojusto.utils.Sonido

import kotlinx.android.synthetic.main.activity_shop.*

class Shop : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private var currentPositionSong: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        currentPositionSong = intent.getIntExtra("song",0)
        setView()
    }


    private fun setView() {
        openLinkedin.setOnClickListener { webViewIntent(Linkedin) }
        openGit.setOnClickListener {webViewIntent(GitHub)}
        copyBTC.setOnClickListener {  }
        copyETH.setOnClickListener {  }
        copyPaypal.setOnClickListener {  }
    }

    private fun webViewIntent(url: String) {
        val intent = Intent(this, WebView::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        mp.stop()
    }

    override fun onStart() {
        super.onStart()
        BackgroundSound()
    }

    private fun BackgroundSound() {
        mp = MediaPlayer.create(this, R.raw.preciojusto)
        mp.isLooping = true
        mp.setVolume(100f, 100f)
        currentPositionSong?.let { mp.seekTo(it) }
        if (Sonido == 0) {
            mp.start()
        }
    }
}
