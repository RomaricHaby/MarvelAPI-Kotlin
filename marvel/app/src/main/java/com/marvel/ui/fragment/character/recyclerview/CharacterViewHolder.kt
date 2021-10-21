package com.marvel.ui.fragment.character.recyclerview


import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.modele.characters.Hero
import com.squareup.picasso.Picasso


class CharacterViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {
    fun updateCharacter(character: Hero) {
        val characterImage: ImageView = itemView.findViewById(R.id.viewHolderCharacterIMG)
        val nameCharacter: TextView = itemView.findViewById(R.id.viewHolderNameCharacter)
        val nbrSeries: TextView = itemView.findViewById(R.id.viewHolderCharacterNumberSerie)
        val nbrComics: TextView = itemView.findViewById(R.id.viewHolderCharacterNumberComics)
        val nbrStories: TextView = itemView.findViewById(R.id.viewHolderCharacterNumberStories)

        nameCharacter.text = character.name
        nbrSeries.text = character.series.available.toString()
        nbrComics.text = character.comics.available.toString()
        nbrStories.text = character.stories.available.toString()

        val builder = Picasso.Builder(context)
        builder.downloader(OkHttp3Downloader(context))
        builder.build().load(character.thumbnail.path + "." + character.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(characterImage)
    }
}

