package com.marvel.ui.character.recyclerview

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.character.Character
import com.marvel.model.user.DataUser
import com.squareup.picasso.Picasso

class CharacterViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    lateinit var favButton: ImageButton
    lateinit var nameCharacter: TextView
    lateinit var nbrSeries: TextView
    lateinit var nbrComics: TextView
    lateinit var nbrStories: TextView

    fun updateCharacter(character: Character) {
        initUI()

        setUpDataCharacter(character)

        managementFav(character)

        setUpCharacterImage(character)
    }

    private fun initUI() {
        favButton = itemView.findViewById(R.id.viewHolderCharacterButtonFav)
        nameCharacter = itemView.findViewById(R.id.viewHolderNameCharacter)
        nbrSeries = itemView.findViewById(R.id.viewHolderCharacterNumberSerie)
        nbrComics = itemView.findViewById(R.id.viewHolderCharacterNumberComics)
        nbrStories = itemView.findViewById(R.id.viewHolderCharacterNumberStories)
    }

    private fun setUpDataCharacter(character: Character) {
        nameCharacter.text = character.name
        nbrSeries.text = character.series.available.toString()
        nbrComics.text = character.comics.available.toString()
        nbrStories.text = character.stories.available.toString()
    }

    private fun managementFav(character: Character) {
        if (DataUser.isCharacterFav(character)) {
            favButton.setColorFilter(Color.argb(255, 255, 0, 0))
        } else {
            favButton.setColorFilter(Color.argb(255, 255, 255, 255))
        }
    }

    private fun setUpCharacterImage(character: Character) {
        val characterImage: ImageView = itemView.findViewById(R.id.viewHolderCharacterIMG)

        val builder = Picasso.Builder(context)
        builder.downloader(OkHttp3Downloader(context))
        builder.build().load(character.thumbnail.path + "." + character.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(characterImage)
    }
}

