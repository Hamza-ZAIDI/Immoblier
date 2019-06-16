package com.example.immoblier

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class AnnouncementDetailActivity : AppCompatActivity(), AgentDetailsDialog.AgentDetailsListener {


    private lateinit var fullName: String
    private lateinit var email: String
    private lateinit var phone: String
    override fun getFullName(): String {
        return fullName
    }

    override fun getEmail(): String {
        return email
    }

    override fun getPhone(): String {
        return phone
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.announcemets_details)


        setDetails()

    }

    private fun setDetails(){
        val wilaya = intent.getStringExtra("wilaya")
        val adress = intent.getStringExtra("adress")
        val bedrooms = intent.getIntExtra("bedrooms",0)
        val bathrooms = intent.getIntExtra("bathrooms",0)
        val garages = intent.getIntExtra("garages", 0)
        val type = intent.getStringExtra("type")
        val area = intent.getFloatExtra("area", 0f)
        val price = intent.getFloatExtra("price", 0f)
        val date = intent.getStringExtra("date")
        val description = intent.getStringExtra("description")
        fullName = intent.getStringExtra("agentName")
        email = intent.getStringExtra("agentEmail")
        phone = intent.getStringExtra("agentPhone")
        val kitchens = intent.getIntExtra("kitchens",0)
        val pools = intent.getIntExtra("pools",0)
        val gardens = intent.getIntExtra("gardens",0)
        val pictures = intent.getIntegerArrayListExtra("pictures")

        val decimalFormatArea = DecimalFormat()

        decimalFormatArea.applyPattern("###.##")

        findViewById<TextView>(R.id.tv_detail_area).text = decimalFormatArea.format(area)

        val decimalFormatPrice = DecimalFormat()
        decimalFormatPrice.applyPattern("###.## DA")
        findViewById<TextView>(R.id.tv_detail_price).text = decimalFormatPrice.format(price)

        findViewById<TextView>(R.id.tv_detail_date).text = date
        findViewById<TextView>(R.id.tv_detail_description).text = description
        findViewById<TextView>(R.id.tv_detail_kitchens).text = kitchens.toString()
        findViewById<TextView>(R.id.tv_detail_pool).text = pools.toString()
        findViewById<TextView>(R.id.tv_detail_garden).text = gardens.toString()


        val tvWilaya = findViewById<TextView>(R.id.tv_detail_wilaya)
        tvWilaya.text = wilaya

        val tvAddress = findViewById<TextView>(R.id.tv_detail_address)
        tvAddress.text = adress

        val  tvBedrooms = findViewById<TextView>(R.id.tv_detail_bedrooms)
        tvBedrooms.text = bedrooms.toString()

        val tvBedRoomsText = findViewById<TextView>(R.id.tv_detail_bedrooms_txt)
        tvBedRoomsText.text = bedrooms.toString()

        val tvBathrooms = findViewById<TextView>(R.id.tv_detail_bathrooms)
        tvBathrooms.text = bathrooms.toString()

        val tvBathroomsText = findViewById<TextView>(R.id.tv_detail_bathrooms_txt)
        tvBathroomsText.text = bathrooms.toString()

        findViewById<TextView>(R.id.tv_detail_garages).text = garages.toString()
        findViewById<TextView>(R.id.tv_detail_garages_txt).text = garages.toString()
        findViewById<TextView>(R.id.tv_detail_type).text = type

        val agentBtn = findViewById<Button>(R.id.agent_detail_btn)
        agentBtn.setOnClickListener{
            showAgentDetails()
        }



    }

    private fun showAgentDetails(){
        val dialog = AgentDetailsDialog()
        dialog.show(supportFragmentManager, "Agent Dialog")
    }
}