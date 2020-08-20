package mazer.arthur.gokapp.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import mazer.arthur.gokapp.domains.model.Cash
import mazer.arthur.gokapp.domains.model.Products
import mazer.arthur.gokapp.domains.model.Spotlight

class ProductsResponse(
    @SerializedName("spotlight")
    @Expose
     var spotlight: ArrayList<Spotlight>,

    @SerializedName("products")
    @Expose
    var product: ArrayList<Products>,

    @SerializedName("cash")
    @Expose
    var cash: Cash

)