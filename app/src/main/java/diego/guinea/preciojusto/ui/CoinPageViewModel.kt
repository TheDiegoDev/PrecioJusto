package diego.guinea.preciojusto.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import diego.guinea.preciojusto.utils.Monedas
import diego.guinea.preciojusto.utils.contError

class CoinPageViewModel: ViewModel() {
    val valuesViewMLD = MutableLiveData<String>()

    fun getCoinsValues(){
        valuesViewMLD.value = Monedas.toString()

    }
}