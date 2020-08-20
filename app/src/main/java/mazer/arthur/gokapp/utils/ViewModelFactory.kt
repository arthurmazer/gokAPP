    package mazer.arthur.gokapp.utils

    import android.content.Context
    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.ViewModelProvider
    import mazer.arthur.gokapp.data.ApiHelper
    import mazer.arthur.gokapp.data.ProductsRepository
    import mazer.arthur.gokapp.view.MainViewModel

    class ViewModelFactory(private val apiHelper: ApiHelper, private val context: Context) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(
                    ProductsRepository(
                        apiHelper,
                        context
                    )
                ) as T

            }
            throw IllegalArgumentException("Class name not found")
        }
    }