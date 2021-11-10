package diego.guinea.preciojusto.utils

//Interfaz para usar en el Repostirorio y ViewModel
interface BaseCallback<T> {
    fun onResult(result: T)
    fun onError(error: Error)
}


