package com.example.mysalon.ui


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mysalon.R
import com.example.mysalon.models.Clientes

class ClientesAdapter(private val ctx: Context, private val misClientes: List<Clientes>) : BaseAdapter() {


    override fun getCount(): Int {
        return misClientes.size
    }

    override fun getItem(i: Int): Clientes {
        return misClientes[i]
    }

    override fun getItemId(i: Int): Long {
        return misClientes[i].id!!
    }

    override fun getView(i: Int, view: View?, viewGroupt: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)

        val rowview = inflater.inflate(R.layout.item_lista, null)

        val agenda = misClientes[i]

        val tvTitle = rowview.findViewById<TextView>(R.id.item_tv_title)

        tvTitle.text = agenda.title

        return rowview
    }
}