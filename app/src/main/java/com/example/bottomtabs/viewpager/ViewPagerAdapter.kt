package com.example.bottomtabs.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.bottomtabs.R

class ViewPagerAdapter(
    private val context: Context,
    private val onBoardingDataList: List<OnBoardingData>
) :
    PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout, null)
        val title: TextView
        title = view.findViewById(R.id.title)
        title.text = onBoardingDataList[position].title
        container.addView(view)
        return view
    }
}