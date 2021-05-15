package diego.guinea.preciojusto.ui.gamePage

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.utils.Monedas
import diego.guinea.preciojusto.utils.showLoseDilog
import diego.guinea.preciojusto.utils.showWinDialog
import kotlinx.android.synthetic.main.activity_winpage.*

class WinPage: AppCompatActivity() {

    private var winImage = "https://www.dropbox.com/s/52knr12as885c1s/winner.png?dl=1"
    private var loseImage = "https://www.dropbox.com/s/kzt2a7uh3srpxrj/oops.png?dl=1"
    private var loadingDialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winpage)
        setBackground()
    }
    private fun hideLoading() {
        loadingDialog?.let { if (it.isShowing) it.cancel() }
    }

    private fun showWinPage() {
        hideLoading()
        loadingDialog = this.showWinDialog()
        Handler().postDelayed({
            hideLoading()
        }, 3000)
    }
    private fun showLosePage(){
        hideLoading()
        loadingDialog = this.showLoseDilog()
        Handler().postDelayed({
            hideLoading()
        }, 3000)
    }
    private fun setBackground() {
        val points = intent.getStringExtra("numCont").toString()
        val lives = intent.getStringExtra("numLives").toString()

        if (lives == "0"){
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

    private fun putImage(image: String) {
        Glide.with(imageWinLose.context)
            .load(image)
            .into(imageWinLose)
    }
}

