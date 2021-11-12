package com.marvel.ui.stories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.stories.Stories

class StoriesAdapter(list: List<Stories>?) : RecyclerView.Adapter<StoriesViewHolder>() {
    private var storiesList: List<Stories>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_stories, parent, false)
        return StoriesViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val items = storiesList?.get(position)
        if (items != null) {
            holder.updateStories(stories = items)
        }
    }

    override fun getItemCount(): Int {
        return storiesList?.size!!
    }


}