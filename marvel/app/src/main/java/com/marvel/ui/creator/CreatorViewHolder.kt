package com.marvel.ui.creator

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.creators.Creator


class CreatorViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

    fun updateCreator(creator: Creator) {

        val nameCreators: TextView = itemView.findViewById(R.id.viewHolderNameCreator)

        nameCreators.text = creator.fullName
    }
}