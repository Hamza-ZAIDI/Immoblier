package com.example.immoblier

import android.annotation.SuppressLint
import android.content.Context
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
        holder.housePicture.setImageResource(data[position].pictures[0])
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

        init {
            housePicture = itemView.findViewById(R.id.iv_house_picture)
            wilaya = itemView.findViewById(R.id.tvWilaya)
            address = itemView.findViewById(R.id.tvAdress)
            nbBedRooms = itemView.findViewById(R.id.tvBedRooms)
            nbBathRooms = itemView.findViewById(R.id.tvBathroomNumber)
            nbGarages = itemView.findViewById(R.id.tvGarageNumber)
            type = itemView.findViewById(R.id.tvType)
            date = itemView.findViewById(R.id.tvDate)
            price = itemView.findViewById(R.id.tv_house_price)
        }


    }
}