package com.karim.myapplication.Demonistraion

class Visiblity {
    companion object{
        @Volatile var  sCount=0
        @JvmStatic
        fun main( args:Array<String>){
            Conumer().start()
            Thread.sleep(100)
            Producer().start()
        }
        class Conumer:Thread(){
            override fun run() {
                var localValue=-1
                while (true){
                    if(localValue!= sCount){
                        println("Consumer : detected count change : $sCount")
                        localValue= sCount
                    }
                    if(sCount>=5)
                        break
                }
                println("Consumer : terminated")
            }
        }

        class Producer:Thread(){
            override fun run() {
                var localCount= sCount
                while (sCount<5){
                    localCount++
                    println("Producer : incrementing the count to $localCount")
                    sCount=localCount
                    sleep(1000)
                }
                print("Producer : Terminated")
            }
        }
    }
}