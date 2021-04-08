package diego.guinea.preciojusto.ui.gamePage

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.*
import android.view.View
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

    private fun setViewinivsible() {
        progressBar.visibility = View.VISIBLE
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
            val intent = Intent(this, WinPage::class.java)
            startActivity(intent)
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

    private fun visibleView() {
        progressBar.visibility = View.INVISIBLE
        imageObject.visibility = View.VISIBLE
        textNameObject.visibility = View.VISIBLE
        textDescripcion.visibility = View.VISIBLE
        editTextPrice.visibility = View.VISIBLE
        imageNext.visibility = View.VISIBLE
        textPoints.visibility = View.VISIBLE
    }

    private fun imageClick(num: Int) {
        if (editTextPrice.text.toString() == pjObject[num].precio) {
            cont++
            showCheck()
            prepareBackgroud()
            textPoints.text = cont.toString()
            editTextPrice.setText("")
        } else {
            this.vibrate()
            showDialog()
            editTextPrice.setText("")
        }
    }
}
