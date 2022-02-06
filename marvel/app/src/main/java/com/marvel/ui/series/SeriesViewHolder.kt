package com.marvel.ui.series

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.series.Series

class SeriesViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private lateinit var nameSeries: TextView

    fun updateSeries(series: Series) {
        initUI()

        setUpDataSeries(series)
    }

    private fun initUI() {
        nameSeries = itemView.findViewById(R.id.viewHolderNameSeries)
    }

    private fun setUpDataSeries(series: Series) {
        nameSeries.text = series.title
    }
}
