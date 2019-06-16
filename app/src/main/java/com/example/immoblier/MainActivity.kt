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


import java.util.*

class MainActivity : AppCompatActivity(), SortDialog.SortDialogListener {

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
        announcementRecycler = findViewById<RecyclerView>(R.id.rvAnnouncements)
        adapter = HomeRecyclerViewAdapter(SimulatedDataBase.announcements, applicationContext)


        announcementRecycler.layoutManager = LinearLayoutManager(applicationContext)
        announcementRecycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.home_view_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId){
            R.id.sort_ic -> {
                openSortDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openSortDialog(){
        val dialog = SortDialog()
        dialog.show(supportFragmentManager, "Sort Dialog")

    }

    override fun sortAnnouncements(criteria: Int, desc : Boolean) {

        when(criteria){
            0 -> SimulatedDataBase.sortByWilaya(desc)
            1 -> SimulatedDataBase.sortByPrice(desc)
            2-> SimulatedDataBase.sortByType(desc)
            3-> SimulatedDataBase.sortByBedrooms(desc)
        }

        adapter = HomeRecyclerViewAdapter(SimulatedDataBase.announcements, applicationContext)
        announcementRecycler.adapter = adapter
    }
}
