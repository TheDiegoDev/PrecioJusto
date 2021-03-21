import diego.guinea.preciojusto.data.repository.Repository

object Single{
    val pjRepository: Repository = Repository()
    fun objectRepository(): Repository {return pjRepository}
}
