package com.marvel.ui.comic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.ui.comic.recyclerview.ComicAdapter
import com.marvel.ui.viewmodel.ComicViewModel

class ComicFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchButton: ImageButton
    private lateinit var searchNameComics: EditText


    private val viewModel = ComicViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_comics, container, false)

        initUI(view)
        setRecyclerViewComics()

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
                viewModel.getSearchComicFromAPI(searchNameComics.text.toString())
                    .observe(viewLifecycleOwner, { data ->
                        val adapter = context?.let { ComicAdapter(data, it) }
                        // Setting the Adapter with the recyclerview
                        recyclerView.adapter = adapter
                    })
            }
        }
    }

    private fun setRecyclerViewComics() {
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.getAllComicsFromAPI().observe(viewLifecycleOwner, { data ->
            val adapter = context?.let { ComicAdapter(data, it) }
            // Setting the Adapter with the recyclerview
            recyclerView.adapter = adapter
        })
    }
}