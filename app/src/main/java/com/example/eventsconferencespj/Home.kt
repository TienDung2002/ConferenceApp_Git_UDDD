package com.example.eventsconferencespj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homePage = inflater.inflate(R.layout.fragment_home, container, false)
//        val button = homePage.findViewById<Button>(R.id.name)


        return homePage
    }
}