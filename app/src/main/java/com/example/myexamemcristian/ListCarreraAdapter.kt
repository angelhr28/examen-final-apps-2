package com.example.myexamemcristian

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ListCarreraAdapter (): RecyclerView.Adapter<ListCarreraAdapter.ViewHolder>() {

    private var items: MutableList<Carreras>? = mutableListOf()

    private fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(parent.inflate(R.layout.item_carrera))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bindView(items?.get(position))
    }

    override fun getItemCount(): Int{
        return items?.size ?: 0
    }

    fun setCursos(cursos: List<Carreras>?){
        items?.clear()
        cursos?.let { items?.addAll(it) }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {

        private var lblCarreras        : TextView?  = null
        private var lblDesc      : TextView?  = null
        private var imgCarreras  : ImageView? = null

        fun bindView(item: Carreras?) {
            itemView.apply {
                lblCarreras = findViewById(R.id.lbl_carrera)
                lblDesc     = findViewById(R.id.lbl_desc)
                imgCarreras = findViewById(R.id.img_foto)
                println("llego esto $item")
                lblCarreras?.text = item?.name
                lblDesc?.text = item?.desc

                imgCarreras?.setImageDrawable(item?.img?.let {
                    ContextCompat.getDrawable(context,
                        it
                    )
                })
            }
        }
    }
}