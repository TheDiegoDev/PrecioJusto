package diego.guinea.preciojusto.ui.gamePage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import diego.guinea.preciojusto.utils.BaseCallback
import diego.guinea.preciojusto.utils.contError
import diego.guinea.preciojusto.utils.contWins


class GamePageViewModel: ViewModel() {
    private val repositorio = Single.objectRepository()
    val valuesViewMLD = MutableLiveData<ObjectsPrice>()
    val errorViewMLD = MutableLiveData<Error>()
    val livesViewMDL = MutableLiveData<Int>()
    val winsViewMDL = MutableLiveData<Int>()


    fun getAllData(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
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