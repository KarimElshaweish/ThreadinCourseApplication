package com.karim.myapplication.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.karim.myapplication.R
import kotlinx.android.synthetic.main.fragment_demo1.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(),View.OnClickListener {


    var navController:NavController?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        btnEx1.setOnClickListener(this)
        btnEx2.setOnClickListener(this)
        btnDemonstration.setOnClickListener(this)
        btnDemo1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnEx1->navController?.navigate(R.id.action_homeFragment_to_EX1Fragment)
            R.id.btnEx2->navController?.navigate(R.id.action_homeFragment_to_ex2Fragment)
            R.id.btnDemonstration->navController?.navigate(R.id.action_homeFragment_to_demonstrationFragment)
            R.id.btnDemo1->navController?.navigate(R.id.action_homeFragment_to_demo1Fragment)
        }
    }
}