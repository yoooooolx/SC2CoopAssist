package com.facetious.mr.sc2coopassist

import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MapRtK {
    private val awRtK = arrayOf( // 克哈的红点列表
        AttackWave(20 * MIN_TO_MS, 1, R.mipmap.imagetest),
        AttackWave(50 * MIN_TO_MS, 2, R.mipmap.imagetest),
        AttackWave(80 * MIN_TO_MS, 3, R.mipmap.imagetest),
        AttackWave(110 * MIN_TO_MS, 4, R.mipmap.imagetest),
        AttackWave(140 * MIN_TO_MS, 5, R.mipmap.imagetest),
        AttackWave(170 * MIN_TO_MS, 6, R.mipmap.imagetest),
        AttackWave(205 * MIN_TO_MS, 7, R.mipmap.imagetest),
        AttackWave(245 * MIN_TO_MS, 7, R.mipmap.imagetest),
        AttackWave(265 * MIN_TO_MS, 7, R.mipmap.imagetest),
        AttackWave(285 * MIN_TO_MS, 7, R.mipmap.imagetest),
        AttackWave(300 * MIN_TO_MS, 7, R.mipmap.imagetest)
    )

    var timeStart: Long = 0

    inner class CountdownTask(private val remainTime: TextView, private val timer: Timer) :
        TimerTask() {  // 更新倒计时的TimerTask
        override fun run() {
            val timeNow = Calendar.getInstance().timeInMillis
            val timeRemain: Long = awRtK[nextWave - 1].awTime + timeStart - timeNow
            val timeMin: Long = (timeRemain * 6 / MIN_TO_MS) / 60
            val timeSec: Long = (timeRemain * 6 / MIN_TO_MS) % 60
            if (timeRemain < 0) {  // 最后一波红点刷新了，停止计时
                timer.cancel()
            } else {
                // 修改UI
                val changeText =
                    Runnable { remainTime.text = String.format("%2d : %02d", timeMin, timeSec) }
                remainTime.post(changeText)
            }
        }
    }

    fun setupTimer(hintImage: ImageView, spawnTime: TextView, remainTime: TextView) { // 初始化Timer
        nextWave = 0
        val timer = Timer()
        val taskArray: Array<AwTask?> = makeTaskArray(awRtK, hintImage, spawnTime)
        for (i in awRtK.indices) {   // 设置红点刷新的Timer
            val awTime = if (i == 0) 0 else awRtK[i - 1].awTime
            timer.schedule(taskArray[i], awTime)
        }

        // 设置倒计时的Timer
        val countdownTask = CountdownTask(remainTime, timer)
        timeStart = Calendar.getInstance().timeInMillis
        timer.schedule(countdownTask, 0, MIN_TO_MS / 6)
    }
}