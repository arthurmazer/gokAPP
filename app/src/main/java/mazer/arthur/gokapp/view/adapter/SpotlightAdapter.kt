package mazer.arthur.gokapp.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mazer.arthur.gokapp.R
import mazer.arthur.gokapp.domains.model.Spotlight
import mazer.arthur.gokapp.utils.extensions.inflate

class SpotlightAdapter: RecyclerView.Adapter<SpotlightAdapter.ViewHolder>() {


    var spotlightList: ArrayList<Spotlight> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotlightAdapter.ViewHolder {
        return ViewHolder(inflate(R.layout.item_spotlight,parent))
    }

    override fun getItemCount(): Int {
        return spotlightList.size
    }

    override fun onBindViewHolder(holder: SpotlightAdapter.ViewHolder, position: Int) {
        val spotlight = spotlightList[position]
        Picasso.get().load(spotlight.bannerURL).into(holder.thumbnail)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var thumbnail: ImageView = view.findViewById(R.id.ivSpotlight)
    }

}