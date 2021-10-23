package com.marvel.ui.activity

import android.content.Intent
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
import com.marvel.ui.series.SeriesAdapter
import com.marvel.ui.stories.StoriesAdapter
import com.marvel.usecase.character.GetCharacterComicsUseCase
import com.marvel.usecase.character.GetCharacterSeriesUseCase
import com.marvel.usecase.character.GetCharacterStoriesUseCase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class CharacterDetailActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var imageCharacter: ImageView
    private lateinit var nameCharacter: TextView

    private lateinit var recyclerViewComics: RecyclerView
    private lateinit var recyclerViewSeries: RecyclerView
    private lateinit var recyclerViewStories: RecyclerView


    private lateinit var character: Hero


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        unitUI()

        character = intent.getSerializableExtra("character") as Hero

        setImageCharacter()
        nameCharacter.text = character.name

        setRecyclerView(recyclerViewComics, "comics")
        setRecyclerView(recyclerViewSeries, "series")
        setRecyclerView(recyclerViewStories, "stories")

    }


    private fun unitUI() {
        recyclerViewSeries = findViewById(R.id.recyclerViewSeriesCharacterDetail)
        recyclerViewComics = findViewById(R.id.recyclerViewComicsCharacterDetail)
        recyclerViewStories = findViewById(R.id.recyclerViewStoriesCharacterDetail)

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

    private fun setRecyclerView(recyclerView: RecyclerView, type: String) {
        // this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this@CharacterDetailActivity)

        launch(Dispatchers.Main) {
            try {
                val id = character.id

                when (type) {
                    "comics" -> {
                        val responseAPi = GetCharacterComicsUseCase(id.toString()).execute().getOrThrow()
                        val data = responseAPi?.data?.results
                        val adapter = ComicsAdapter(data, this@CharacterDetailActivity)
                        recyclerView.adapter = adapter
                    }
                    "series" ->{
                        val responseAPi = GetCharacterSeriesUseCase(id.toString()).execute().getOrThrow()
                        val data = responseAPi?.data?.results
                        val adapter = SeriesAdapter(data)
                        recyclerView.adapter = adapter
                    }
                    "stories" ->{
                        val responseAPi = GetCharacterStoriesUseCase(id.toString()).execute().getOrThrow()
                        val data = responseAPi?.data?.results
                        val adapter = StoriesAdapter(data)
                        recyclerView.adapter = adapter
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this@CharacterDetailActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}