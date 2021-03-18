package diego.guinea.preciojusto.utils

interface BaseCallback<T> {
    fun onResult(result: T)
    fun onError(error: Error)
}


