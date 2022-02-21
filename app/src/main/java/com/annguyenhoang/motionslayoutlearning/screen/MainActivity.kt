package com.annguyenhoang.motionslayoutlearning.screen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.annguyenhoang.motionslayoutlearning.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_next).setOnClickListener {
            val intent = Intent(this@MainActivity, ItemMotionsLayout::class.java)
            startActivity(intent)
        }
    }
}