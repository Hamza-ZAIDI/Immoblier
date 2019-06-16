package com.example.immoblier

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

val announcements = ArrayList<Announcement>()
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val firstHomePictures = ArrayList<String>()
        val secondHomePictures = ArrayList<String>()
        val thirdHomePictures = ArrayList<String>()





        fab.setOnClickListener { view ->
            val intent = Intent(this, newAnnounce::class.java)
            startActivity(intent)
        }

        announcements.add(Announcement(
            "Alger",
            "Bouchaoui 2 181",
            "Villa à Bouchaoui",
            "Villa",
            3,
            1,
            1,
            0,
            1,
            1,
            75.0f,
            firstHomePictures,
            Agent("ZAIDI Moussa", "moussa@gmail.com", 744096126),
            1000000f,
            Date()
        ))

        announcements.add(Announcement(
            "Alger",
            "Bouchaoui 2 181",
            "Villa à Bouchaoui",
            "Villa",
            3,
            1,
            1,
            0,
            1,
            1,
            75.0f,
            secondHomePictures,
            Agent("ZAIDI Moussa", "moussa@gmail.com", 744096126),
            1000000f,
            Date()
        ))

        announcements.add(Announcement(
            "Alger",
            "Bouchaoui 2 181",
            "Villa à Bouchaoui",
            "Villa",
            3,
            1,
            1,
            0,
            1,
            1,
            75.0f,
            thirdHomePictures,
            Agent("ZAIDI Moussa", "moussa@gmail.com", 744096126),
            1000000f,
            Date()
        ))



        val announcementRecycler = findViewById<RecyclerView>(R.id.rvAnnouncements)
        val adapter = HomeRecyclerViewAdapter(announcements, applicationContext)

        announcementRecycler.layoutManager = LinearLayoutManager(applicationContext)
        announcementRecycler.adapter = adapter
    }
}
