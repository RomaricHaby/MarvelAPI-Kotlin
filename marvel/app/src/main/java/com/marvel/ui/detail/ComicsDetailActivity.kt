package com.marvel.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.comic.Comic
import com.marvel.ui.MainActivity
import com.marvel.ui.creator.CreatorAdapter
import com.marvel.ui.viewmodel.ComicsViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class ComicsDetailActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var imageComics: ImageView
    private lateinit var nameComics: TextView
    private lateinit var nbrPagesComics: TextView
    private lateinit var descriptionComics: TextView
    private lateinit var noCreator: TextView
    private lateinit var noDescription: TextView
    private lateinit var priceComics: TextView
    private lateinit var homeButton: FloatingActionButton

    private lateinit var recyclerViewCreator: RecyclerView

    private lateinit var comic: Comic

    private val viewModel = ComicsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics_detail)

        comic = intent.getSerializableExtra("comics") as Comic

        unitUI()

        setImageComics()
        nameComics.text = comic.title

        if (comic.description == null) {
            noDescription.visibility = VISIBLE
        }

        descriptionComics.text = comic.description
        nbrPagesComics.text = comic.pageCount.toString()

        priceComics.text = comic.prices[0].price.toString()


        setRecyclerView(recyclerViewCreator, "creator")
    }

    private fun unitUI() {
        imageComics = findViewById(R.id.ComicsImage)
        nbrPagesComics = findViewById(R.id.ComicsNbrPages)
        nameComics = findViewById(R.id.ComicsDetailName)
        descriptionComics = findViewById(R.id.ComicsDetailDescrip)
        recyclerViewCreator = findViewById(R.id.ComicsRecyclerCreator)
        noCreator = findViewById(R.id.recyclerViewCreatorComics_tv)
        noDescription = findViewById(R.id.recyclerViewDescriptionComics_tv)
        priceComics = findViewById(R.id.ComicsPrix)

        homeButton = findViewById(R.id.floatingButtonHome)
        setHomeButton()

    }

    private fun setHomeButton() {
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    private fun setImageComics() {
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this))
        builder.build().load(comic.thumbnail.path + "." + comic.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageComics)
    }


    private fun setRecyclerView(recyclerView: RecyclerView, type: String) {
        // this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        val id = comic.id

        when (type) {
            "creator" -> {
                viewModel.getComicsCreatorFromAPI(id.toString())
                    .observe(this@ComicsDetailActivity, {
                        if (it?.isEmpty() == true) {
                            noCreator.visibility = VISIBLE
                        }

                        recyclerView.adapter = CreatorAdapter(it, this@ComicsDetailActivity)
                    })
            }
        }
    }

}