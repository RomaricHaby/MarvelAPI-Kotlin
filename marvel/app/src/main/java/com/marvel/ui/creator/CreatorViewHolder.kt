package com.marvel.ui.creator

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.creator.Creator


class CreatorViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private lateinit var nameCreator: TextView

    fun updateCreator(creator: Creator) {
        initIU()

        setUpDataCreator(creator)
    }

    private fun setUpDataCreator(creator: Creator) {
        nameCreator.text = creator.fullName
    }

    private fun initIU() {
        nameCreator = itemView.findViewById(R.id.viewHolderNameCreator)
    }
}