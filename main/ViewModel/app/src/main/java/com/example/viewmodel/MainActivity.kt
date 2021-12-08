package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewmodel.Util.BaseFragment
import com.example.viewmodel.Util.SharePagerAdapter
import com.example.viewmodel.Util.TabModel
import com.example.viewmodel.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var pagerAdapter: SharePagerAdapter
    private var mPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val p = getTitlesAndFragments()
        pagerAdapter = SharePagerAdapter(this, p.first, p.second)
        binding.apply {
            viewPager.adapter = pagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { _, position ->
                mPosition = position
            }.attach()
            viewPager.currentItem = 1
            viewPager.offscreenPageLimit = 2
        }

    }


    private fun getTitlesAndFragments(): Pair<List<TabModel>, List<BaseFragment>> {
        val titles = ArrayList<TabModel>()
        val fragments = ArrayList<BaseFragment>()

        titles.add(TabModel("ListFragment", 0))
        fragments.add(ListFragment.newInstance())

        titles.add(TabModel("DetailFragment", 0))
        fragments.add(DetailFragment.newInstance())



        return Pair(titles, fragments)
    }
}