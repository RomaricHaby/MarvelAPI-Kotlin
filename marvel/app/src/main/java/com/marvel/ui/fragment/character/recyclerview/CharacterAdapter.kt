package com.marvel.ui.fragment.character.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.characters.Character
import com.marvel.model.user.DataUser
import com.marvel.ui.activity.CharacterDetailActivity


class CharacterAdapter(list: List<Character>?, private val context: Context) :
    RecyclerView.Adapter<CharacterViewHolder>() {
    private var characterList: List<Character>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_character, parent, false)
        return CharacterViewHolder(view, parent.context)
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val items = characterList?.get(position)
        if (items != null) {
            holder.updateCharacter(items)
        }

        //Click sur le view holder
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CharacterDetailActivity::class.java)
            intent.putExtra("character", items)
            context.startActivity(intent)
        }

        //Click sur le button fav dans le view holder
        holder.favButton.setOnClickListener {
            if (DataUser.isCharacterFav(items)) {
                DataUser.removeFavCharacter(items)

                Toast.makeText(context, items?.name + " retiré des favoris", Toast.LENGTH_SHORT).show()
            } else {
                DataUser.addFavCharacter(items)

                Toast.makeText(context, items?.name + " ajouté des favoris", Toast.LENGTH_SHORT).show()
            }
        }

    }


    override fun getItemCount(): Int {
        return characterList?.size!!
    }
}

