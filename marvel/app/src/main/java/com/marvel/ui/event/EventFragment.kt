package com.marvel.ui.event

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
import com.marvel.ui.event.recyclerview.EventAdapter
import com.marvel.ui.viewmodel.EventViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class EventFragment : Fragment(), CoroutineScope by MainScope() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchButton: ImageButton
    private lateinit var searchNameEvent: EditText

    private val viewModel = EventViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        viewModel.getAllEventsFromAPI().observe(viewLifecycleOwner, { data ->
            val adapter = context?.let { EventAdapter(data, it) }

            recyclerView.adapter = adapter
        })
    }

    private fun setUpSearchEvent() {
        searchButton.setOnClickListener {
            if (searchNameEvent.text.isNotEmpty()) {
                viewModel.getSearchEventFromAPI(searchNameEvent.text.toString())
                    .observe(viewLifecycleOwner, { data ->
                        val adapter = context?.let { EventAdapter(data, it) }

                        recyclerView.adapter = adapter
                    })
            }
        }
    }
}