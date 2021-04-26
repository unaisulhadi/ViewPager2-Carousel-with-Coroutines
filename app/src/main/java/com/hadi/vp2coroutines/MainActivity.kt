package com.hadi.vp2coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.hadi.vp2coroutines.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val INTERVAL_TIME = 3000L
    private var imagesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupData()
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.viewpager.apply {
            adapter = SliderAdapter(this@MainActivity, imagesList)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            autoScroll(lifecycleScope, INTERVAL_TIME)
        }

    }

    private fun setupData() {
        imagesList.add("https://cdn.pixabay.com/photo/2020/12/10/09/22/beach-front-5819728_960_720.jpg")
        imagesList.add("https://cdn.pixabay.com/photo/2020/09/03/13/56/pine-5541335_960_720.jpg")
        imagesList.add("https://cdn.pixabay.com/photo/2021/03/04/15/29/river-6068374_960_720.jpg")
        imagesList.add("https://cdn.pixabay.com/photo/2021/03/29/08/22/peach-flower-6133330_960_720.jpg")
    }
}
