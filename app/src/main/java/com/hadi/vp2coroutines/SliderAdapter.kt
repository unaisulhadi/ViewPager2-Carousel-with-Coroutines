package com.hadi.vp2coroutines

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.hadi.vp2coroutines.databinding.ItemSliderBinding

class SliderAdapter(
    private val context: Context
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    private var list = mutableListOf<String>()


    fun setImages(list: List<String>){
        this.list.clear()
        this.list.addAll(list);
    }

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