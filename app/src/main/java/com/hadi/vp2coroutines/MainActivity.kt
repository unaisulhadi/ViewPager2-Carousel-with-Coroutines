package com.hadi.vp2coroutines

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.hadi.vp2coroutines.databinding.ActivityMainBinding
import kotlin.math.abs


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val INTERVAL_TIME = 5000L
    private var imagesList = mutableListOf<String>()
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var itemDecoration:HorizontalMarginItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sliderAdapter = SliderAdapter(this@MainActivity)
        itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )


        setupCarouselSlider()
        setupNormalSlider()
        setupData()
        setupAdapter()
    }

    private fun setupNormalSlider() {
        binding.viewpagerNormal.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = sliderAdapter
            addItemDecoration(itemDecoration)
            autoScroll(lifecycleScope, INTERVAL_TIME)
        }
    }

    private fun setupCarouselSlider() {
        binding.viewpager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = sliderAdapter
            setCarouselEffects()
            addItemDecoration(itemDecoration)
            autoScroll(lifecycleScope, INTERVAL_TIME)
        }
    }

    private fun setupAdapter() {
        sliderAdapter.setImages(imagesList)
        sliderAdapter.notifyDataSetChanged()
    }


    private fun setupData() {
        imagesList.add("https://cdn.pixabay.com/photo/2020/12/10/09/22/beach-front-5819728_960_720.jpg")
        imagesList.add("https://cdn.pixabay.com/photo/2020/09/03/13/56/pine-5541335_960_720.jpg")
        imagesList.add("https://cdn.pixabay.com/photo/2021/03/04/15/29/river-6068374_960_720.jpg")
        imagesList.add("https://cdn.pixabay.com/photo/2021/03/29/08/22/peach-flower-6133330_960_720.jpg")
    }
}
