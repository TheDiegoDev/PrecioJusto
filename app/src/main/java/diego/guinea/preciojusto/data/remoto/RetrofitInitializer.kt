import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Retrofit Initializer
class RetrofitInitializer(repo: String) {
    private fun getLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
            .log(Platform.INFO)
            .request("Request")
            .response("Response")
            .build()
    }

    private fun getOkClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build()
    }


    private val retrofit = Retrofit.Builder()
        .baseUrl(repo)
        .client(getOkClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun objectServicePageOne() = retrofit.create(ObjectServicePageOne::class.java)
    fun objectServicePageTwo() = retrofit.create(ObjectServicePageTwo::class.java)
    fun objectServicePageThree() = retrofit.create(ObjectServicePageThree::class.java)
    fun objectServicePageFour() = retrofit.create(ObjectServicePageFour::class.java)
    fun objectServicePageFive() = retrofit.create(ObjectServicePageFive::class.java)
    fun objectServicePageSix() = retrofit.create(ObjectServicePageSix::class.java)
    fun objectServicePageSeven() = retrofit.create(ObjectServicePageSeven::class.java)
    fun objectServicePageEight() = retrofit.create(ObjectServicePageEight::class.java)
    fun objectServicePageNine() = retrofit.create(ObjectServicePageNine::class.java)
}