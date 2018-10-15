package com.example.ytx.recyclerview_viewpager

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.category_rv_item.*

/**
 * introduce：这里写介绍
 * createBy：sunwentao
 * email：wentao.sun@yintech.cn
 * time: 18/9/18
 */

class CategoryRecyclerAdapter : RecyclerView.Adapter<CategoryRecyclerAdapter.FollowCategoryRvHolder>() {
    private var currentIndex = 0

    private var mList: List<String> = listOf()

    var listener: ((s: String, position: Int) -> Unit)? = null

    override fun onBindViewHolder(holder: FollowCategoryRvHolder, position: Int) {
        holder.bindData(mList[position], position, currentIndex)
        holder.itemView.setOnClickListener {
            setCurrentPosition(position)
            listener?.invoke(mList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowCategoryRvHolder {
        return FollowCategoryRvHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_rv_item, parent, false))
    }

    private fun setCurrentPosition(index: Int) {
        currentIndex = index
        notifyDataSetChanged()
    }

    fun setData(list: List<String>) {
        mList = list
        notifyDataSetChanged()
    }

    class FollowCategoryRvHolder(override var containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindData(data: String, position: Int, currentIndex: Int) {
            if (position == currentIndex) {
                follow_category_ll.setBackgroundResource(R.drawable.vision_bg_category_rv_ll_yellow_round)
                follow_category_tv.setTextColor(ContextCompat.getColor(containerView.context, R.color.color_1a1a1a))
            } else {
                follow_category_tv.setTextColor(ContextCompat.getColor(containerView.context, R.color.color_999999))
                follow_category_ll.setBackgroundResource(R.drawable.vision_bg_category_rv_ll_gray_round)
            }
            follow_category_tv.text = data
        }

    }
}