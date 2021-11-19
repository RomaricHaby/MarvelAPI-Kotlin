package com.marvel.ui.comics.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.comics.Comic
import com.marvel.ui.detail.ComicsDetailActivity

class ComicsAdapter(list: List<Comic>?, private val context: Context) :
    RecyclerView.Adapter<ComicsViewHolder>() {
    private var comicList: List<Comic>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_comics, parent, false)
        return ComicsViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val items = comicList?.get(position)
        if (items != null) {
            holder.updateComics(comic = items)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ComicsDetailActivity::class.java)
            intent.putExtra("comics", items)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return comicList?.size!!
    }


}