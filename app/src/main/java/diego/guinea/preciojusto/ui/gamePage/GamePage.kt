package diego.guinea.preciojusto.ui.gamePage

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.ObjectsPJ
import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import kotlinx.android.synthetic.main.activity_game.*
import org.koin.android.ext.android.inject
import kotlin.random.Random


class GamePage : AppCompatActivity() {

    private val viewModel by inject<GamePageViewModel>()
    private val pjObject: ArrayList<ObjectsPJ> = arrayListOf()

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
    }

    private fun observer() {
        viewModel.valuesViewMLD.observe(this, Observer {
          getData(it)
        })
    }

    private fun getData(it: ObjectsPrice) {
        pjObject.addAll(it.objetos)
        prepareBackgroud()
    }

    private fun prepareBackgroud() {
        progressBar.visibility = View.INVISIBLE
        imageObject.visibility = View.VISIBLE
        textNameObject.visibility = View.VISIBLE
        textDescripcion.visibility = View.VISIBLE
        editTextPrice.visibility = View.VISIBLE
        imageNext.visibility = View.VISIBLE

        val randomNum =  Random.nextInt((pjObject.size - 0) +0)

        Glide.with(imageObject.context)
            .load(pjObject[randomNum].foto)
            .into(imageObject)
        textNameObject.text = pjObject[randomNum].name
        textDescripcion.text = pjObject[randomNum].descripcion

        imageNext.setOnClickListener {

        }
    }
}
