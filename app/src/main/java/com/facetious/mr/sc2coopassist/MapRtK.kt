package com.facetious.mr.sc2coopassist

import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MapRtK {
    private val awRtK= arrayOf( // 克哈的红点列表
        AttackWave(20*MIN_TO_MS,1,R.mipmap.imagetest),
        AttackWave(50*MIN_TO_MS,2,R.mipmap.imagetest),
        AttackWave(80*MIN_TO_MS,3,R.mipmap.imagetest),
        AttackWave(110*MIN_TO_MS,4,R.mipmap.imagetest),
        AttackWave(140*MIN_TO_MS,5,R.mipmap.imagetest),
        AttackWave(170*MIN_TO_MS,6,R.mipmap.imagetest),
        AttackWave(205*MIN_TO_MS,7,R.mipmap.imagetest),
        AttackWave(245*MIN_TO_MS,7,R.mipmap.imagetest),
        AttackWave(265*MIN_TO_MS,7,R.mipmap.imagetest),
        AttackWave(285*MIN_TO_MS,7,R.mipmap.imagetest),
        AttackWave(300*MIN_TO_MS,7,R.mipmap.imagetest)
    )

    var timeStart:Long=0

    inner class CountdownTask(private val remainTime:TextView):TimerTask(){  // 更新倒计时的TimerTask
        override fun run() {
            val timeNow=Calendar.getInstance().timeInMillis
            val timeRemain:Long=awRtK[nextWave-1].awTime+timeStart-timeNow
            val timeMin:Long=timeRemain/(MIN_TO_MS*10)
            val timeSec:Long=(timeRemain%(MIN_TO_MS*10))/1000
            remainTime.text = String.format("%2d : %02d",timeMin,timeSec)
        }
    }

    fun setupTimer(hintImage: ImageView, spawnTime: TextView,remainTime:TextView){ // 初始化Timer
        val timer=Timer()
        val taskArray:Array<AwTask?> =makeTaskArray(awRtK,hintImage, spawnTime)
        for (i in awRtK.indices){   // 设置红点刷新的Timer
            val awTime=if(i==0) 0 else awRtK[i-1].awTime
            timer.schedule(taskArray[i],awTime)
        }

        // 设置倒计时的Timer
        val countdownTask=CountdownTask(remainTime)
        nextWave=1
        timeStart=Calendar.getInstance().timeInMillis
        timer.scheduleAtFixedRate(countdownTask,0, MIN_TO_MS/60)
    }
}