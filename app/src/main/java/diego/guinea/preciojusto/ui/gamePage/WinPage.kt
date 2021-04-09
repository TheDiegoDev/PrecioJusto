package diego.guinea.preciojusto.ui.gamePage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R
import kotlinx.android.synthetic.main.activity_winpage.*

class WinPage: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winpage)
        val value = intent.getStringExtra("numCont").toString()
        textContWins.text = value
    }
}

