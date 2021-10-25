package com.marvel.ui.fragment.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.ui.fragment.character.recyclerview.CharacterAdapter
import com.marvel.ui.fragment.event.recyclerview.EventAdapter
import com.marvel.usecase.character.GetAllCharacterUseCase
import com.marvel.usecase.character.GetCharacterByNameUseCase
import com.marvel.usecase.events.GetAllEventsUseCase
import com.marvel.usecase.events.GetEventByNameUseCase
import kotlinx.coroutines.*

class EventFragment : Fragment(), CoroutineScope by MainScope() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchButton: ImageButton
    private lateinit var searchNameEvent: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)

        initUI(view)
        setRecyclerViewEvent()

        setUpSearchEvent()

        return view
    }

    private fun initUI(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewEvent)
        searchButton = view.findViewById(R.id.searchEventButton)
        searchNameEvent = view.findViewById(R.id.searchEvent)
    }

    private fun setRecyclerViewEvent() {
        recyclerView.layoutManager = LinearLayoutManager(context)

        launch(Dispatchers.Main) {
            try {
                val response = GetAllEventsUseCase().execute().getOrThrow()
                val data = response?.data?.results

                // This will pass the ArrayList to our Adapter
                val adapter = context?.let { EventAdapter(data, it) }

                // Setting the Adapter with the recyclerview
                recyclerView.adapter = adapter

            } catch (e: Exception) {
                Toast.makeText(context, "Error Occurred: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setUpSearchEvent() {
        searchButton.setOnClickListener {
            if (searchNameEvent.text.isNotEmpty()) {
                val character = runBlocking {
                    GetEventByNameUseCase(searchNameEvent.text.toString()).execute().getOrThrow()
                }
                val data = character?.data?.results

                // This will pass the ArrayList to our Adapter
                val adapter = context?.let { EventAdapter(data, it) }

                // Setting the Adapter with the recyclerview
                recyclerView.adapter = adapter
            }
        }
    }



}