package com.marvel.ui.series

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.series.Series
import com.marvel.ui.detail.CharacterDetailActivity
import com.marvel.ui.detail.SeriesDetailActivity

class SeriesAdapter(list: List<Series>?,  private val context: Context) : RecyclerView.Adapter<SeriesViewHolder>() {
    private var seriesList: List<Series>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_series, parent, false)
        return SeriesViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val items = seriesList?.get(position)
        if (items != null) {
            holder.updateSeries(series = items)
        }


        holder.itemView.setOnClickListener {
            val intent = Intent(context, SeriesDetailActivity::class.java)
            intent.putExtra("series", items)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return seriesList?.size!!
    }


}