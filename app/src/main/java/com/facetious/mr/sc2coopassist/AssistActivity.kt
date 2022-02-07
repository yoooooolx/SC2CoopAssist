package com.facetious.mr.sc2coopassist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AssistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assist)
        val mapname = intent.getIntExtra(MAP_NAME,0)
        when (mapname)
        {
            1-> //克哈裂痕
            {
                //
            }
            2-> //虚空撕裂
            {
                //
            }
        }
    }
}