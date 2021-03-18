package com.karim.myapplication.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.karim.myapplication.R
import kotlinx.android.synthetic.main.fragment_e_x1.*


class EX1Fragment : Fragment() {


    lateinit var byte: ByteArray
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        byte= ByteArray(100*100*100)
        return inflater.inflate(R.layout.fragment_e_x1, container, false)
    }
    var isRunning=true
    var uiHandler=Handler(Looper.getMainLooper())
    private fun countScreenTime(){
        Thread(Runnable {
            var screenTimeSecond=0
            while (true){
                try {
                    Thread.sleep(1000)
                }catch (ex:InterruptedException){
                    Log.e("Error",ex.message)
                    return@Runnable
                }
                if(!isRunning){
                    return@Runnable
                }

                screenTimeSecond++
                setTextXml(screenTimeSecond)
            }
        }).start()
    }

    private fun setTextXml(screenTimeSecond: Int) {
        activity?.runOnUiThread{
            val str = "Screen Time :$screenTimeSecond s "
            text.text = str
            Log.d("current Thread",Thread.currentThread().name)
        }
//        uiHandler.post{
//            val str = "Screen Time :$screenTimeSecond s "
//            text.text = str
//            Log.d("current Thread",Thread.currentThread().name)
//        }
    }

    override fun onStop() {
        super.onStop()
        isRunning=false
    }

    override fun onStart() {
        super.onStart()
        countScreenTime()
    }

}