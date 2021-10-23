package com.marvel.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.modele.creators.Creator
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope


class CreatorDetailActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var creatorImage: ImageView
    private lateinit var creatorName: TextView

    private lateinit var creator: Creator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creator_detail)

        creator = intent.getSerializableExtra("creators") as Creator

        unitUI()

        creatorName.text = creator.fullName

        setImageCreator()
    }

    private fun unitUI() {
        creatorImage = findViewById(R.id.CreatorDetailImage)
        creatorName = findViewById(R.id.CreatorDetailName)
    }

    private fun setImageCreator() {
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this))
        builder.build().load(creator.thumbnail.path + "." + creator.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(creatorImage)
    }

}