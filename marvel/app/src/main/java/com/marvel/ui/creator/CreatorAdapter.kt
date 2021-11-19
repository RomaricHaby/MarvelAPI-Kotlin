package com.marvel.ui.creator

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.model.creator.Creator
import com.marvel.ui.detail.CreatorDetailActivity


class CreatorAdapter(list: List<Creator>?, private val context: Context) :
    RecyclerView.Adapter<CreatorViewHolder>() {
    private var creatorList: List<Creator>? = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_creator, parent, false)
        return CreatorViewHolder(view)
    }

    override fun onBindViewHolder(holder: CreatorViewHolder, position: Int) {
        val item = creatorList?.get(position)

        if (item != null) {
            holder.updateCreator(item)
            onCellClicked(holder, item)
        }
    }

    private fun onCellClicked(holder: CreatorViewHolder, item: Creator?) {
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CreatorDetailActivity::class.java)
            intent.putExtra("creators", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return creatorList?.size!!
    }
}