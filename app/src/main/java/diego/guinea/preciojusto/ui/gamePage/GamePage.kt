package diego.guinea.preciojusto.ui.gamePage

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.media.MediaPlayer
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
import diego.guinea.preciojusto.ui.presenter.CustomDialog
import diego.guinea.preciojusto.utils.*
import kotlinx.android.synthetic.main.activity_game.*
import org.koin.android.ext.android.inject
import java.util.*
import java.util.concurrent.TimeUnit

class GamePage : AppCompatActivity() {

    private val viewModel by inject<GamePageViewModel>()
    private val pjObject: ArrayList<ObjectsPJ> = arrayListOf()
    private var loadingDialog: Dialog? = null
    private var mCountDown: CountDownTimer? = null
    lateinit var chip: Chip
    private lateinit var mp: MediaPlayer
    private lateinit var prefs : SharedPreferences
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        prefs = getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        setViewinivsible()
        contError = 2
        contWins = 0

    }

    //Gestionamos la Salida de esta Activity
    override fun onStop() {
        super.onStop()
        mp.stop()
        mCountDown?.cancel()
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString("key", Monedas.toString())
        editor.apply()
    }

    //Gestionamos la entrada a la Activity
    override fun onStart() {
        super.onStart()
        position = intent.getIntExtra("position", 0)
        setViewModel()
        observer()
        BackgroundSound()
    }

    //Gestionamos el GetData segun la posicion del Recycler del ChoseGame
    private fun setViewModel() {
        when (position) {
            0 -> {viewModel.getAllDataPageOne()}
            1 -> {viewModel.getAllDataPageTwo()}
            2 -> {viewModel.getAllDataPageThree()}
            3 -> {viewModel.getAllDataPageFour()}
            4 -> {viewModel.getAllDataPageFive()}
            5 -> {viewModel.getAllDataPageSix()}
            6 -> {viewModel.getAllDataPageSeven()}
            7 -> {viewModel.getAllDataPageEight()}
            else -> {viewModel.getAllDataPageNine()}
        }
    }

    //Gestion del sonido
    private fun BackgroundSound() {
        mp = MediaPlayer.create(this, R.raw.intriga)
        mp.isLooping = true
        mp.setVolume(100f, 100f)
        if (Sonido == 0) {
            mp.start()
        }
    }

    //Gestionamos los precios del ChipGroup
    private fun setPriceChip(){

        val numValues: ArrayList<String> = arrayListOf()
        numValues.add(pjObject[contWins].precio.toString())
        numValues.add(pjObject[contWins].primero.toString())
        numValues.add(pjObject[contWins].segundo.toString())

        val priceOne = findViewById<Chip>(R.id.chipPriceOne)
        val priceTwo = findViewById<Chip>(R.id.chipPriceTwo)
        val priceThree = findViewById<Chip>(R.id.chipPriceThree)

        val idx = Random().nextInt(numValues.size)
        setRandomText(idx, priceOne, numValues, priceTwo, priceThree)
    }

    //Funcion para poner Precios a cada Chip
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
            3 -> {
                priceOne.text = numValues[idx - 2]
                priceTwo.text = numValues[idx -1]
                priceThree.text = numValues[idx - 3]
            }else -> {
                priceOne.text = numValues[idx +1]
                priceTwo.text = numValues[idx]
                priceThree.text = numValues[idx + 2]
            }
        }
    }

    //Poner la cuenta atras en marcha
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
                contError = 0
                winPageIntent()
            }
        }.start()

    }

    //Vista Invisible
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

    //Observer para el cambio en tiempo real de los datos
    private fun observer() {
        viewModel.livesViewMDL.observe(this, Observer {
            contError = it
            observeWinsAndLives()

        })
        viewModel.winsViewMDL.observe(this, Observer {
            contWins = it
            observeWinsAndLives()
        })
        viewModel.valuesViewMLD.observe(this, Observer {
            getData(it)
        })
    }

    //Ocultar Animacion
    private fun hideLoading() {
        loadingDialog?.let { if (it.isShowing) it.cancel() }
    }

    //Mostrar Animacion Fail
    private fun showDialog() {
        hideLoading()
        loadingDialog = this.showWrongDialog()
        Handler().postDelayed({
            hideLoading()
        }, 2000)
    }

    //Mostrar Animacion Check
    private fun showCheck() {
        hideLoading()
        loadingDialog = this.showCheckDialog()
        Handler().postDelayed({
            hideLoading()
        }, 2000)
    }

    //Añadir a un array los objetos de la API
    private fun getData(it: ObjectsPrice) {
        pjObject.addAll(it.objetos)
        prepareBackgroud()
    }

    //Gestionamos el boton de atras
    override fun onBackPressed() {
        mCountDown?.cancel()
        super.onBackPressed()
    }

    //Preparamos la pantalla
    private fun prepareBackgroud() {
        var texto = ""
        visibleView()
        mCountDown?.cancel()
        setTimerOn()
        if (contWins >= pjObject.size){
            winPageIntent()
        }else{
            setPriceChip()
            Glide.with(imageObject.context)
                .load(pjObject[contWins].foto)
                .into(imageObject)
            textNameObject.text = pjObject[contWins].name
            textDescripcion.text = pjObject[contWins].descripcion
        }
        chipGroup.setOnCheckedChangeListener { group, checkedId:Int ->
            imageNext.visibility = View.VISIBLE
            val chip: Chip? = findViewById(checkedId)
            chip.let {
                 texto = it?.text.toString()
            }
        }
        imageNext.setOnClickListener {
            imageClick(contWins, texto)
        }
    }

    //Intent a la Activity final
    private fun winPageIntent() {
        hideLoading()
        if(contError == 0){
            val dialog = CustomDialog()
            dialog.show(supportFragmentManager, "CustomDialog")
        }else{
            val intent = Intent(this, WinPage::class.java)
            intent.putExtra("numCont", "$contWins")
            intent.putExtra("numLives", "$contError")
            startActivity(intent)
        }

    }

    //Vista visible
    private fun visibleView() {
        textCountDown.visibility = View.VISIBLE
        progressBar.visibility = View.INVISIBLE
        imageObject.visibility = View.VISIBLE
        textNameObject.visibility = View.VISIBLE
        textDescripcion.visibility = View.VISIBLE
        chipGroup.visibility = View.VISIBLE
        textPoints.visibility = View.VISIBLE
    }

    //Gestion del clik a la imagen ENTER
    private fun imageClick(num: Int, chipSelect: String) {

            if (chipSelect == pjObject[num].precio) {
                contWins++
                showCheck()
                prepareBackgroud()
                observeWinsAndLives()
                textPoints.setTextColor(Color.GREEN)
            } else {
                contError--
                if (contError == 0){
                    winPageIntent()
                }else{
                    observeWinsAndLives()
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

    //Gestion del texto de Wins and Lives
    private fun observeWinsAndLives() {
        "WINS: $contWins || LIVES: $contError".also { textPoints.text = it }
    }
}
