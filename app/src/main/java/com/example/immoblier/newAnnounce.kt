package com.example.immoblier

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.*
import java.util.*
import java.util.concurrent.TimeUnit

class newAnnounce : AppCompatActivity() {

    val images = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.newannounce)


        val upload = findViewById<Button>(R.id.upload)
        upload.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 1)
        }



        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener {

            val wilaya = findViewById<EditText>(R.id.wilaya).text.toString()
            val name = findViewById<EditText>(R.id.name).text.toString()
            val email = findViewById<EditText>(R.id.email).text.toString()
            val phone = findViewById<EditText>(R.id.phone).text.toString()
            val adrs = findViewById<EditText>(R.id.adresse).text.toString()
            val desc = findViewById<EditText>(R.id.description).text.toString()
            val nbBedRooms = findViewById<EditText>(R.id.nbBedRooms).text.toString()
            val area = findViewById<EditText>(R.id.area).text.toString()
            val price = findViewById<EditText>(R.id.price).text.toString()
            val type =
                findViewById<RadioButton>(findViewById<RadioGroup>(R.id.type).checkedRadioButtonId).text.toString()

            if (!TextUtils.isEmpty(wilaya)
                && !TextUtils.isEmpty(adrs)
                && !TextUtils.isEmpty(desc)
                && !TextUtils.isEmpty(nbBedRooms)
                && !TextUtils.isEmpty(area)
                && !TextUtils.isEmpty(name)
                && !TextUtils.isEmpty(phone)
                && !TextUtils.isEmpty(email)
            ) {

                announcements.add(
                    Announcement(
                        wilaya,
                        adrs,
                        desc,
                        type,
                        nbBedRooms.toInt(),
                        3,
                        1,
                        1,
                        0,
                        1,
                        area.toFloat(),
                        images,
                        Agent(name, email, phone.toInt()),
                        price.toFloat(),
                        Date()
                    )
                )

                Toast.makeText(this, "Announce ajouter !", Toast.LENGTH_SHORT).show()
                TimeUnit.SECONDS.sleep(1L)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }

        }
    }

    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?){
        if ((requestCode == 1) && (resultCode == Activity.RESULT_OK)) {
            if (data!!.data != null) {
                images.add(data.data!!.toString())
            } else if (data.clipData != null) {
                val clipArray = data.clipData
                for (i in 0 until clipArray!!.itemCount) {
                    images.add(clipArray.getItemAt(i).uri.toString())
                }
            }
        }

    }
}
