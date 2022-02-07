package com.facetious.mr.sc2coopassist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AssistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assist)
        val mapNameAbove: TextView = findViewById(R.id.mapnameAbove)
        when (intent.getIntExtra(MAP_NAME, 0)) {   // 初始化界面
            1 -> //克哈裂痕
            {
                mapNameAbove.setText(R.string.map_RtK)
            }
            2 -> //虚空撕裂
            {
                //
            }
        }
    }

    fun assistStart(view: View) {
        val hintImage: ImageView = findViewById(R.id.imageView)
        val spawnTime: TextView = findViewById(R.id.nextAwTime)
        val remainTime: TextView = findViewById(R.id.remainAwTime)
        val startButtonRtK: Button = findViewById(R.id.buttonStartGame)
        when (intent.getIntExtra(MAP_NAME, 0)) {
            1 -> //克哈裂痕
            {
                val mapRtK = MapRtK()
                mapRtK.setupTimer(hintImage, spawnTime, remainTime)
            }
            2 -> //虚空撕裂
            {
                //
            }
        }

        startButtonRtK.visibility = View.INVISIBLE
    }
}