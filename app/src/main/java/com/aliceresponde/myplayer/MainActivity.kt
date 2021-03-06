package com.aliceresponde.myplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("Hi Kotlin")
        main_textV.text = "-- Kotlin --"
        recycler.adapter = MediaAdapter(emptyList())
        main_show_btn.setOnClickListener { toast(message = "Good Morning ${main_editText.text}") }
    }
}
