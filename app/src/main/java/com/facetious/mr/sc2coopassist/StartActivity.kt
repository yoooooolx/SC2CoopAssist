package com.facetious.mr.sc2coopassist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/*
    地图序号
    1：克哈裂痕 RtK
    2：虚空撕裂 VT
*/
const val MAP_NAME = "com.facetious.mr.sc2coopassist.MAPNAME"

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun startRtK(view: View) {
        val intent = Intent(this, AssistActivity::class.java).apply {
            putExtra(MAP_NAME, 1)
        }
        startActivity(intent)
    }

    fun startVT(view: View) {
        val intent = Intent(this, AssistActivity::class.java).apply {
            putExtra(MAP_NAME, 2)
        }
        startActivity(intent)
    }
}