package com.marvel.ui.fragment.comics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.ui.fragment.character.recyclerview.CharacterAdapter
import com.marvel.ui.fragment.comics.recyclerview.ComicsAdapter
import com.marvel.usecase.character.GetAllCharacterUseCase
import com.marvel.usecase.comics.GetAllComicsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ComicsFragment : Fragment(), CoroutineScope by MainScope() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_comics, container, false)

        initUI(view)
        setRecyclerViewComics()

        return view
    }

    private fun initUI(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewComics)
    }

    private fun setRecyclerViewComics() {

        // this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(context)

        launch(Dispatchers.Main) {
            try {
                val comics = GetAllComicsUseCase().execute().getOrThrow()
                val data = comics?.data?.results

                // This will pass the ArrayList to our Adapter
                val adapter = ComicsAdapter(data)

                // Setting the Adapter with the recyclerview
                recyclerView.adapter = adapter

            } catch (e: Exception) {
                Toast.makeText(context, "Error Occurred: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

    }
}