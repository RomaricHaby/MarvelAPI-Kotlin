package com.marvel.ui.series

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.modele.series.Series

class SeriesViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

    fun updateSeries(series: Series) {

        val nameSerie: TextView = itemView.findViewById(R.id.viewHolderNameSeries)

        nameSerie.text = series.title

    }
}
