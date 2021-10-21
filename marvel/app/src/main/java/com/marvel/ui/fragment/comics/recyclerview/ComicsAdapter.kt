package com.marvel.ui.fragment.comics.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.characters.Hero
import com.marvel.modele.comics.Comics
import com.marvel.ui.fragment.character.recyclerview.CharacterViewHolder

class ComicsAdapter (list: List<Comics>?) : RecyclerView.Adapter<ComicsViewHolder>() {
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
    }

    override fun getItemCount(): Int {
        return comicsList?.size!!
    }


}