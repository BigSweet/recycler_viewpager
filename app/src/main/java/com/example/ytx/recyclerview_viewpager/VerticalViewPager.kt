package com.spero.vision.follow.widght

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * introduce：这里写介绍
 * createBy：sunwentao
 * email：wentao.sun@yintech.cn
 * time: 9/10/18
 */
class VerticalViewPager : ViewPager {

    private var noScroll = false

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    private fun swapTouchEvent(event: MotionEvent): MotionEvent {
        val width = width.toFloat()
        val height = height.toFloat()
        event.setLocation(event.y / height * width, event.x / width * height)
        return event
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return super.onInterceptTouchEvent(swapTouchEvent(MotionEvent.obtain(event)))
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (noScroll)
            false
        else
            super.onTouchEvent(swapTouchEvent(MotionEvent.obtain(ev)))
    }

    //如果你想要你的viewpager不要响应滑动 设置这个为true 同时注释掉onInterceptTouchEvent方法
    fun setNoScroll(noScroll: Boolean) {
        this.noScroll = noScroll
    }

}
