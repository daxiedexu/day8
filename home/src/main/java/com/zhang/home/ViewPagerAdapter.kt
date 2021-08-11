package com.zhang.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager, behavior: Int,private val fragments:MutableList<Fragment>) : FragmentPagerAdapter(fm, behavior) {
    var list = mutableListOf<Fragment>()
    init {
        this.list = fragments
    }
    override fun getCount(): Int {
        return list.size
    }
    override fun getItem(position: Int): Fragment {
        return list[position]
    }
}