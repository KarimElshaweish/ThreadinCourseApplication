package com.karim.myapplication.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.karim.myapplication.R
import kotlinx.android.synthetic.main.fragment_demo1.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue


class Demo1Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo1, container, false)
    }

    var uiHandler=Handler(Looper.getMainLooper())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        demo1Btn.setOnClickListener{
            demo1Btn.isEnabled=false
            customHandler.post(Runnable {
                for(i in 0..5){
                    Thread.sleep(1000)
                    uiHandler.post{
                    }
                    valueText.text="iteration : $i"
                }
                uiHandler.post{
                    demo1Btn.isEnabled=true
                    valueText.text="Done"
                }
            })
        }
    }

    override fun onStop() {
        super.onStop()
        customHandler.stop()
    }

    lateinit var customHandler:CustomHandler
    override fun onStart() {
        super.onStart()
        customHandler=CustomHandler()
    }

    class CustomHandler(){
        private val mqueue:BlockingQueue<Runnable>
        private val POISON= Runnable {

        }
        init {
            mqueue=LinkedBlockingQueue()
            initWokerHandler()
        }
        private fun initWokerHandler(){
            Thread(Runnable {
                var runnable:Runnable
                while (true){
                    runnable=mqueue.take()
                    runnable.run()
                    if (runnable==POISON)
                        return@Runnable
                }
            }).start()
        }

        fun post( job: Runnable){
            mqueue.add(job)

        }

        fun stop(){
            mqueue.clear()
            mqueue.add(POISON)
        }
    }
}