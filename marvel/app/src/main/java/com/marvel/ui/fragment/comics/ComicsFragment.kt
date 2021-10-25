package com.marvel.ui.fragment.comics

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
import com.marvel.ui.fragment.comics.recyclerview.ComicsAdapter
import com.marvel.usecase.comics.GetAllComicsUseCase
import com.marvel.usecase.comics.GetComicsByNameUseCase
import kotlinx.coroutines.*

class ComicsFragment : Fragment(), CoroutineScope by MainScope() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchButton: ImageButton
    private lateinit var searchNameComics: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_comics, container, false)

        initUI(view)
        setRecyclerViewComics()

        //TODO à tester
        setUpSearchComics()

        return view
    }

    private fun initUI(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewComics)
        searchButton = view.findViewById(R.id.searchComicsButton)
        searchNameComics = view.findViewById(R.id.searchComics)
    }

    private fun setUpSearchComics() {
        searchButton.setOnClickListener {
            if (searchNameComics.text.isNotEmpty()) {
                val response = runBlocking {
                    GetComicsByNameUseCase(searchNameComics.text.toString()).execute().getOrThrow()
                }
                val data = response?.data?.results

                // This will pass the ArrayList to our Adapter
                val adapter = context?.let { ComicsAdapter(data, it) }

                // Setting the Adapter with the recyclerview
                recyclerView.adapter = adapter
            }
        }
    }

    private fun setRecyclerViewComics() {
        recyclerView.layoutManager = LinearLayoutManager(context)

        launch(Dispatchers.Main) {
            try {
                val comics = GetAllComicsUseCase().execute().getOrThrow()
                val data = comics?.data?.results

                // This will pass the ArrayList to our Adapter
                val adapter = context?.let { ComicsAdapter(data, it) }

                // Setting the Adapter with the recyclerview
                recyclerView.adapter = adapter

            } catch (e: Exception) {
                Toast.makeText(context, "Error Occurred: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}