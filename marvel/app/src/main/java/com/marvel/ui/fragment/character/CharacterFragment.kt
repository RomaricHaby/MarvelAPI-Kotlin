package com.marvel.ui.fragment.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.ui.fragment.character.recyclerview.CharacterAdapter
import com.marvel.ui.viewmodel.CharacterViewModel


class CharacterFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchButton: ImageButton
    private lateinit var searchNameCharacter: EditText

    private val viewModel = CharacterViewModel()


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

    private fun initUI(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewCharacter)
        searchButton = view.findViewById(R.id.searchCharacterButton)
        searchNameCharacter = view.findViewById(R.id.searchCharacter)
    }

    private fun setUpSearchCharacter() {
        searchButton.setOnClickListener {
            if (searchNameCharacter.text.isNotEmpty()) {
                viewModel.getSearchCharacterFromAPI(searchNameCharacter.text.toString())
                    .observe(viewLifecycleOwner, { data ->
                        val adapter = context?.let { CharacterAdapter(data, it) }
                        // Setting the Adapter with the recyclerview
                        recyclerView.adapter = adapter
                    })
            }
        }
    }

    private fun setRecyclerViewCharacter() {
        // this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.getAllCharacterFromAPI().observe(viewLifecycleOwner, { data ->
            val adapter = context?.let { CharacterAdapter(data, it) }
            // Setting the Adapter with the recyclerview
            recyclerView.adapter = adapter
        })
    }


}