package diego.guinea.preciojusto.data.repository


import RetrofitInitializer
import diego.guinea.preciojusto.utils.PrincipalRepo
import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import diego.guinea.preciojusto.utils.BaseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository() {

    private val characterService = RetrofitInitializer(PrincipalRepo).objectService()


    fun getObjects(callback: BaseCallback<ObjectsPrice>) {

        characterService.listObject().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                    print(response.body())
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }
}






