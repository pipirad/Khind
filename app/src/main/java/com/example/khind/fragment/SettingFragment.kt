package com.example.khind.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.khind.R
import com.example.khind.activity.HomeActivity
import com.example.khind.activity.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_setting, container, false)
        val titleToolBar = activity?.findViewById<TextView>(R.id.titleToolbar)
        (activity as HomeActivity).supportActionBar?.title = ""
        titleToolBar?.text = "Settings"

        val setupSchedule = view.findViewById<ImageView>(R.id.setupSchedule)
        setupSchedule.setOnClickListener {
            val action = SettingFragmentDirections.actionSettingFragmentToSetupScheduleFragment()
            findNavController().navigate(action)
        }
        val faq = view.findViewById<ImageView>(R.id.faq)
        faq.setOnClickListener {
            val action = SettingFragmentDirections.actionSettingFragmentToFagFragment()
            findNavController().navigate(action)
        }
        val policy = view.findViewById<ImageView>(R.id.policy)
        policy.setOnClickListener {
            val action = SettingFragmentDirections.actionSettingFragmentToPolicyFragment()
            findNavController().navigate(action)
        }
        val logout = view.findViewById<ImageView>(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        val homeActivity = activity as HomeActivity
        val botBar = homeActivity.findViewById<BottomNavigationView>(R.id.bottom_nav)
        val location = homeActivity.findViewById<ConstraintLayout>(R.id.idChangeLocation)
        location.visibility = View.GONE
        botBar.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        val homeActivity = activity as HomeActivity
        val botBar = homeActivity.findViewById<BottomNavigationView>(R.id.bottom_nav)
        val location = homeActivity.findViewById<ConstraintLayout>(R.id.idChangeLocation)
        location.visibility = View.VISIBLE
        botBar.visibility = View.VISIBLE
    }


}