package com.example.service

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyService::class.java)

        button_start.setOnClickListener {
            if (!isServiceRunning(MyService::class.java)) {
                startService(intent)
                Toast.makeText(this,"Service Start",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Service already running",Toast.LENGTH_LONG).show()
            }
        }

        button_stop.setOnClickListener {
            if (isServiceRunning(MyService::class.java)) {
                stopService(intent)
                Toast.makeText(this,"Service Stop",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Service already stopped",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        // Loop through the running services
        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                // If the service is running then return true
                return true
            }
        }
        return false
    }
}