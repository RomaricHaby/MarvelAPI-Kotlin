package com.marvel.ui.serie

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.serie.Serie
import com.marvel.ui.detail.SeriesDetailActivity

class SeriesAdapter(list: List<Serie>?, private val context: Context) : RecyclerView.Adapter<SeriesViewHolder>() {
    private var serieList: List<Serie>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_series, parent, false)
        return SeriesViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val items = serieList?.get(position)
        if (items != null) {
            holder.updateSeries(serie = items)
        }


        holder.itemView.setOnClickListener {
            val intent = Intent(context, SeriesDetailActivity::class.java)
            intent.putExtra("series", items)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return serieList?.size!!
    }


}