package com.marvel.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.user.DataUser
import com.marvel.ui.fragment.character.recyclerview.CharacterAdapter
import com.marvel.ui.viewmodel.CharacterViewModel

class FavoritesActivity : AppCompatActivity() {
    private lateinit var recyclerViewCharacter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)


        unitUI()
    }

    private fun unitUI() {
        recyclerViewCharacter = findViewById(R.id.recyclerViewFavCharacter)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        // this creates a vertical layout Manager
        recyclerViewCharacter.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = applicationContext?.let { CharacterAdapter(DataUser.listCharacterFav, it) }
        recyclerViewCharacter.adapter = adapter

    }
}