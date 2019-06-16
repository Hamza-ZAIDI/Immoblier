package com.example.immoblier

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class HomeRecyclerViewAdapter(data : ArrayList<Announcement>,internal var context : Context) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.announcement_item, parent, false)

        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        holder.wilaya.text = data[position].wilaya
        holder.address.text = data[position].address
        holder.nbBedRooms.text = data[position].nbBedRooms.toString()
        holder.nbBathRooms.text = data[position].nbBathRooms.toString()
        holder.nbGarages.text = data[position].nbGarages.toString()
        holder.type.text = data[position].type

        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")

        holder.date.text = simpleDateFormat.format(data[position].date)
        val decimalFormat = DecimalFormat()
        decimalFormat.applyPattern("###.## DA")

        holder.price.text = decimalFormat.format(data[position].price)

        if(data[position].pictures.size == 0){
            holder.housePicture.setImageResource(R.drawable.picture2)
        } else {
            holder.housePicture.setImageURI(Uri.parse(data[position].pictures.get(0)))
        }

        holder.detail.setOnClickListener{

            val intent = Intent(context, AnnouncementDetailActivity ::class.java )
            intent.putExtra("wilaya", data[position].wilaya)
            intent.putExtra("adress", data[position].address)
            intent.putExtra("bedrooms", data[position].nbBedRooms)
            intent.putExtra("bathrooms", data[position].nbBathRooms)
            intent.putExtra("garages",data[position].nbGarages)
            intent.putExtra("type",data[position].type)
            intent.putExtra("area",data[position].area)
            intent.putExtra("price", data[position].price)
            val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
            intent.putExtra("date", simpleDateFormat.format(data[position].date))
            intent.putExtra("description", data[position].description)
            intent.putExtra("agentName", data[position].agent.fullName)
            intent.putExtra("agentEmail", data[position].agent.email)
            intent.putExtra("agentPhone",data[position].agent.phoneNumber)
            intent.putExtra("kitchens", data[position].nbKitchens)
            intent.putExtra("pools", data[position].nbPools)
            intent.putExtra("gardens", data[position].nbGardens)
            intent.putExtra("pictures", data[position].pictures)


            context.startActivity(intent)

        }
    }


    internal var data : List<Announcement>

    init {
        this.data = data
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        internal var housePicture : ImageView
        internal var wilaya : TextView
        internal var address : TextView
        internal var nbBedRooms : TextView
        internal var nbBathRooms : TextView
        internal var nbGarages : TextView
        internal var type : TextView
        internal var date : TextView
        internal var price : TextView
        internal var detail : TextView

        init {
            housePicture = itemView.findViewById(R.id.iv_house_picture)
            wilaya = itemView.findViewById(R.id.tv_detail_wilaya)
            address = itemView.findViewById(R.id.tv_detail_address)
            nbBedRooms = itemView.findViewById(R.id.tv_detail_bedrooms)
            nbBathRooms = itemView.findViewById(R.id.tv_detail_bathrooms)
            nbGarages = itemView.findViewById(R.id.tv_detail_garages)
            type = itemView.findViewById(R.id.tvType)
            date = itemView.findViewById(R.id.tv_detail_date)
            price = itemView.findViewById(R.id.tv_house_price)
            detail = itemView.findViewById(R.id.tv_detail)
        }


    }
}