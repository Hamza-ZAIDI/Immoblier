package com.example.immoblier

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.Toast

class SortDialog : AppCompatDialogFragment() {

    private lateinit var cancelBtn : Button;
    private lateinit var sortBtn : Button
    private lateinit var sortDialogListener: SortDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater;
        val view = inflater?.inflate(R.layout.sort_dialog, null)
        builder.setView(view)

        cancelBtn = view?.findViewById(R.id.cancel_sort_btn)!!
        cancelBtn.setOnClickListener(View.OnClickListener {
            dialog.hide()
        })

        sortBtn = view?.findViewById(R.id.sort_btn)
        sortBtn.setOnClickListener({
            SimulatedDataBase.sortByWilaya()
            sortDialogListener.sortAnnouncements()
            this.dismiss()
        })
        return builder.create()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        sortDialogListener = context as SortDialogListener
    }
    interface SortDialogListener{
        fun sortAnnouncements()
    }

    public fun setDialogListener(dialogListener: SortDialogListener){
        this.sortDialogListener = dialogListener
    }




}