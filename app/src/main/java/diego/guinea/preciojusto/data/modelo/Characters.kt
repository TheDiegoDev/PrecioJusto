package diego.guinea.preciojusto.data.modelo


import java.io.Serializable

//Modelo de datos
data class ObjectsPJ(
    var id: Int?,
    var name: String?,
    var foto: String?,
    var descripcion: String?,
    var precio: String?,
    var primero: String?,
    var segundo: String?) : Serializable

data class ObjectsPrice(var objetos: List<ObjectsPJ>)



