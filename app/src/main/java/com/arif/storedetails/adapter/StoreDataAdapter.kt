package com.arif.storedetails.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arif.storedetails.databinding.DesignLayoutBinding
import com.arif.storedetails.models.StoreInfo

class StoreDataAdapter(private val Callback: (StoreInfo.Data) -> Unit) :
    ListAdapter<StoreInfo.Data,StoreDataAdapter.StoreViewholder>(StoreDiffUtil()){
    class StoreViewholder(val binding:DesignLayoutBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(item:StoreInfo.Data,callback: (StoreInfo.Data) -> Unit){
                    binding.sitem = item
                    binding.cardViewId.setOnClickListener {
                        callback(item)
                    }
                }
            }

    class StoreDiffUtil : DiffUtil.ItemCallback<StoreInfo.Data>() {
        override fun areItemsTheSame(
            oldItem: StoreInfo.Data,
            newItem: StoreInfo.Data
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: StoreInfo.Data,
            newItem: StoreInfo.Data
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewholder {
        val binding = DesignLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return StoreViewholder(binding)
    }

    override fun onBindViewHolder(holder: StoreViewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item,Callback)

    }
}