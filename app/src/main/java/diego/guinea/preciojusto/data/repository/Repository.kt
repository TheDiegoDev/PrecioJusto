package diego.guinea.preciojusto.data.repository


import RetrofitInitializer
import diego.guinea.preciojusto.utils.PrincipalRepo
import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import diego.guinea.preciojusto.utils.BaseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository() {

    private val characterService = RetrofitInitializer(PrincipalRepo).objectServicePageOne()
    private val characterServiceTwo = RetrofitInitializer(PrincipalRepo).objectServicePageTwo()
    private val characterServiceThree = RetrofitInitializer(PrincipalRepo).objectServicePageThree()
    private val characterServiceFour = RetrofitInitializer(PrincipalRepo).objectServicePageFour()
    private val characterServiceFive = RetrofitInitializer(PrincipalRepo).objectServicePageFive()
    private val characterServiceSix = RetrofitInitializer(PrincipalRepo).objectServicePageSix()
    private val characterServiceSeven = RetrofitInitializer(PrincipalRepo).objectServicePageSeven()
    private val characterServiceEight = RetrofitInitializer(PrincipalRepo).objectServicePageEight()
    private val characterServiceNine = RetrofitInitializer(PrincipalRepo).objectServicePageNine()


    //Llamada GET a la API
    fun getObjectsPageOne(callback: BaseCallback<ObjectsPrice>) {

        characterService.listObjectPageOne().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

    fun getObjectsPageTwo(callback: BaseCallback<ObjectsPrice>) {

        characterServiceTwo.listObjectPageTwo().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

    fun getObjectsPageThree(callback: BaseCallback<ObjectsPrice>) {

        characterServiceThree.listObjectPageThree().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

    fun getObjectsPageFour(callback: BaseCallback<ObjectsPrice>) {

        characterServiceFour.listObjectPageFour().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

    fun getObjectsPageFive(callback: BaseCallback<ObjectsPrice>) {

        characterServiceFive.listObjectPageFive().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

    fun getObjectsPageSix(callback: BaseCallback<ObjectsPrice>) {

        characterServiceSix.listObjectPageSix().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

    fun getObjectsPageSeven(callback: BaseCallback<ObjectsPrice>) {

        characterServiceSeven.listObjectPageSeven().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

    fun getObjectsPageEight(callback: BaseCallback<ObjectsPrice>) {

        characterServiceEight.listObjectPageEight().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

    fun getObjectsPageNine(callback: BaseCallback<ObjectsPrice>) {

        characterServiceNine.listObjectPageNine().enqueue(object : Callback<ObjectsPrice> {
            override fun onResponse(call: Call<ObjectsPrice>, response: Response<ObjectsPrice>) {
                if (response.body() == null) {
                    callback.onError(Error("esta vacio"))
                } else {
                    callback.onResult(response.body()!!)
                }
            }
            override fun onFailure(call: Call<ObjectsPrice>, t: Throwable) {
                callback.onError(Error(t))
                print("DIEGO EL ERROR ESTA AQUI: $t")

            }
        })
    }

}






