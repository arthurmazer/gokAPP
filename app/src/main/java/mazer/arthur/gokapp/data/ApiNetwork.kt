package mazer.arthur.gokapp.data

import mazer.arthur.gokapp.data.entities.ProductsResponse
import retrofit2.http.GET

interface ApiNetwork {

    @GET("products")
    suspend fun fetchProducts(): ProductsResponse
}
