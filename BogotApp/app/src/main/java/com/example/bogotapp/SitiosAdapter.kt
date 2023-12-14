package com.example.bogotapp

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bogotapp.databinding.ViewSitioItemBinding

interface SitioClickedListener{
    fun onSitioClickList(sitio: Sitio)
}

class SitiosAdapter(private val sitios:List<Sitio>,
                    private val sitioClickedListener: SitioClickedListener): RecyclerView.Adapter<SitiosAdapter.ViewHolder>(){

    class ViewHolder(private val binding: ViewSitioItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(sitio: Sitio){
            val res = Uri.parse("android.resource://com.example.bogotapp/drawable/"+ sitio.foto)
            binding.foto.setImageURI(res)

            binding.nombre.text = sitio.nombre
            binding.desc.text = sitio.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= ViewSitioItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sitios.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sitios[position])
        holder.itemView.setOnClickListener{sitioClickedListener.onSitioClickList(sitios[position])}
    }
}

