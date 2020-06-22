package com.example.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("MyService", "MyReceiver received")
        val intent = Intent(context, MyService::class.java)
        context?.startService(intent)
    }

}