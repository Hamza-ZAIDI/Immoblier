package com.example.immoblier

import java.util.*
import kotlin.collections.ArrayList

object SimulatedDataBase {
    val agents = ArrayList<Agent>()
    val announcements = ArrayList<Announcement>()

    init {
        agents.add(Agent("ZAIDI Kamel Seif Elislam", "fk_zaidi@esi.dz", "0561725710"))
        agents.add(Agent("AMEDDAH Mohammed Acharaf","fm_ameddah@esi.dz","0657325308"))

        val firstHomePictures = java.util.ArrayList<Int>()
        val secondHomePictures = java.util.ArrayList<Int>()
        val thirdHomePictures = java.util.ArrayList<Int>()

        firstHomePictures.add(R.drawable.images)
        secondHomePictures.add(R.drawable.picture3)
        thirdHomePictures.add(R.drawable.picture2)


        announcements.add(
            Announcement("Zlger",
            "Bouchaoui 2 181, Cheraga Alger",
            "Villa R+2 a Bouchaoui",
            "Villa",
            7,
            3,
            2,
            0,
            3,
            1,
            75f,
                firstHomePictures,
                agents[0],
                15200000f,
                Date()
            )
        )

        announcements.add(
            Announcement("Alger",
                "Bouchaoui 2 181, Cheraga Alger",
                "Villa R+2 a Bouchaoui",
                "Villa",
                7,
                3,
                2,
                0,
                3,
                1,
                75f,
                firstHomePictures,
                agents[0],
                15300000f,
                Date()
            )
        )

        announcements.add(
            Announcement("Alger",
                "Bouchaoui 2 181, Cheraga Alger",
                "Villa R+2 a Bouchaoui",
                "Villa",
                7,
                3,
                2,
                0,
                3,
                1,
                75f,
                firstHomePictures,
                agents[0],
                17300000f,
                Date()
            )
        )

        announcements.add(
            Announcement("Alger",
                "Bouchaoui 2 181, Cheraga Alger",
                "Villa R+2 a Bouchaoui",
                "Villa",
                7,
                3,
                2,
                0,
                3,
                1,
                75f,
                firstHomePictures,
                agents[0],
                14300000f,
                Date()
            )
        )


        announcements.add(
            Announcement("Blger",
                "Bouchaoui 2 181, Cheraga Alger",
                "Villa R+2 a Bouchaoui",
                "Villa",
                7,
                3,
                2,
                0,
                3,
                1,
                75f,
                firstHomePictures,
                agents[0],
                10000000f,
                Date()
            )
        )

        announcements.add(
            Announcement("Clger",
                "Bouchaoui 2 181, Cheraga Alger",
                "Villa R+2 a Bouchaoui",
                "Villa",
                7,
                3,
                2,
                0,
                3,
                1,
                75f,
                firstHomePictures,
                agents[0],
                18000000f,
                Date()
            )
        )
    }




}