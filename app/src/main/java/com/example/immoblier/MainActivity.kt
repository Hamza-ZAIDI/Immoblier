package com.example.immoblier

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val announcements = ArrayList<Announcement>()


        val firstHomePictures = ArrayList<Int>()
        val secondHomePictures = ArrayList<Int>()
        val thirdHomePictures = ArrayList<Int>()

        firstHomePictures.add(R.drawable.picture3)
        secondHomePictures.add(R.drawable.picture3)
        thirdHomePictures.add(R.drawable.picture2)


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
