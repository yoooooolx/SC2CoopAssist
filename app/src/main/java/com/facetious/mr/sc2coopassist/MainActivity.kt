package com.facetious.mr.sc2coopassist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startAssist(view: View) {
        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }

    fun assistOptions(view: View) {
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }

    fun exitAssist(view: View) {
        exitProcess(0)
    }
}