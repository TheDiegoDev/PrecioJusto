

import diego.guinea.preciojusto.data.modelo.ObjectsPrice
import retrofit2.Call
import retrofit2.http.*


interface ObjectServicePageOne {
    @GET("api/tasks?size=20&page=0")
    fun listObjectPageOne() : Call<ObjectsPrice>
}

interface ObjectServicePageTwo {
    @GET("api/tasks?size=20&page=1")
    fun listObjectPageTwo() : Call<ObjectsPrice>
}

interface ObjectServicePageThree {
    @GET("api/tasks?size=20&page=2")
    fun listObjectPageThree() : Call<ObjectsPrice>
}

interface ObjectServicePageFour {
    @GET("api/tasks?size=20&page=3")
    fun listObjectPageFour() : Call<ObjectsPrice>
}
interface ObjectServicePageFive {
    @GET("api/tasks?size=20&page=4")
    fun listObjectPageFive() : Call<ObjectsPrice>
}
interface ObjectServicePageSix {
    @GET("api/tasks?size=20&page=5")
    fun listObjectPageSix() : Call<ObjectsPrice>
}
interface ObjectServicePageSeven {
    @GET("api/tasks?size=20&page=6")
    fun listObjectPageSeven() : Call<ObjectsPrice>
}
interface ObjectServicePageEight {
    @GET("api/tasks?size=20&page=7")
    fun listObjectPageEight() : Call<ObjectsPrice>
}
interface ObjectServicePageNine {
    @GET("api/tasks?size=20&page=8")
    fun listObjectPageNine() : Call<ObjectsPrice>
}

//n42jhkbeaxp46di/precio.json?dl=1
//https://www.dropbox.com/s/n42jhkbeaxp46di/precio.json?dl=0
