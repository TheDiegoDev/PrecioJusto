package diego.guinea.preciojusto.ui.gamePage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R


class GamePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        prepareBackground()
    }

    private fun prepareBackground() {

    }
}
