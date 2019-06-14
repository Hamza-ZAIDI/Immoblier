package com.example.immoblier

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import java.util.*

class newAnnounce : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newannounce)


        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener {

            val wilaya = findViewById<EditText>(R.id.wilaya).text.toString()
            val adrs = findViewById<EditText>(R.id.adresse).text.toString()
            val desc = findViewById<EditText>(R.id.description).text.toString()
            val nbBedRooms = findViewById<EditText>(R.id.nbBedRooms).text as Int
            val area = findViewById<EditText>(R.id.area).text.toString() as Float
            val price = findViewById<EditText>(R.id.price).text.toString() as Float
            val type = findViewById<RadioButton>(findViewById<RadioGroup>(R.id.type).checkedRadioButtonId).text.toString()


            val thirdHomePictures = ArrayList<Int>()
            thirdHomePictures.add(R.drawable.picture2)

            announcements.add(Announcement(
                wilaya,
                adrs,
                desc,
                type,
                nbBedRooms,
                3,
                1,
                1,
                0,
                1,
                area,
                thirdHomePictures,
                Agent("ZAIDI Moussa", "moussa@gmail.com", 744096126),
                price,
                Date()
            ))


        }
    }
}