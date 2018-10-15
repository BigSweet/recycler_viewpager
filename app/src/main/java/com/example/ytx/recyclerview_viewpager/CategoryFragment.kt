package com.example.ytx.recyclerview_viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_category.*


/**
 * introduce：这里写介绍
 * createBy：sunwentao
 * email：wentao.sun@yintech.cn
 * time: 9/10/18
 */

class CategoryFragment : Fragment() {

    //在真正的开发中，每个界面的ID可能是不同的，所以这里会接收一个ID
    companion object {
        @JvmStatic
        fun buildFragment(id: String): CategoryFragment {
            var fragment = CategoryFragment()
            var bundle = Bundle()
            bundle.putString("id", id)
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test_tv.text = "我是分类界面" + arguments?.getString("id")
    }

}