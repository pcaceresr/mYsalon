package com.example.mysalon.ui


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mysalon.R
import com.example.mysalon.models.Cliente

class ClientesAdapter(private val ctx: Context, private val clientes: List<Cliente>) : BaseAdapter() {


    override fun getCount(): Int {
        return clientes.size
    }

    override fun getItem(i: Int): Cliente {
        return clientes[i]
    }

    override fun getItemId(i: Int): Long {
        return clientes[i].id!!
    }

    override fun getView(i: Int, view: View?, viewGroupt: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)

        val rowview = inflater.inflate(R.layout.item_lista, null)

        val cliente = clientes[i]

        val tvTitle = rowview.findViewById<TextView>(R.id.item_tv_title)
        //se coloca el valor que se quiere mostrar
        tvTitle.text = cliente.nombresApellidos
        return rowview
    }
}