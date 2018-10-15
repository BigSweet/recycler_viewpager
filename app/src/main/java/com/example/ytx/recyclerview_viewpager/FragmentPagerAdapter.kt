package com.spero.vision.follow

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import com.example.ytx.recyclerview_viewpager.CategoryFragment


/**
 * introduce：这里写介绍
 * createBy：sunwentao
 * email：wentao.sun@yintech.cn
 * time: 10/10/18
 */
class FragmentPagerAdapter(fm: FragmentManager, titleList: List<String>) : FragmentPagerAdapter(fm) {

    private val fragmentList = arrayOfNulls<Fragment>(titleList.size)

    private var list = titleList
    override fun getItem(position: Int): Fragment {
        return CategoryFragment.buildFragment(list[position])
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        fragmentList[position] = fragment
        return fragment
    }

    fun getFragments(): Array<Fragment?> {
        return fragmentList
    }

}