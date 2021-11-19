package com.marvel.ui.event.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.event.Event
import com.marvel.ui.detail.EventDetailActivity

class EventAdapter(list: List<Event>?, private val context: Context) :
    RecyclerView.Adapter<EventViewHolder>() {
    private var eventList: List<Event>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_event, parent, false)
        return EventViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val item = eventList?.get(position)
        if (item != null) {
            holder.updateEvent(item)
            onCellClicked(holder, item)
        }
    }

    private fun onCellClicked(holder: EventViewHolder, item: Event) {
        holder.itemView.setOnClickListener {
            val intent = Intent(context, EventDetailActivity::class.java)
            intent.putExtra("events", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return eventList?.size!!
    }
}