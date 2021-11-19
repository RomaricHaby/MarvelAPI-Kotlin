package com.marvel.ui.stories

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.stories.Storie

class StoriesViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    fun updateStories(storie: Storie) {
        val nameStories: TextView = itemView.findViewById(R.id.viewHolderNameStories)

        nameStories.text = storie.title
    }
}