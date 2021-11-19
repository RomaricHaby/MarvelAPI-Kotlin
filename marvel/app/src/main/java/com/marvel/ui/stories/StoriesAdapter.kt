package com.marvel.ui.stories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.stories.Storie

class StoriesAdapter(list: List<Storie>?, private val context: Context) : RecyclerView.Adapter<StoriesViewHolder>() {
    private var storieList: List<Storie>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_stories, parent, false)
        return StoriesViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val items = storieList?.get(position)
        if (items != null) {
            holder.updateStories(storie = items)
        }
    }

    override fun getItemCount(): Int {
        return storieList?.size!!
    }


}