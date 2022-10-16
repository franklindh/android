package com.example.pemrogmob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ServiceActivity : AppCompatActivity() {
    lateinit var btnGetApi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btnGetApi = findViewById(R.id.btnGetApi)

        btnGetApi.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@ServiceActivity, GetAPIActivity::class.java)
            startActivity(intent)
        })
    }
}