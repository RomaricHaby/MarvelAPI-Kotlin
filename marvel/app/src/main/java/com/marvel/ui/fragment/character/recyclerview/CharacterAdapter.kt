package com.marvel.ui.fragment.character.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {
    private lateinit var characterList: List<Char>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.view_holder_character, parent, false)

        return CharacterViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.updateCharacter(character = characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}