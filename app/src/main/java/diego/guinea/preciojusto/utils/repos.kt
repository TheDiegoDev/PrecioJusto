package diego.guinea.preciojusto.utils

import com.google.android.material.chip.Chip
import org.json.JSONArray
import org.json.JSONObject

//API Url
const val PrincipalRepo = "http://217.71.207.223:3000/"

//Links WebView
var Linkedin = "https://www.linkedin.com/in/diego-guinea-yurrita-7607b5207"
var GitHub = "https://github.com/TheDiegoDev"

//Variables de uso en la APP
var Sonido = 0
var Monedas = 0
var contWins = 0
var contError = 2

//Values para Shop//Implementacion de pago por Goolge pay
val baseRequest = JSONObject().apply {
    put("apiVersion", 2)
    put("apiVersionMinor", 0)
}
val allowedCardNetworks = JSONArray(listOf(
    "MASTERCARD",
    "VISA"))

val allowedCardAuthMethods = JSONArray(listOf(
    "PAN_ONLY",
    "CRYPTOGRAM_3DS"))



//BD en local
const val LLamadaDB =
    "CREATE TABLE persons(id int(4)," + "name varchar(100),"+
            "species varchar(100)," + "image varchar(100)," + "status varchar(100),"+ "gender varchar(100),"+
            "type varchar(100),"+ "location varchar(100),"+ "origen varchar(100))"
const val tabla2 =
    "CREATE TABLE url(id int(4),"+"name varchar(100),"+"type varchar(100),"+"dimension varchar(100))"


