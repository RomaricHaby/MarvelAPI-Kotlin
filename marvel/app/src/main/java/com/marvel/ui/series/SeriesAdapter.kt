package com.marvel.ui.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.comics.Comics
import com.marvel.modele.series.Series
import com.marvel.ui.fragment.comics.recyclerview.ComicsViewHolder

class SeriesAdapter (list: List<Series>?) : RecyclerView.Adapter<SeriesViewHolder>() {
    private var seriesList: List<Series>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_series, parent, false)
        return SeriesViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val items = seriesList?.get(position)
        if (items != null) {
            holder.updateSeries(series = items)
        }
    }

    override fun getItemCount(): Int {
        return seriesList?.size!!
    }


}