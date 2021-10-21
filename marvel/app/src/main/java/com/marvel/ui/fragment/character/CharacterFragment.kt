package com.marvel.ui.fragment.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.ui.fragment.character.recyclerview.CharacterAdapter
import com.marvel.usecase.character.GetCharacterUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class CharacterFragment : Fragment() , CoroutineScope by MainScope(){




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // getting the recyclerview by its id



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_character, container, false)


        val recyclerview = view.findViewById <RecyclerView>(R.id.recyclerViewCharacter)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(context)



        launch(Dispatchers.Main) {
            try {
                val ironMan = GetCharacterUseCase("1009368").execute().getOrThrow()
                val data = ironMan?.dataCharacter?.results

                // This will pass the ArrayList to our Adapter
                val adapter = CharacterAdapter(data)

                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter
                Toast.makeText(context, ironMan?.dataCharacter?.results?.get(0)?.name, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(context, "Error Occurred: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }




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
/*
    private fun initUI(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewCharacter)
    }*/

}