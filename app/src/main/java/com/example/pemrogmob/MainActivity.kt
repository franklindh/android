package com.example.pemrogmob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnSampleRV: Button
    lateinit var btnSampleCV: Button
    lateinit var btnSV: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSampleRV = findViewById(R.id.btnSampleRV)
        btnSampleCV = findViewById(R.id.btnSampleCV)
        btnSV = findViewById(R.id.btnSV)

        btnSampleRV.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@MainActivity, SampleRecycleView::class.java)
            startActivity(intent)
        })

        btnSampleCV.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@MainActivity, SampleCardView::class.java)
            startActivity(intent)
        })

        btnSV.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@MainActivity, ServiceActivity::class.java)
            startActivity(intent)
        })
    }
}