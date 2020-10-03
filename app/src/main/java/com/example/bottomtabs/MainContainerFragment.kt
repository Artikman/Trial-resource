package com.example.bottomtabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_main_container.*

class MainContainerFragment : Fragment() {

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    showHideMainFirstFragment(MainFirstFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.map -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.cart -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.setting -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.email -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar =
            getView()?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_main_container)
        (activity as MainActivity).setSupportActionBar(toolbar)
        (activity as MainActivity).supportActionBar?.title = "MainContainerFragment"

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun showHideMainFirstFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
            .show(fragment).hide(MainContainerFragment()).commit()
    }
}