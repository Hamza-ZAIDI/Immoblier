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


    fun sortByWilaya(decs : Boolean){
        if (decs) announcements.sortByDescending {it.wilaya  }
        else announcements.sortBy { it.wilaya }
    }

    fun sortByPrice(decs : Boolean){
        if (decs) announcements.sortByDescending {it.price  }
        else announcements.sortBy { it.price }
    }

    fun sortByArea(decs : Boolean){
        if (decs) announcements.sortByDescending {it.area  }
        else announcements.sortBy { it.area }
    }

    fun sortByType(decs : Boolean){
        if (decs) announcements.sortByDescending {it.type  }
        else announcements.sortBy { it.type }
    }

    fun sortByBedrooms(decs : Boolean){
        if (decs) announcements.sortByDescending {it.nbBedRooms  }
        else announcements.sortBy { it.nbBedRooms }
    }




}