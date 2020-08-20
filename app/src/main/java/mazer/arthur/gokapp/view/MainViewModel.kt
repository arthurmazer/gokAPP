package mazer.arthur.gokapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import mazer.arthur.gokapp.data.ProductsRepository
import mazer.arthur.gokapp.data.Response

class MainViewModel(private val productsRepository: ProductsRepository): ViewModel() {

    fun getProducts() = liveData(Dispatchers.IO){
        emit(Response.loading())
        try{
            emit(Response.success(productsRepository.getProducts()))
        } catch (ex: Exception){
            emit(Response.error(null, "Error fetching banner list"))
        }
    }
}