package com.marvel.ui.fragment.comics.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.characters.Hero
import com.marvel.modele.comics.Comics
import com.marvel.ui.activity.CharacterDetailActivity
import com.marvel.ui.activity.ComicsDetailActivity
import com.marvel.ui.fragment.character.recyclerview.CharacterViewHolder

class ComicsAdapter (list: List<Comics>?, private val context: Context) : RecyclerView.Adapter<ComicsViewHolder>() {
    private var comicsList: List<Comics>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_comics, parent, false)
        return ComicsViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val items = comicsList?.get(position)
        if (items != null) {
            holder.updateComics(comics = items)
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(context, ComicsDetailActivity::class.java)
            intent.putExtra("comics", items)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return comicsList?.size!!
    }


}