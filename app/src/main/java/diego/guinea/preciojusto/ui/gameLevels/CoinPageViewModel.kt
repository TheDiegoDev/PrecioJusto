package diego.guinea.preciojusto.ui.gameLevels

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import diego.guinea.preciojusto.utils.Monedas
import diego.guinea.preciojusto.utils.contError

//ChoseGame ViewModel para llevar el control de Coins
class CoinPageViewModel: ViewModel() {
    val valuesViewMLD = MutableLiveData<String>()

    fun getCoinsValues(){
        valuesViewMLD.value = Monedas.toString()
    }
}