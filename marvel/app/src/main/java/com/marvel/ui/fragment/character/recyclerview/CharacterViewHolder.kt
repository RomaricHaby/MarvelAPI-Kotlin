package com.marvel.ui.fragment.character.recyclerview

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.characters.Character
import com.marvel.model.user.DataUser
import com.squareup.picasso.Picasso


class CharacterViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    lateinit var favButton: ImageButton

    fun updateCharacter(character: Character) {
        favButton = itemView.findViewById(R.id.viewHolderCharacterButtonFav)

        val characterImage: ImageView = itemView.findViewById(R.id.viewHolderCharacterIMG)
        val nameCharacter: TextView = itemView.findViewById(R.id.viewHolderNameCharacter)
        val nbrSeries: TextView = itemView.findViewById(R.id.viewHolderCharacterNumberSerie)
        val nbrComics: TextView = itemView.findViewById(R.id.viewHolderCharacterNumberComics)
        val nbrStories: TextView = itemView.findViewById(R.id.viewHolderCharacterNumberStories)

        nameCharacter.text = character.name
        nbrSeries.text = character.series.available.toString()
        nbrComics.text = character.comics.available.toString()
        nbrStories.text = character.stories.available.toString()

        if (DataUser.isCharacterFav(character)) {
            favButton.setColorFilter(Color.argb(255, 255, 0, 0))
        } else {
            favButton.setColorFilter(Color.argb(255, 255, 255, 255))
        }

        val builder = Picasso.Builder(context)
        builder.downloader(OkHttp3Downloader(context))
        builder.build().load(character.thumbnail.path + "." + character.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(characterImage)
    }
}

