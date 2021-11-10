package diego.guinea.preciojusto.ui.gamePage

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.utils.*
import kotlinx.android.synthetic.main.activity_winpage.*

class WinPage: AppCompatActivity() {

    private var loadingDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winpage)
        setBackground()
    }

    //Quitar la Animacion
    private fun hideLoading() {
        loadingDialog?.let { if (it.isShowing) it.cancel() }
    }

    //Enseñar la animacion del Win
    private fun showWinPage() {
        hideLoading()
        loadingDialog = this.showWinDialog()
        Handler().postDelayed({
            hideLoading()
        }, 3000)
    }

    //Enseñar la animacion del Lose
    private fun showLosePage(){
        hideLoading()
        loadingDialog = this.showLoseDilog()
        Handler().postDelayed({
            hideLoading()
        }, 3000)
    }

    //Decidimos si enseñamos una animacion o otra
    private fun setBackground() {
        val points = intent.getStringExtra("numCont").toString()
        val lives = intent.getStringExtra("numLives").toString()

        if (lives == "0"){
            textCoinsWinPage.visibility = View.INVISIBLE
            imageCoinWinPage.visibility = View.INVISIBLE
            showLosePage()
            textContWins.setTextColor(Color.RED)
            "Loser".also { textContWins.text = it }
            "Score: $points".also { textScore.text = it }
            putImage(loseImage)
        }else{
            Monedas += 5
            showWinPage()
            textContWins.setTextColor(Color.GREEN)
            "Winner".also { textContWins.text = it }
            "Score: $points".also { textScore.text = it }
            putImage(winImage)
        }
    }

    //Enseñamos la imagen
    private fun putImage(image: String) {
        Glide.with(imageWinLose.context)
            .load(image)
            .into(imageWinLose)
    }
}

