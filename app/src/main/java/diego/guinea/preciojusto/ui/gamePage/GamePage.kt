package diego.guinea.preciojusto.ui.gamePage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.ObjectsPJ
import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import org.koin.android.ext.android.inject


class GamePage : AppCompatActivity() {

    private val viewModel by inject<GamePageViewModel>()
    private val pjObject: ArrayList<ObjectsPJ> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        viewModel.getAllData()
        observer()
    }

    private fun observer() {
        viewModel.valuesViewMLD.observe(this, Observer {
         // getData(it.results)
        })
    }

    private fun getData(it: List<ObjectsPJ>) {
        //pjObject.addAll(it)
    }
}
