package diego.guinea.preciojusto.ui.gamePage

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.utils.showLoseDilog
import diego.guinea.preciojusto.utils.showWinDialog
import kotlinx.android.synthetic.main.activity_winpage.*

class WinPage: AppCompatActivity() {

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
        }, 2000)
    }
    private fun showLosePage(){
        hideLoading()
        loadingDialog = this.showLoseDilog()
        Handler().postDelayed({
            hideLoading()
        }, 2000)
    }
    private fun setBackground() {
        val points = intent.getStringExtra("numCont").toString()
        val lives = intent.getStringExtra("numCont").toString()

        if (lives == "0"){
            showLosePage()
        }else{
            showWinPage()
            textContWins.text = points
        }
    }
}

