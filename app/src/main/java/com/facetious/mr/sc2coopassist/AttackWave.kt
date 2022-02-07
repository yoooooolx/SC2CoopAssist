package com.facetious.mr.sc2coopassist

import android.widget.ImageView
import android.widget.TextView
import java.util.*

const val MIN_TO_MS:Long=4000   // 分钟数×10×MIN_TO_MS=毫秒数，困难/残酷难度下为1.5倍速
var nextWave:Int=0

data class AttackWave(val awTime:Long, val techTier:Int, val hintImage: Int)
// awTime: 刷新时间（单位：ms） techTier: 科技等级    hintImage: 红点刷新地图片

class AwTask(private val aw:AttackWave, private val hintImage: ImageView, private val spawnTime: TextView): TimerTask() {   // 更新提示图片和刷新时间的TimerTask
    override fun run() {
        // 更新红点波次数
        nextWave+=1
        // 更换红点提示图
        hintImage.setImageResource(aw.hintImage)
        // 修改红点刷新时间
        val spawnTimeLocal="${aw.awTime/(MIN_TO_MS*10)}:${(aw.awTime%(MIN_TO_MS*10))*60}"
        spawnTime.setText(spawnTimeLocal)
    }
}

fun makeTaskArray(aws:Array<AttackWave>, hintImage: ImageView, spawnTime: TextView):Array<AwTask?>{    //把AttackWave数组转化为AwTask数组
    val length=aws.size
    val awTimers= arrayOfNulls<AwTask>(length)   // TimerTask列表

    for (i in aws.indices){
        awTimers[i]= AwTask(aws[i],hintImage, spawnTime)
    }

    return awTimers
}