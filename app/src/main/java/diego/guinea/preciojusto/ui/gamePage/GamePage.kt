package diego.guinea.preciojusto.ui.gamePage

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.*
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.ObjectsPJ
import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import diego.guinea.preciojusto.utils.showCheckDialog
import diego.guinea.preciojusto.utils.showWrongDialog
import diego.guinea.preciojusto.utils.vibrate
import kotlinx.android.synthetic.main.activity_game.*
import org.koin.android.ext.android.inject
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


class GamePage : AppCompatActivity() {

    private val viewModel by inject<GamePageViewModel>()
    private val pjObject: ArrayList<ObjectsPJ> = arrayListOf()
    private var loadingDialog: Dialog? = null
    private var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setViewinivsible()
        viewModel.getAllData()
        observer()

    }
    private fun setTimerOn(){
        val text = findViewById<TextView>(R.id.textCountDown)
        val duration = TimeUnit.MINUTES.toMillis(10)

        object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                    ,TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    ,TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
                text.text = sDuration
            }

            override fun onFinish() {
                winPageIntent()
            }
        }.start()
    }

    private fun setViewinivsible() {
        progressBar.visibility = View.VISIBLE
        textCountDown.visibility = View.INVISIBLE
        imageObject.visibility = View.INVISIBLE
        textNameObject.visibility = View.INVISIBLE
        textDescripcion.visibility = View.INVISIBLE
        editTextPrice.visibility = View.INVISIBLE
        imageNext.visibility = View.INVISIBLE
        textPoints.visibility = View.INVISIBLE
    }

    private fun observer() {
        viewModel.valuesViewMLD.observe(this, Observer {
            getData(it)
        })
    }
    private fun hideLoading() {
        loadingDialog?.let { if (it.isShowing) it.cancel() }
    }

    private fun showDialog() {
        hideLoading()
        loadingDialog = this.showWrongDialog()
        Handler().postDelayed({
            hideLoading()
        }, 2000)
    }
    private fun showCheck() {
        hideLoading()
        loadingDialog = this.showCheckDialog()
        Handler().postDelayed({
            hideLoading()
        }, 2000)
    }
    private fun getData(it: ObjectsPrice) {
        pjObject.addAll(it.objetos)
        prepareBackgroud()
    }

    private fun prepareBackgroud() {
        visibleView()

        if (cont >= pjObject.size){
            winPageIntent()
        }else{
            Glide.with(imageObject.context)
                .load(pjObject[cont].foto)
                .into(imageObject)
            textNameObject.text = pjObject[cont].name
            textDescripcion.text = pjObject[cont].descripcion
        }

        imageNext.setOnClickListener {
            imageClick(cont)
        }
    }

    private fun winPageIntent() {
        val intent = Intent(this, WinPage::class.java)
        intent.putExtra("numCont", "$cont")
        startActivity(intent)
    }

    private fun visibleView() {
        textCountDown.visibility = View.VISIBLE
        progressBar.visibility = View.INVISIBLE
        imageObject.visibility = View.VISIBLE
        textNameObject.visibility = View.VISIBLE
        textDescripcion.visibility = View.VISIBLE
        editTextPrice.visibility = View.VISIBLE
        imageNext.visibility = View.VISIBLE
        textPoints.visibility = View.VISIBLE
        setTimerOn()
    }

    private fun imageClick(num: Int) {
        if (editTextPrice.text.toString() == pjObject[num].precio) {
            cont++
            showCheck()
            prepareBackgroud()
            "WINS: ${this.cont}".also { textPoints.text = it }
            textPoints.setTextColor(Color.GREEN)
            editTextPrice.setText("")
        } else {
            this.vibrate()
            textPoints.setTextColor(Color.RED)
            showDialog()
            editTextPrice.setText("")
        }
    }
}
