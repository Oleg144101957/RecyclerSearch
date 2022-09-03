package com.example.recyclersearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersearch.databinding.ItemBinding
import com.example.recyclersearch.model.Item

class RvAdapter(var list: ArrayList<Item>) : RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvAbbr.text = list[position].abbr
        holder.binding.tvName.text = list[position].name
    }

    override fun getItemCount() = list.size
}