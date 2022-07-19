package com.example.notification

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.notification.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var notificationManager : NotificationManager? = null
    private var CHANNEL_ID = "Channel_id"

    private lateinit var countDownTimer: CountDownTimer

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun displayNotification(){
        //try youtself code
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String){
        
    }
}