package com.example.immoblier

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.view.View
import android.widget.*

class AgentDetailsDialog() : AppCompatDialogFragment() {

    private lateinit var agentDetailsListener: AgentDetailsListener



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater;
        val view = inflater?.inflate(R.layout.agent_detail, null)

        builder.setView(view)

        view?.findViewById<TextView>(R.id.tv_agent_detail_fullname)?.text = agentDetailsListener.getFullName()
        view?.findViewById<TextView>(R.id.tv_agent_detail_email)?.text = agentDetailsListener.getEmail()
        view?.findViewById<TextView>(R.id.tv_agent_detail_phone)?.text = agentDetailsListener.getPhone()

        view?.findViewById<Button>(R.id.agent_detail_btn)?.setOnClickListener{
            this.dismiss()
        }
        return builder.create()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        agentDetailsListener = context as AgentDetailsListener
    }
    interface AgentDetailsListener{
        fun getFullName() : String
        fun getEmail() : String
        fun getPhone() : String
    }

}