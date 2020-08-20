package mazer.arthur.gokapp.data

import android.content.Context

class ProductsRepository(private val apiHelper: ApiHelper, context: Context) {

    suspend fun getProducts() = apiHelper.getProducts()
}