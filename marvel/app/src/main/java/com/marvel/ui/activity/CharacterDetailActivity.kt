package com.marvel.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.modele.characters.Hero
import com.marvel.ui.fragment.comics.recyclerview.ComicsAdapter
import com.marvel.usecase.character.GetCharacterComicsUseCase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class CharacterDetailActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var imageCharacter: ImageView
    private lateinit var nameCharacter: TextView
    private lateinit var recyclerViewComics: RecyclerView


    private lateinit var character: Hero


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        unitUI()

        character = intent.getSerializableExtra("character") as Hero

        setImageCharacter()
        nameCharacter.text = character.name
        setRecyclerViewComics()
    }


    private fun unitUI() {
        recyclerViewComics = findViewById(R.id.recyclerViewComicsCharacterDetail)
        imageCharacter = findViewById(R.id.CharacterDetailImage)
        nameCharacter = findViewById(R.id.CharacterDetailName)
    }

    private fun setImageCharacter() {
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this))
        builder.build().load(character.thumbnail.path + "." + character.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageCharacter)
    }

    private fun setRecyclerViewComics() {

        // this creates a vertical layout Manager
        recyclerViewComics.layoutManager = LinearLayoutManager(this@CharacterDetailActivity)

        launch(Dispatchers.Main) {
            try {

                val id = character.id
                val comics = GetCharacterComicsUseCase(id.toString()).execute().getOrThrow()
                val data = comics?.data?.results

                // This will pass the ArrayList to our Adapter
                val adapter = ComicsAdapter(data)

                // Setting the Adapter with the recyclerview
                recyclerViewComics.adapter = adapter

            } catch (e: Exception) {
                Toast.makeText(
                    this@CharacterDetailActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
}