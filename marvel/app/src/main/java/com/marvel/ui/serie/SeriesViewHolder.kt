package com.marvel.ui.serie

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.serie.Serie

class SeriesViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    fun updateSeries(serie: Serie) {

        val nameSeries: TextView = itemView.findViewById(R.id.viewHolderNameSeries)

        nameSeries.text = serie.title

    }
}