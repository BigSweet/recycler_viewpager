package com.example.ytx.recyclerview_viewpager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.spero.vision.follow.FragmentPagerAdapter
import com.spero.vision.follow.widght.DefaultTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mAdapter: CategoryRecyclerAdapter? = null
    private var mPagerAdapter: FragmentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //模拟假数据 真是开发中可能是通过接口得到
        var list = mutableListOf<String>()
        for (i in 1..10) {
            list.add("test$i")
        }
        showCategory(list)
    }


    private fun showCategory(list: List<String>) {
        //给左边的recyclerView设置数据和adapter
        mAdapter = CategoryRecyclerAdapter()
        follow_category_rv.adapter = mAdapter
        follow_category_rv.layoutManager = LinearLayoutManager(this)
        mAdapter?.setData(list)

        //给右边的viewpager设置adapter
        mPagerAdapter = FragmentPagerAdapter(supportFragmentManager, list)
        follow_fragment_viewpager.setPageTransformer(true, DefaultTransformer())
        follow_fragment_viewpager.adapter = mPagerAdapter

        //recyclerView的item点击事件
        mAdapter?.listener = { _, position ->
            follow_fragment_viewpager.currentItem = position
        }
    }
}
