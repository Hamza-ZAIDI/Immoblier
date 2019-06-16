package com.example.immoblier

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.view.View
import android.widget.Button

class FilterDialog : AppCompatDialogFragment() {

    private lateinit var cancelBtn : Button;
    private lateinit var filterBtn : Button
    private lateinit var filterDialogListener: FilterDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater;
        val view = inflater?.inflate(R.layout.filter_dialog, null)
        builder.setView(view)

        cancelBtn = view?.findViewById(R.id.cancel_filter_btn)!!
        cancelBtn.setOnClickListener(View.OnClickListener {
            this.dismiss()
        })

        filterBtn = view?.findViewById(R.id.filter_btn)
        filterBtn.setOnClickListener({
            this.dismiss()
        })
        return builder.create()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        filterDialogListener = context as FilterDialogListener
    }
    interface FilterDialogListener{
        fun filterAnnouncements()
    }

}