package com.example.bottomtabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bottomtabs.toptabs.MainFirstSubFragment
import com.example.bottomtabs.toptabs.MainSecondSubFragment
import kotlinx.android.synthetic.main.fragment_main_first.*
import java.util.ArrayList

class MainFirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = getView()?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_main_first)
        (activity as MainActivity).setSupportActionBar(toolbar)

        (activity as MainActivity).supportActionBar?.title = "MainFirstFragment"

        val adapter = MyViewPagerAdapter(childFragmentManager)
        adapter.addFragment(MainFirstSubFragment(), "First Sub")
        adapter.addFragment(MainSecondSubFragment(), "Second Sub")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}