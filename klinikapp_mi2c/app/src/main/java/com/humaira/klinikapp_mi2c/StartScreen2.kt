package com.humaira.klinikapp_mi2c

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.humaira.klinikapp_mi2c.screen.HomeDoctorsActivity

class StartScreen2 : AppCompatActivity() {
    private lateinit var btnGetStarted : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start_screen2)

        btnGetStarted=findViewById(R.id.btnGetStarted)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnGetStarted.setOnClickListener(){
            val intentMenu2 = Intent(this@StartScreen2, HomeDoctorsActivity::class.java)
            startActivity(intentMenu2)
        }
    }
}