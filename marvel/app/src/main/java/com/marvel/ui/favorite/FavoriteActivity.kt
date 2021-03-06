package com.marvel.ui.favorite

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R

import com.marvel.model.user.DataUser
import com.marvel.ui.character.recyclerview.CharacterAdapter


class FavoriteActivity : AppCompatActivity() {
    private lateinit var recyclerViewCharacter: RecyclerView
    private lateinit var noFavTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        unitUI()

        setRecyclerView()
    }

    private fun unitUI() {
        recyclerViewCharacter = findViewById(R.id.recyclerViewFavCharacter)
        noFavTextView = findViewById(R.id.noFavTextView)

        if (DataUser.listCharacterFav.isEmpty()) {
            noFavTextView.visibility = View.VISIBLE
        } else {
            noFavTextView.visibility = View.INVISIBLE
        }
    }

    private fun setRecyclerView() {
        recyclerViewCharacter.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = applicationContext?.let { CharacterAdapter(DataUser.listCharacterFav, it) }
        recyclerViewCharacter.adapter = adapter

    }
}