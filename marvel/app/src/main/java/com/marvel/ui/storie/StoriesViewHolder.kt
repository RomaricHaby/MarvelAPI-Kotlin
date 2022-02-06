package com.marvel.ui.storie

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.stories.Stories

class StoriesViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private lateinit var nameStories: TextView

    fun updateStories(stories: Stories) {
        initUI()

        setUpDataStories(stories)
    }

    private fun initUI() {
        nameStories = itemView.findViewById(R.id.viewHolderNameStories)
    }

    private fun setUpDataStories(stories: Stories) {
        nameStories.text = stories.title
    }
}