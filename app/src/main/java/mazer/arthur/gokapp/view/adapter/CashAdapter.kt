package mazer.arthur.gokapp.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mazer.arthur.gokapp.R
import mazer.arthur.gokapp.domains.model.Cash
import mazer.arthur.gokapp.utils.extensions.inflate

class CashAdapter: RecyclerView.Adapter<CashAdapter.ViewHolder>() {

    var cashList: ArrayList<Cash> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashAdapter.ViewHolder {
        return ViewHolder(inflate(R.layout.item_cash,parent))
    }

    override fun getItemCount(): Int {
        return cashList.size
    }

    override fun onBindViewHolder(holder: CashAdapter.ViewHolder, position: Int) {
        val cash = cashList[position]
        Picasso.get().load(cash.bannerURL).into(holder.thumbnail)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var thumbnail: ImageView = view.findViewById(R.id.ivCash)
    }

}