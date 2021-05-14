package diego.guinea.preciojusto.ui.gameLevels

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.AlphaChar
import diego.guinea.preciojusto.ui.presenter.AlphaAdapters
import diego.guinea.preciojusto.utils.Sonido

class ChoseGame : AppCompatActivity() {

    private var recyclerView: RecyclerView ? = null
    private var gridLayoutManager: GridLayoutManager ? = null
    private var arrayList: ArrayList<AlphaChar> ? = null
    private var alphaAdapters: AlphaAdapters ? = null
    private lateinit var mp: MediaPlayer
    private var currentPositionSong: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_levels)
        currentPositionSong = intent.getIntExtra("song",0)
        setConfigItems()
    }

    override fun onStop() {
        super.onStop()
        mp.stop()
    }

    override fun onStart() {
        super.onStart()
        BackgroundSound()
    }

    private fun BackgroundSound() {
        mp = MediaPlayer.create(this, R.raw.preciojusto)
        mp.isLooping = true
        mp.setVolume(100f, 100f)
        currentPositionSong?.let { mp.seekTo(it) }
        if (Sonido == 0) {
            mp.start()
        }
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

        items.add(AlphaChar(R.mipmap.uno, "Nivel 1"))
        items.add(AlphaChar(R.mipmap.dos, "Nivel 2"))
        items.add(AlphaChar(R.mipmap.tres, "Nivel 3"))
        items.add(AlphaChar(R.mipmap.cuatro, "Nivel 4"))
        items.add(AlphaChar(R.mipmap.cinco, "Nivel 5"))
        items.add(AlphaChar(R.mipmap.seis, "Nivel 6"))
        items.add(AlphaChar(R.mipmap.siete, "Nivel 7"))
        items.add(AlphaChar(R.mipmap.ocho, "Nivel 8"))
        items.add(AlphaChar(R.mipmap.nueve, "Nivel 9"))

        return items
    }

}
