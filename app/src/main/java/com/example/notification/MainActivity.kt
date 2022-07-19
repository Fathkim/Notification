package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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

        //Register channel kedalam sistem
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(CHANNEL_ID, "Countdown", "Ini merupakan deskripsi")

        binding.btnStart.setOnClickListener{
            countDownTimer.start()
        }

        countDownTimer = object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                //masukin text dari string
                binding.timer.text = getString(R.string.time_reamining, p0/1000)
            }

            override fun onFinish() {
                displayNotification()
            }

        }

    }

    private fun displayNotification(){
        //try youtself code
        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle("My notification")
            .setContentText("Much longer text that cannot fit one line...")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n " +
                        "when an unknown printer took a galley of type and scrambled it to make a type specimen book.\n " +
                        "It has survived not only five centuries, but also the leap into electronic typesetting,\n " +
                        "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets co"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)


        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(19, builder.build())

        }
        }

    class MainActivity : AppCompatActivity() {

        private var notificationManager : NotificationManager? = null
        private var CHANNEL_ID = "Channel_id"

        private lateinit var countDownTimer: CountDownTimer

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //Register channel kedalam sistem
            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            createNotificationChannel(CHANNEL_ID, "Countdown", "Ini merupakan deskripsi")

            binding.btnStart.setOnClickListener{
                countDownTimer.start()
            }

            countDownTimer = object : CountDownTimer(10000,1000){
                override fun onTick(p0: Long) {
                    //masukin text dari string
                    binding.timer.text = getString(R.string.time_reamining, p0/1000)
                }

                override fun onFinish() {
                    displayNotification()
                }

            }

        }

        private fun displayNotification(){
            //try youtself code
            // Create an explicit intent for an Activity in your app
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            var builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(19, builder.build())

            }
        }

        private fun createNotificationChannel(id: String, name: String, channelDescription: String){
            //validasi notif akan dibuat jika versi SDK 26+
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val importance = NotificationManager.IMPORTANCE_HIGH
                val channel = NotificationChannel(id, name, importance).apply {
                    description = channelDescription
                }
                notificationManager?.createNotificationChannel(channel)


            }
        }
    }


    private fun createNotificationChannel(id: String, name: String, channelDescription: String){
        //validasi notif akan dibuat jika versi SDK 26+
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)


        }
    }
    }
