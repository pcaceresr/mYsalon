package com.example.mysalon.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mysalon.R
import com.example.mysalon.models.Agenda

class AgendaAdapter(private val ctx: Context, private val miAgenda: List<Agenda>) : BaseAdapter() {


    override fun getCount(): Int {
        return miAgenda.size
    }

    override fun getItem(i: Int): Agenda {
        return miAgenda[i]
    }

    override fun getItemId(i: Int): Long {
        return miAgenda[i].id!!
    }

    override fun getView(i: Int, view: View?, viewGroupt: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)

        val rowview = inflater.inflate(R.layout.item_lista, null)

        val agenda = miAgenda[i]

        val tvTitle = rowview.findViewById<TextView>(R.id.item_tv_title)

        tvTitle.text = agenda.title

        return rowview
    }
}