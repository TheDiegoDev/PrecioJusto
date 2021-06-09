package diego.guinea.preciojusto.ui.shop


import android.media.MediaPlayer
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R

import kotlinx.android.synthetic.main.activity_shop.*

class Shop : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private var currentPositionSong: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        //currentPositionSong = intent.getIntExtra("song",0)
        //openWebView()
    }


    private fun openWebView() {
       // paypalView.webViewClient = WebViewClient()
       // paypalView.loadUrl("https://www.paypal.com/")
    }//https://www.google.com/

//    override fun onStop() {
//        super.onStop()
//        mp.stop()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        BackgroundSound()
//    }
//
//    private fun BackgroundSound() {
//        mp = MediaPlayer.create(this, R.raw.preciojusto)
//        mp.isLooping = true
//        mp.setVolume(100f, 100f)
//        currentPositionSong?.let { mp.seekTo(it) }
//        if (Sonido == 0) {
//            mp.start()
//        }
//    }
}
