package diego.guinea.preciojusto.data.modelo


import kotlinx.android.parcel.RawValue
import java.io.Serializable

data class Precios(
    var primero: String?,
    var segundo: String?) : Serializable

data class ObjectsPJ(
    var id: Int?,
    var name: String?,
    var foto: String?,
    var descripcion: String?,
    var precio: String?,
    var precios: @RawValue Precios) : Serializable

data class ObjectsPrice(var objetos: List<ObjectsPJ>)



