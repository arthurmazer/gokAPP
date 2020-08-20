package mazer.arthur.gokapp.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mazer.arthur.gokapp.R
import mazer.arthur.gokapp.domains.model.Products
import mazer.arthur.gokapp.utils.extensions.inflate

class ProductsAdapter: RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    var productsList: ArrayList<Products> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
        return ViewHolder(inflate(R.layout.item_product,parent))
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        val product = productsList[position]
        Picasso.get().load(product.imageURL).into(holder.thumbnail)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var thumbnail: ImageView = view.findViewById(R.id.ivProduct)
    }

}