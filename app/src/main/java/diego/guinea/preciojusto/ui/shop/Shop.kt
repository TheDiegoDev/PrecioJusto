package diego.guinea.preciojusto.ui.shop


import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.ui.presenter.WebView
import diego.guinea.preciojusto.utils.GitHub
import diego.guinea.preciojusto.utils.Linkedin
import diego.guinea.preciojusto.utils.Sonido

import kotlinx.android.synthetic.main.activity_shop.*

class Shop : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        setView()
    }

    //Configuracion de Inicio
    private fun setView() {
        openLinkedin.setOnClickListener { webViewIntent(Linkedin) }
        openGit.setOnClickListener {webViewIntent(GitHub)}
        copyBTC.setOnClickListener {copyText(txtBTCWallet.text as String)}
        copyETH.setOnClickListener {copyText(txtETHWallet.text as String)}
        copyPaypal.setOnClickListener {copyText(txtMyPaypal.text as String)}
    }

    //Funcion de Copy
    private fun copyText(txt: String) {
        val clipboard = getSystemService((CLIPBOARD_SERVICE)) as ClipboardManager
        val clip = ClipData.newPlainText("TextView", txt)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this, "Copiado :)", Toast.LENGTH_LONG).show()
    }

    //Intent para hacer un WebView
    private fun webViewIntent(url: String) {
        val intent = Intent(this, WebView::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }
}
