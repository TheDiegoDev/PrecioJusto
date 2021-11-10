import diego.guinea.preciojusto.data.repository.Repository

//Uso de Singleton para el repositorio
object Single{
    val pjRepository: Repository = Repository()
    fun objectRepository(): Repository {return pjRepository}
}
