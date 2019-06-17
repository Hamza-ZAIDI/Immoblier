package com.example.immoblier

object DisplayedAnnouncements{

    private lateinit var announcements : ArrayList<Announcement>

    fun setDisplayedAnnouncements(announcements : Collection<Announcement>){
        this.announcements = ArrayList<Announcement>(announcements)
    }

    fun getDisplayedAnnouncements() : ArrayList<Announcement>{
        return this.announcements
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
        if (decs) SimulatedDataBase.announcements.sortByDescending {it.nbBedRooms  }
        else SimulatedDataBase.announcements.sortBy { it.nbBedRooms }
    }

    fun filterAnnouncements(
        wilaya: String?,
        maxPrice: Float?,
        bedRooms: Int?,
        minArea: Float?,
        garages: Int?
    )  :  ArrayList<Announcement>{
        var filteredAnnouncements = announcements.filter { it.wilaya == wilaya }
            .filter { it.price <= maxPrice!! }
            .filter { it.nbBedRooms >= bedRooms!! }
            .filter{it.area >= minArea!!}
            .filter{it.nbGarages >= garages!!}
        announcements = ArrayList(filteredAnnouncements)
        return announcements

    }

}