package com.marvel.ui.fragment.character.recyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {

    private lateinit var lastPosition: TextView
    private lateinit var  fav: ImageView

    fun updateCharacter(character: Char) {

    }
}