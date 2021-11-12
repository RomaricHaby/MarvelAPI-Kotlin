package com.marvel.ui.creator

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.creators.Creator
import com.marvel.ui.activity.CreatorDetailActivity


class CreatorAdapter(list: List<Creator>?, private val context: Context) :
    RecyclerView.Adapter<CreatorViewHolder>() {
    private var creatorList: List<Creator>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_creator, parent, false)
        return CreatorViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: CreatorViewHolder, position: Int) {
        val items = creatorList?.get(position)
        if (items != null) {
            holder.updateCreator(items)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CreatorDetailActivity::class.java)
            intent.putExtra("creators", items)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return creatorList?.size!!
    }


}