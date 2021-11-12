package com.marvel.ui.fragment.event.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.events.Events

class EventAdapter(list: List<Events>?, private val context: Context) :
    RecyclerView.Adapter<EventViewHolder>() {
    private var comicsList: List<Events>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_event, parent, false)
        return EventViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val items = comicsList?.get(position)
        if (items != null) {
            holder.updateEvent(items)
        }

        holder.itemView.setOnClickListener {
            /*val intent = Intent(context, ComicsDetailActivity::class.java)
            intent.putExtra("comics", items)
            context.startActivity(intent)*/
        }
    }

    override fun getItemCount(): Int {
        return comicsList?.size!!
    }
}