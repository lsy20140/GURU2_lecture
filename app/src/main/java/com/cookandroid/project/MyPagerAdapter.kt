package com.cookandroid.project

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    val items = ArrayList<Fragment>()

    //position 위치의 Fragment
    override fun getItem(position: Int): Fragment{
        return items[position]
    }


    //Fragment 개수
    override fun getCount(): Int {
        return items.size
    }

    fun updateFragment(items : List<Fragment>){
        this.items.addAll(items)
    }
}