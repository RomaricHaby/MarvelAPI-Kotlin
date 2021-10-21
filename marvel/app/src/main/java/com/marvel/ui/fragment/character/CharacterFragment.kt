package com.marvel.ui.fragment.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R

class CharacterFragment : Fragment() {

    private var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character, container, false)



        initUI(view)



        return view
    }
/*
    private fun setRecyclerViewCharacter(characterList: List<Char>) {
        // Create adapter passing in the sample user data
        characterAdapter = CharacterAdapter(characterList, mainActivity)
        // Attach the adapter to the recyclerview to populate items
        recyclerView!!.adapter = characterAdapter
        recyclerView!!.layoutManager = LinearLayoutManager(context)
    }*/

    private fun initUI(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewCharacter)
    }

}