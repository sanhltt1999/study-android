package com.example.viewmodel.Util

import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SharePagerAdapter(
    fa: FragmentActivity,
    private var titles: List<TabModel>,
    var fragments: List<BaseFragment>
) : FragmentStateAdapter(fa) {

    @DrawableRes
    fun getIconTab(position: Int): Int {
        return titles[position].icon
    }

    fun getPageTitle(position: Int): String {
        return titles[position].title
    }

    fun getItem(position: Int) = fragments[position]

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
