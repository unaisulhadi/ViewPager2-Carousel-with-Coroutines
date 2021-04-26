package com.hadi.vp2coroutines

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.hadi.vp2coroutines.databinding.ItemSliderBinding

class SliderAdapter(
    private val context: Context,
    private val list: List<String>
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding = ItemSliderBinding.inflate(LayoutInflater.from(context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    class SliderViewHolder(val binding: ItemSliderBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(url: String) {
            binding.ivSlider.load(url) {
                crossfade(true)
                //transformations(CircleCropTransformation())
            }
        }
    }
}