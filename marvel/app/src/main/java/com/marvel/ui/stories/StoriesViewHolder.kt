package com.marvel.ui.stories

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.stories.Stories

class StoriesViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    fun updateStories(stories: Stories) {
        val nameStories: TextView = itemView.findViewById(R.id.viewHolderNameStories)

        nameStories.text = stories.title
    }
}