

import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import retrofit2.Call
import retrofit2.http.*


interface ObjectService {
    @GET("n42jhkbeaxp46di/precio.json?dl=1")
    fun listObject() : Call<ObjectsPrice>
}
