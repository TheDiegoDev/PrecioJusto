package diego.guinea.preciojusto.data.modelo

//Modelo de datos CardView
class AlphaChar {

    var id: Int ? = 0
    var iconChar: Int ? = 0
    var alphaChar: String ? = null

    constructor(id: Int?,iconChar: Int?, alphaChar: String?) {
        this.id = id
        this.iconChar = iconChar
        this.alphaChar = alphaChar
    }
}