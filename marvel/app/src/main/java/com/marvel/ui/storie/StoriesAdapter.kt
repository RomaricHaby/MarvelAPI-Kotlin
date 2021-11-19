package com.marvel.ui.storie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.stories.Stories

class StoriesAdapter(list: List<Stories>?, private val context: Context) :
    RecyclerView.Adapter<StoriesViewHolder>() {
    private var storiesList: List<Stories>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_stories, parent, false)
        return StoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val item = storiesList?.get(position)
        if (item != null) {
            holder.updateStories(stories = item)
        }
    }

    override fun getItemCount(): Int {
        return storiesList?.size!!
    }
}