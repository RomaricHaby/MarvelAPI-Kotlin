package com.marvel.ui.creator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.creators.Creators


class CreatorAdapter (list: List<Creators>?) : RecyclerView.Adapter<CreatorViewHolder>() {
    private var seriesList: List<Creators>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_creator, parent, false)
        return CreatorViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: CreatorViewHolder, position: Int) {
        val items = seriesList?.get(position)
        if (items != null) {
            holder.updateCreator(items)
        }
    }

    override fun getItemCount(): Int {
        return seriesList?.size!!
    }


}