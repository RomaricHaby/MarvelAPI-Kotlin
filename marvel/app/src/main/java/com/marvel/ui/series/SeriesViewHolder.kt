package com.marvel.ui.series

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.series.Series

class SeriesViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

    fun updateSeries(series: Series) {

        val nameSeries: TextView = itemView.findViewById(R.id.viewHolderNameSeries)

        nameSeries.text = series.title

    }
}
