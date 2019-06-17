package com.example.immoblier

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.util.Log
import android.view.View
import android.widget.*

class FilterDialog : AppCompatDialogFragment() , AdapterView.OnItemSelectedListener{

    private lateinit var cancelBtn : Button;
    private lateinit var filterBtn : Button
    private lateinit var filterDialogListener: FilterDialogListener
    private  var selectedType  = ""

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater

        val view = inflater?.inflate(R.layout.filter_dialog, null)
        val spinner: Spinner? = view?.findViewById(R.id.types_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            context,
            R.array.types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner?.adapter = adapter
            spinner?.onItemSelectedListener = this
        }

        builder.setView(view)



        cancelBtn = view?.findViewById(R.id.cancel_filter_btn)!!
        cancelBtn.setOnClickListener(View.OnClickListener {
            this.dismiss()
        })

        filterBtn = view.findViewById(R.id.filter_btn)
        filterBtn.setOnClickListener {

            var maxPrice : Float = Float.MAX_VALUE
            var wilaya = ""
            var bedrooms = 0
            var minArea : Float = Float.MIN_VALUE
            var garages = 0

            val wilayaInput = view.findViewById<EditText>(R.id.et_filter_dlg_wilaya).text.toString()
            val maxPriceInput = view.findViewById<EditText>(R.id.et_max_price).text.toString()
            val bedroomsInput = view.findViewById<EditText>(R.id.et_bedrooms).text.toString()
            val minAreaInput = view.findViewById<EditText>(R.id.et_area).text.toString()
            val garagesInput = view.findViewById<EditText>(R.id.et_garages).text.toString()

            if (wilayaInput != "" ) wilaya = wilayaInput
            if (maxPriceInput != "") maxPrice = maxPriceInput.toFloat()
            if (bedroomsInput != "") bedrooms = bedroomsInput.toInt()
            if (minAreaInput != "") minArea = minAreaInput.toFloat()
            if (garagesInput != "") garages = garagesInput.toInt()



            filterDialogListener.filterAnnouncements(
                wilaya,
                maxPrice,
                bedrooms,
                minArea,
                garages
            )
            this.dismiss()
        }
        return builder.create()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        filterDialogListener = context as FilterDialogListener
    }
    interface FilterDialogListener{
        fun filterAnnouncements(wilaya : String?, maxPrice : Float?, bedRooms : Int?, minArea : Float?, garages : Int?)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       selectedType = parent?.getItemAtPosition(position).toString()

    }


}