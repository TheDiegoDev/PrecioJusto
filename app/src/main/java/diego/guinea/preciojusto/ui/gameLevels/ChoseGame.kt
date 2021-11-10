package diego.guinea.preciojusto.ui.gameLevels

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.AlphaChar
import diego.guinea.preciojusto.ui.presenter.AlphaAdapters
import diego.guinea.preciojusto.ui.shop.Shop
import diego.guinea.preciojusto.utils.Monedas
import diego.guinea.preciojusto.utils.Sonido
import kotlinx.android.synthetic.main.activity_chose_levels.*
import org.koin.android.ext.android.inject

class ChoseGame : AppCompatActivity() {

    private val viewModel by inject<CoinPageViewModel>()
    private var recyclerView: RecyclerView ? = null
    private var gridLayoutManager: GridLayoutManager ? = null
    private var arrayList: ArrayList<AlphaChar> ? = null
    private var alphaAdapters: AlphaAdapters ? = null
    private lateinit var mp: MediaPlayer
    private var currentPositionSong: Int? = null
    private lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_levels)
        currentPositionSong = intent.getIntExtra("song",0)
        prefs = getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        Monedas = prefs.getString("key","0")?.toInt()!!
        setConfigItems()
        ShopIntent()
    }

    private fun ShopIntent() {
        btn_shop.setOnClickListener {
            val intent = Intent(this, Shop::class.java)
            intent.putExtra("song", currentPositionSong)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        mp.stop()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getCoinsValues()
        ObserveCoins()
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
    private fun ObserveCoins() {
        viewModel.valuesViewMLD.observe(this, Observer {
            text_coins.text = it
            val editor : SharedPreferences.Editor = prefs.edit()
            editor.putString("key", it)
            editor.apply()
        })
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

        items.add(AlphaChar(R.mipmap.smartphone, "Moviles"))
        items.add(AlphaChar(R.mipmap.deportes, "Deportes"))
        items.add(AlphaChar(R.mipmap.casa, "Hogar"))
        items.add(AlphaChar(R.mipmap.joya, "Joyas"))
        items.add(AlphaChar(R.mipmap.cpu, "Electronica"))
        items.add(AlphaChar(R.mipmap.coche, "Coches"))
        items.add(AlphaChar(R.mipmap.ropa, "Ropa"))
        items.add(AlphaChar(R.mipmap.relojes, "Relojes"))
        items.add(AlphaChar(R.mipmap.bolso, "Bolsos"))

        return items
    }

}
