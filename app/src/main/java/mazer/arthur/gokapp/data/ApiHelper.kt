package mazer.arthur.gokapp.data

class ApiHelper(private val api: ApiNetwork) {

    suspend fun getProducts() = api.fetchProducts()
}