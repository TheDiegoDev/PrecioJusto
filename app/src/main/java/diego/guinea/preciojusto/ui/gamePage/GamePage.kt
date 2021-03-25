package diego.guinea.preciojusto.ui.gamePage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.ObjectsPJ
import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import kotlinx.android.synthetic.main.activity_game.*
import org.koin.android.ext.android.inject


class GamePage : AppCompatActivity() {

    private val viewModel by inject<GamePageViewModel>()
    private val pjObject: ArrayList<ObjectsPJ> = arrayListOf()
    lateinit var values: ObjectsPrice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        viewModel.getAllData()
        observer()
    }

    private fun observer() {
        viewModel.valuesViewMLD.observe(this, Observer {
          getData(it)
        })
    }

    private fun getData(it: ObjectsPrice) {
        values = it
        pjObject.addAll(it.objetos)
        Glide.with(imageObject.context)
                .load(pjObject[0].foto)
                .into(imageObject)
        textDescripcion.text = pjObject[0].descripcion
    }
}
