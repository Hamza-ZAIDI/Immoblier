package com.example.immoblier

import android.annotation.SuppressLint
import android.location.Criteria
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), SortDialog.SortDialogListener, FilterDialog.FilterDialogListener {


    private lateinit var toolbar: Toolbar
    private lateinit var announcementRecycler : RecyclerView
    private lateinit var adapter: HomeRecyclerViewAdapter

    @SuppressLint("ResourceAsColor")
    private fun createToolbar(){

        toolbar = findViewById(R.id.homeViewToolBar)
        setSupportActionBar(toolbar)

        supportActionBar?.setTitle(R.string.home_view_title)
        toolbar.setTitleTextColor(R.color.actionBarTextColor)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createToolbar()
        DisplayedAnnouncements.setDisplayedAnnouncements(SimulatedDataBase.announcements)
        announcementRecycler = findViewById<RecyclerView>(R.id.rvAnnouncements)
        adapter = HomeRecyclerViewAdapter(DisplayedAnnouncements.getDisplayedAnnouncements(), applicationContext)


        announcementRecycler.layoutManager = LinearLayoutManager(applicationContext)
        announcementRecycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.home_view_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId){
            R.id.sort_ic -> {openSortDialog()}

            R.id.filter_ic -> {openFilterDialog()}

            R.id.refresh_ic -> {
                DisplayedAnnouncements.setDisplayedAnnouncements(SimulatedDataBase.announcements)
                adaptRecyclerView(DisplayedAnnouncements.getDisplayedAnnouncements())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openSortDialog(){
        val dialog = SortDialog()
        dialog.show(supportFragmentManager, "Sort Dialog")

    }

    private fun openFilterDialog(){
        val dialog = FilterDialog()
        dialog.show(supportFragmentManager, "Filter Dialog")

    }

    private fun adaptRecyclerView(announcements : ArrayList<Announcement>){
        adapter = HomeRecyclerViewAdapter(announcements, applicationContext)
        announcementRecycler.adapter = adapter
    }

    override fun sortAnnouncements(criteria: Int, desc : Boolean) {

        when(criteria){
            0 -> DisplayedAnnouncements.sortByWilaya(desc)
            1 -> DisplayedAnnouncements.sortByPrice(desc)
            2-> DisplayedAnnouncements.sortByType(desc)
            3-> DisplayedAnnouncements.sortByBedrooms(desc)
        }

        adaptRecyclerView(DisplayedAnnouncements.getDisplayedAnnouncements())

    }

    override fun filterAnnouncements(
        wilaya: String?,
        maxPrice: Float?,
        bedRooms: Int?,
        minArea: Float?,
        garages: Int?
    ) {
        adaptRecyclerView(DisplayedAnnouncements.filterAnnouncements(wilaya,maxPrice,bedRooms,minArea,garages))

        Toast.makeText(applicationContext,"OK", Toast.LENGTH_SHORT).show()
    }
}
