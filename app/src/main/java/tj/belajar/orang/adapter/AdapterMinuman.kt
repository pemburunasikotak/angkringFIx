package tj.belajar.orang.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tj.belajar.orang.R
import tj.belajar.orang.model.makan.Makanan
import tj.belajar.orang.model.minum.Minuman

class AdapterMinuman (private val minumadapter: ArrayList<Minuman>):RecyclerView.Adapter<AdapterMinuman.MyViewHolder>(){



    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragmant_menumakan, viewGroup, false)
        return MyViewHolder(view)

    }

    override fun getItemCount()= minumadapter.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val data = minumadapter[position]
        holder.tvName.text  = data.namaMinum
        holder.tvDetail.text = data.hargaMinum
        Glide.with(holder.item.context)
            .load(data.gambarMinum)
            .override(200,200)
            .apply(RequestOptions())
            .into(holder.imgPhoto)
    }


    //class  yang harus dibuat ketika membuat extend
    inner class MyViewHolder(val item: View): RecyclerView.ViewHolder(item) {

        var tvName: TextView = item.findViewById(R.id.textJudul_minum)
        var tvDetail: TextView = item.findViewById(R.id.tvharga_minum)
        var imgPhoto: ImageView = item.findViewById(R.id.imageView)

    }

}
