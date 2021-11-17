

import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import retrofit2.Call
import retrofit2.http.*

//Llamada GET
interface PageService {
    @GET("api/tasks")
    fun getPage(@Query("page")page:String) : Call<ObjectsPrice>
}

//n42jhkbeaxp46di/precio.json?dl=1
//https://www.dropbox.com/s/n42jhkbeaxp46di/precio.json?dl=0
