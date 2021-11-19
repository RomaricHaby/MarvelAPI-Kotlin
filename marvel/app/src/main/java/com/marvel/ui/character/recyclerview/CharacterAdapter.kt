package com.marvel.ui.character.recyclerview

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.manager.SharedPreferencesManager
import com.marvel.model.character.Character
import com.marvel.model.user.DataUser
import com.marvel.ui.detail.CharacterDetailActivity

class CharacterAdapter(list: List<Character>?, private val context: Context) :
    RecyclerView.Adapter<CharacterViewHolder>() {
    private var characterList: List<Character>? = list


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_character, parent, false)
        return CharacterViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = characterList?.get(position)

        if (item != null) {
            holder.updateCharacter(item)
            onCellClicked(holder, item)
            onButtonFavClicked(holder, item)
        }
    }

    private fun onCellClicked(holder: CharacterViewHolder, items: Character?) {
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CharacterDetailActivity::class.java)
            intent.putExtra("character", items)
            context.startActivity(intent)
        }
    }

    private fun onButtonFavClicked(holder: CharacterViewHolder, items: Character?) {
        holder.favButton.setOnClickListener {
            if (DataUser.isCharacterFav(items)) {
                items?.let { DataUser.removeFavCharacter(it) }

                holder.favButton.setColorFilter(Color.argb(255, 255, 255, 255))
                Toast.makeText(context, items?.name + " retiré des favoris", Toast.LENGTH_SHORT)
                    .show()

            } else {
                items?.let { DataUser.addFavCharacter(it) }

                holder.favButton.setColorFilter(Color.argb(255, 255, 0, 0))
                Toast.makeText(context, items?.name + " ajouté des favoris", Toast.LENGTH_SHORT)
                    .show()
            }

            SharedPreferencesManager.saveAllCharacter(context)
        }
    }

    override fun getItemCount(): Int {
        return characterList?.size!!
    }
}

