package diego.guinea.preciojusto.ui.shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.utils.allowedCardAuthMethods
import diego.guinea.preciojusto.utils.allowedCardNetworks
import org.json.JSONObject

//Aun por hacer y entender como funciona GooglePay

class ShopCoin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopcoin)
    }

    private fun gatewayTokenizationSpecification(): JSONObject {
        return JSONObject().apply {
            put("type", "PAYMENT_GATEWAY")
            put("parameters", JSONObject(mapOf(
                "gateway" to "allpayments",
                "gatewayMerchantId" to "exampleGatewayMerchantId")))
        }
    }
    private fun baseCardPaymentMethod(): JSONObject {
        return JSONObject().apply {

            val parameters = JSONObject().apply {
                put("allowedAuthMethods", allowedCardAuthMethods)
                put("allowedCardNetworks", allowedCardNetworks)
                put("billingAddressRequired", true)
                put("billingAddressParameters", JSONObject().apply {
                    put("format", "FULL")
                })
            }

            put("type", "CARD")
            put("parameters", parameters)
        }
    }

    private fun cardPaymentMethod(): JSONObject {
        val cardPaymentMethod = baseCardPaymentMethod()
        cardPaymentMethod.put("tokenizationSpecification", gatewayTokenizationSpecification())

        return cardPaymentMethod
    }

}

