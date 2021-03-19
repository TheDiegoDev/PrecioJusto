package diego.guinea.preciojusto.ui.gamePage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import diego.guinea.preciojusto.utils.BaseCallback


class GamePageViewModel: ViewModel() {
    private val repositorio = Single.Repository()
    val valuesViewMLD = MutableLiveData<ObjectsPrice>()
    val errorViewMLD = MutableLiveData<Error>()

    fun getAllData(){
        repositorio.getObjects(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }
}