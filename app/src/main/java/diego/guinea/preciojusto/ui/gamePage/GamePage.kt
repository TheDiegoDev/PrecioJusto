package diego.guinea.preciojusto.ui.gamePage

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
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


class GamePage : AppCompatActivity() {

    private val viewModel by inject<GamePageViewModel>()
    private val pjObject: ArrayList<ObjectsPJ> = arrayListOf()
    private var loadingDialog: Dialog? = null
    private var cont = 0
    private var contError = 2
    private var mCountDown: CountDownTimer? = null
    lateinit var chip: Chip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setViewinivsible()
        viewModel.getAllData()
        observer()

    }
    private fun setPriceChip(){

        val numValues: ArrayList<String> = arrayListOf()
        numValues.add(pjObject[cont].precios.segundo.toString())
        numValues.add(pjObject[cont].precio.toString())
        numValues.add(pjObject[cont].precios.primero.toString())

        val priceOne = findViewById<Chip>(R.id.chipPriceOne)
        val priceTwo = findViewById<Chip>(R.id.chipPriceTwo)
        val priceThree = findViewById<Chip>(R.id.chipPriceThree)

        val idx = Random().nextInt(numValues.size)
        setRandomText(idx, priceOne, numValues, priceTwo, priceThree)
    }

    private fun setRandomText(
        idx: Int,
        priceOne: Chip,
        numValues: ArrayList<String>,
        priceTwo: Chip,
        priceThree: Chip
    ) {
        when (idx) {
            1 -> {
                priceOne.text = numValues[idx - 1]
                priceTwo.text = numValues[idx + 1]
                priceThree.text = numValues[idx]
            }
            2 -> {
                priceOne.text = numValues[idx]
                priceTwo.text = numValues[idx - 2]
                priceThree.text = numValues[idx - 1]
            }
            else -> {
                priceOne.text = numValues[idx + 1]
                priceTwo.text = numValues[idx]
                priceThree.text = numValues[idx + 2]
            }
        }
    }

    private fun setTimerOn(){
        val text = findViewById<TextView>(R.id.textCountDown)
        val duration = TimeUnit.MINUTES.toMillis(1)

        mCountDown = object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val sDuration = String.format(
                    Locale.ENGLISH,
                    "%02d : %02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                            TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(
                                    millisUntilFinished
                                )
                            )
                )
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
        chipGroup.visibility = View.INVISIBLE
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
        mCountDown?.cancel()
        setTimerOn()
        if (cont >= pjObject.size){
            winPageIntent()
        }else{
            setPriceChip()
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
        intent.putExtra("numLives", "$contError")
        startActivity(intent)
    }

    private fun visibleView() {
        textCountDown.visibility = View.VISIBLE
        progressBar.visibility = View.INVISIBLE
        imageObject.visibility = View.VISIBLE
        textNameObject.visibility = View.VISIBLE
        textDescripcion.visibility = View.VISIBLE
        chipGroup.visibility = View.VISIBLE
        imageNext.visibility = View.VISIBLE
        textPoints.visibility = View.VISIBLE
    }

    private fun imageClick(num: Int) {
        val textChipSelected = getChipSelected(chipGroup.checkedChipId)

            if (textChipSelected == pjObject[num].precio) {
                cont++
                showCheck()
                prepareBackgroud()
                "WINS: ${this.cont}\n LIVES: $contError".also { textPoints.text = it }
                textPoints.setTextColor(Color.GREEN)
            } else {
                contError--
                if (contError == 0){
                    winPageIntent()
                }else{
                    "WINS: ${this.cont}\n LIVES: $contError".also { textPoints.text = it }
                    this.vibrate()
                    textPoints.setTextColor(Color.RED)
                    showDialog()
                }

            }
            for (i in 0 until chipGroup.childCount) {
                val chip = chipGroup.getChildAt(i) as Chip
                chip.isChecked = false
            }

    }

    private fun getChipSelected(checkedChipId: Int): String {
        chip = findViewById(checkedChipId)
        return chip.text.toString()
    }
}
