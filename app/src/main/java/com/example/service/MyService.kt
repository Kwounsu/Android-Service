package com.example.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("MyService", "Service onStartCommand")
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i("MyService", "Service onBind")
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyService", "Service onDestroy")
    }
}