package diego.guinea.preciojusto.ui.presenter


import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R
import kotlinx.android.synthetic.main.activity_web.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val url = intent.getStringExtra("url")
        setWebView(url)
    }

    //Uso de WebViewClient para mostrar la Url
    private fun setWebView(url: String?) {
       webView.webViewClient = WebViewClient()
       webView.settings.javaScriptEnabled
       webView.loadUrl(url.toString())
    }
}