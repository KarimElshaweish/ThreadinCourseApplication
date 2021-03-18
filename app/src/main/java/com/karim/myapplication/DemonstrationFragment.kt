package com.karim.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class DemonstrationFragment : Fragment() {

    val TAG="Event Name"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         val view= inflater.inflate(R.layout.fragment_demonstration, container, false)
        val btnClick=view.findViewById<Button>(R.id.clickBtn)
        btnClick.setOnClickListener{
            logThreadInfo("button clickBack")
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logThreadInfo("onViewCreated()")
    }

    override fun onStart() {
        super.onStart()
        logThreadInfo("onStart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logThreadInfo("onDestroy()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logThreadInfo("onDestroyView()")
    }

    private fun logThreadInfo(eventName:String){
        Log.d(TAG,"event \n $eventName ; thread name : ${Thread.currentThread().name} ; thread ID : ${Thread.currentThread().id} ;")
    }
}