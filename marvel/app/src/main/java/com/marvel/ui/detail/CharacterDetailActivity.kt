package com.marvel.ui.detail

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.characters.Character
import com.marvel.ui.MainActivity
import com.marvel.ui.comics.recyclerview.ComicsAdapter
import com.marvel.ui.series.SeriesAdapter
import com.marvel.ui.stories.StoriesAdapter
import com.marvel.ui.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class CharacterDetailActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var imageCharacter: ImageView
    private lateinit var nameCharacter: TextView
    private lateinit var descriptionCharacter: TextView
    private var homeButton: FloatingActionButton? = null

    private lateinit var recyclerViewComics: RecyclerView
    private lateinit var recyclerViewSeries: RecyclerView
    private lateinit var recyclerViewStories: RecyclerView


    private lateinit var character: Character


    private val viewModel = CharacterViewModel()

    companion object {
        const val COMICS = "comics"
        const val SERIES = "series"
        const val STORIES = "stories"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        unitUI()

        character = intent.getSerializableExtra("character") as Character

        setImageCharacter()
        nameCharacter.text = character.name
        descriptionCharacter.text = character.description

        setRecyclerView(recyclerViewComics, COMICS)
        setRecyclerView(recyclerViewSeries, SERIES)
        setRecyclerView(recyclerViewStories, STORIES)
    }


    private fun unitUI() {
        recyclerViewSeries = findViewById(R.id.recyclerViewSeriesCharacterDetail)
        recyclerViewComics = findViewById(R.id.recyclerViewComicsCharacterDetail)
        recyclerViewStories = findViewById(R.id.recyclerViewStoriesCharacterDetail)


        homeButton = findViewById(R.id.floatingButtonHome)
        setHomeButton()

        descriptionCharacter = findViewById(R.id.CharacterDetailDescription)
        imageCharacter = findViewById(R.id.CharacterDetailImage)
        nameCharacter = findViewById(R.id.CharacterDetailName)
    }

    private fun setHomeButton() {
        homeButton?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
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

        val id = character.id

        when (type) {
            COMICS -> viewModel.getCharacterComicsFromAPI(id.toString())
                .observe(this@CharacterDetailActivity, { data ->
                    val adapter = ComicsAdapter(data, this@CharacterDetailActivity)
                    recyclerView.adapter = adapter
                })

            SERIES -> viewModel.getCharacterSeriesFromAPI(id.toString())
                .observe(this@CharacterDetailActivity, { data ->
                    val adapter = SeriesAdapter(data)
                    recyclerView.adapter = adapter
                })

            STORIES -> viewModel.getCharacterStoriesFromAPI(id.toString())
                .observe(this@CharacterDetailActivity, { data ->
                    val adapter = StoriesAdapter(data)
                    recyclerView.adapter = adapter
                })
        }
    }
}