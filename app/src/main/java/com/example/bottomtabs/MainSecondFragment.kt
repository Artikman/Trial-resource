package com.example.bottomtabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainSecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = getView()?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_main_second)
        (activity as MainActivity).setSupportActionBar(toolbar)

        (activity as MainActivity).supportActionBar?.title = "MainSecondFragment"
    }
}