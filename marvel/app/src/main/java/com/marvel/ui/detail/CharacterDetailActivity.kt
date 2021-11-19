package com.marvel.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.zxing.BarcodeFormat
import com.jakewharton.picasso.OkHttp3Downloader
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.marvel.R
import com.marvel.model.characters.Character
import com.marvel.ui.MainActivity
import com.marvel.ui.comics.recyclerview.ComicsAdapter
import com.marvel.ui.series.SeriesAdapter
import com.marvel.ui.stories.StoriesAdapter
import com.marvel.ui.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso

class CharacterDetailActivity : AppCompatActivity() {
    private lateinit var imageCharacter: ImageView
    private lateinit var nameCharacter: TextView
    private lateinit var descriptionCharacter: TextView
    private var homeButton: FloatingActionButton? = null
    private lateinit var right: ImageButton
    private lateinit var left: ImageButton

    private lateinit var showStories: ImageButton
    private lateinit var showSeries: ImageButton
    private lateinit var showComics: ImageButton

    private lateinit var recyclerViewComics: RecyclerView
    private lateinit var recyclerViewSeries: RecyclerView
    private lateinit var recyclerViewStories: RecyclerView

    private var isQrCodeGenerate = false


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


        right = findViewById(R.id.CharacterDetailimageButtonRight)
        left = findViewById(R.id.CharacterDetailimageButtonLeft)
        homeButton = findViewById(R.id.floatingButtonHome)

        showStories = findViewById(R.id.CharacterDetailShowStories)
        showSeries = findViewById(R.id.CharacterDetailShowSeries)
        showComics = findViewById(R.id.CharacterDetailShowComics)

        descriptionCharacter = findViewById(R.id.CharacterDetailDescription)
        imageCharacter = findViewById(R.id.CharacterDetailImage)
        nameCharacter = findViewById(R.id.CharacterDetailName)

        setHomeButton()
        qrcodeImage()
        characterImage()


        showStories()
        showSeries()
        showComics()
    }

    private fun showComics(){
        showComics.setOnClickListener {
            if (recyclerViewComics.visibility == View.VISIBLE){
                recyclerViewComics.visibility = View.GONE
                showComics.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_arrow_downward_24))
            }
            else{
                recyclerViewComics.visibility = View.VISIBLE
                showComics.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_arrow_upward_24))
            }

        }
    }

    private fun showSeries(){
        showSeries.setOnClickListener {
            if (recyclerViewSeries.visibility == View.VISIBLE){
                recyclerViewSeries.visibility = View.GONE
                showSeries.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_arrow_downward_24))
            }
            else{
                recyclerViewSeries.visibility = View.VISIBLE
                showSeries.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_arrow_upward_24))
            }

        }
    }

    private fun showStories(){
        showStories.setOnClickListener {
            if (recyclerViewStories.visibility == View.VISIBLE){
                recyclerViewStories.visibility = View.GONE
                showStories.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_arrow_downward_24))
            }
            else{
                recyclerViewStories.visibility = View.VISIBLE
                showStories.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_arrow_upward_24))
            }

        }
    }

    private fun qrcodeImage() {
        right.setOnClickListener {
            if(!isQrCodeGenerate){
                try {
                    val barcodeEncoder = BarcodeEncoder()
                    val bitmap = barcodeEncoder.encodeBitmap(character.id.toString(), BarcodeFormat.QR_CODE, 400, 400)
                    imageCharacter.setImageBitmap(bitmap)

                } catch (e: Exception) {
                    setImageCharacter()
                }

                isQrCodeGenerate = true
            }
        }
    }

    private fun characterImage() {
        left.setOnClickListener {
            if(isQrCodeGenerate){
                setImageCharacter()

                isQrCodeGenerate = false
            }
        }
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
                    val adapter = SeriesAdapter(data, this@CharacterDetailActivity)
                    recyclerView.adapter = adapter
                })

            STORIES -> viewModel.getCharacterStoriesFromAPI(id.toString())
                .observe(this@CharacterDetailActivity, { data ->
                    val adapter = StoriesAdapter(data, this@CharacterDetailActivity)
                    recyclerView.adapter = adapter
                })
        }
    }
}