package diego.guinea.preciojusto.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import diego.guinea.preciojusto.utils.Monedas

class CoinPageViewModel: ViewModel() {
    val valuesViewMLD = MutableLiveData<String>()

    fun getCoinsValues(){
       valuesViewMLD.value = Monedas.toString()
    }
}