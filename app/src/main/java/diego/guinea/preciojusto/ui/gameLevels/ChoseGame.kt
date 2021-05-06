package diego.guinea.preciojusto.ui.gameLevels

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.AlphaChar
import diego.guinea.preciojusto.ui.presenter.AlphaAdapters

class ChoseGame : AppCompatActivity() {

    private var recyclerView: RecyclerView ? = null
    private var gridLayoutManager: GridLayoutManager ? = null
    private var arrayList: ArrayList<AlphaChar> ? = null
    private var alphaAdapters: AlphaAdapters ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_levels)
        setConfigItems()
    }

    private fun setConfigItems(){
        recyclerView = findViewById(R.id.my_recycler_view)
        gridLayoutManager = GridLayoutManager(applicationContext, 3,LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdapters = AlphaAdapters(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdapters
    }

    private fun setDataInList():ArrayList<AlphaChar>{

        val items: ArrayList<AlphaChar> = ArrayList()


        items.add(AlphaChar(R.mipmap.one, "Nivel 1"))
        items.add(AlphaChar(R.mipmap.two, "Nivel 2"))

        return items
    }

}
