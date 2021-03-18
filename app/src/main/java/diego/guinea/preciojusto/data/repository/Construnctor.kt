import diego.guinea.preciojusto.data.repository.Repository

object Single{
    val REPOSITORY: Repository = Repository()
    fun Repository(): Repository {return REPOSITORY}
}
