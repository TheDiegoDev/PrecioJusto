package diego.guinea.preciojusto.data.modelo


import java.io.Serializable


data class ObjectsPJ(
    var id: Int?,
    var name: String?,
    var foto: String?,
    var descripcion: String?,
    var precio: String?) : Serializable

class ObjectsPrice(var results: List<ObjectsPJ>)



