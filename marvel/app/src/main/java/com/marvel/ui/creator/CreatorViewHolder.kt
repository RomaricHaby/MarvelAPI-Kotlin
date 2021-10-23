package com.marvel.ui.creator

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.creators.Creators


class CreatorViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

    fun updateCreator(creators: Creators) {

        val nameCreators: TextView = itemView.findViewById(R.id.viewHolderNameCreator)

        nameCreators.text = creators.fullName

    }
}