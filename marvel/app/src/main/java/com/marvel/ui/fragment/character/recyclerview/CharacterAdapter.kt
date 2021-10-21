package com.marvel.ui.fragment.character.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.characters.Hero

class CharacterAdapter(list: List<Hero>?) : RecyclerView.Adapter<CharacterViewHolder>() {
    private var characterList: List<Hero>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_character, parent, false)
        return CharacterViewHolder(view, parent.context)
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val items = characterList?.get(position)
        if (items != null) {
            holder.updateCharacter(items)
        }
    }

    override fun getItemCount(): Int {
        return characterList?.size!!
    }
}
