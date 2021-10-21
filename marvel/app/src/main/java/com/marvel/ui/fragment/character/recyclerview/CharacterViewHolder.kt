package com.marvel.ui.fragment.character.recyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.characters.Hero

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private var  characterImage: ImageView = itemView.findViewById<ImageView>(R.id.viewHolderCharacter)


    fun updateCharacter(character: Hero)  {
        val nameCharacter: TextView = itemView.findViewById(R.id.viewHolderNameCharacter)

        nameCharacter.text = "test"
        nameCharacter.text = character.name
    }
}

