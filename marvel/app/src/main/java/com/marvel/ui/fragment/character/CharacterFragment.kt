package com.marvel.ui.fragment.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.ui.fragment.character.recyclerview.CharacterAdapter
import com.marvel.usecase.character.GetAllCharacterUseCase
import com.marvel.usecase.character.GetCharacterByNameUseCase
import kotlinx.coroutines.*


class CharacterFragment : Fragment(), CoroutineScope by MainScope() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchButton: ImageButton
    private lateinit var searchNameCharacter: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character, container, false)

        initUI(view)
        setRecyclerViewCharacter()

        setUpSearchCharacter()

        return view
    }

    private fun setUpSearchCharacter() {
        searchButton.setOnClickListener {
            if (searchNameCharacter.text.isNotEmpty()) {
                val character = runBlocking {
                    GetCharacterByNameUseCase(searchNameCharacter.text.toString()).execute().getOrThrow()
                }
                val data = character?.dataCharacter?.results

                // This will pass the ArrayList to our Adapter
                val adapter = context?.let { CharacterAdapter(data, it) }

                // Setting the Adapter with the recyclerview
                recyclerView.adapter = adapter
            }
        }
    }

    private fun initUI(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewCharacter)
        searchButton = view.findViewById(R.id.searchCharacterButton)
        searchNameCharacter = view.findViewById(R.id.searchCharacter)
    }

    private fun setRecyclerViewCharacter() {
        // this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(context)

        launch(Dispatchers.Main) {
            try {
                //val character = GetCharacterUseCase("1009368").execute().getOrThrow()
                val character = GetAllCharacterUseCase().execute().getOrThrow()
                val data = character?.dataCharacter?.results

                // This will pass the ArrayList to our Adapter
                val adapter = context?.let { CharacterAdapter(data, it) }

                // Setting the Adapter with the recyclerview
                recyclerView.adapter = adapter
                // Toast.makeText(context, character?.dataCharacter?.results?.get(0)?.name, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(context, "Error Occurred: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}