package com.marvel.ui.activity

import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.comics.Comics
import com.marvel.ui.creator.CreatorAdapter
import com.marvel.usecase.comics.GetComicsCreatorsUseCase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ComicsDetailActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var imageComics: ImageView
    private lateinit var nameComics: TextView
    private lateinit var nbrPagesComics: TextView
    private lateinit var descriptionComics: TextView
    private lateinit var noCreator: TextView
    private lateinit var noDescription: TextView
    private lateinit var priceComics: TextView

    private lateinit var recyclerViewCreator: RecyclerView

    private lateinit var comics: Comics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics_detail)

        comics = intent.getSerializableExtra("comics") as Comics

        unitUI()

        setImageComics()
        nameComics.text = comics.title

        if (comics.description == null) {
            noDescription.visibility = VISIBLE
        }

        descriptionComics.text = comics.description
        nbrPagesComics.text = comics.pageCount.toString()

        priceComics.text = comics.prices[0].price.toString()


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

    }

    private fun setImageComics() {
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this))
        builder.build().load(comics.thumbnail.path + "." + comics.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageComics)
    }


    private fun setRecyclerView(recyclerView: RecyclerView, type: String) {
        // this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        launch(Dispatchers.Main) {
            try {
                val id = comics.id

                when (type) {
                    "creator" -> {
                        val responseAPi =
                            GetComicsCreatorsUseCase(id.toString()).execute().getOrThrow()
                        val data = responseAPi?.data?.results

                        if (data?.isEmpty() == true) {
                            noCreator.visibility = VISIBLE
                        }

                        val adapter = CreatorAdapter(data, this@ComicsDetailActivity)
                        recyclerView.adapter = adapter
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this@ComicsDetailActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}