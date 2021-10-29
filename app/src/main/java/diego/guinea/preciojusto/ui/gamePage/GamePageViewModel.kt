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


    fun getAllDataPageOne(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageOne(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

    fun getAllDataPageTwo(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageTwo(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

    fun getAllDataPageThree(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageThree(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

    fun getAllDataPageFour(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageFour(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

    fun getAllDataPageFive(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageFive(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

    fun getAllDataPageSix(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageSix(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

    fun getAllDataPageSeven(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageSeven(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

    fun getAllDataPageEight(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageEight(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

    fun getAllDataPageNine(){
        livesViewMDL.value = contError
        winsViewMDL.value = contWins
        repositorio.getObjectsPageNine(object : BaseCallback<ObjectsPrice> {
            override fun onResult(result: ObjectsPrice) {
                valuesViewMLD.value = result
            }
            override fun onError(error: Error) {
                errorViewMLD.value = error
            }
        })
    }

}