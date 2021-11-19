package com.marvel.ui.comic.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.comic.Comic
import com.marvel.ui.detail.ComicsDetailActivity

class ComicAdapter(list: List<Comic>?, private val context: Context) :
    RecyclerView.Adapter<ComicViewHolder>() {
    private var comicList: List<Comic>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_comics, parent, false)
        return ComicViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val item = comicList?.get(position)

        if (item != null) {
            holder.updateComics(comic = item)
            onCellClicked(holder, item)
        }
    }

    private fun onCellClicked(holder: ComicViewHolder, items: Comic?) {
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