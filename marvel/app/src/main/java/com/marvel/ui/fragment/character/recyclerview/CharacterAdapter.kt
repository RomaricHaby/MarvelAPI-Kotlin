package com.marvel.ui.fragment.character.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.characters.Hero
import com.marvel.ui.activity.CharacterDetailActivity


class CharacterAdapter(list: List<Hero>?, private val context: Context) : RecyclerView.Adapter<CharacterViewHolder>() {
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

       holder.itemView.setOnClickListener{
           val intent = Intent(context, CharacterDetailActivity::class.java)
           intent.putExtra("character", items)
           context.startActivity(intent)
       }
    }


    override fun getItemCount(): Int {
        return characterList?.size!!
    }
}

