package com.example.myapplication

import android.app.DownloadManager
import android.content.Context
import android.icu.util.TimeZone.SystemTimeZoneType
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.core.content.getSystemService


class MainActivity2 : AppCompatActivity() {
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //----
        btn = findViewById<Button>(R.id.btn)
        //---
        btn.setOnClickListener {
            var request =
                DownloadManager.Request(Uri.parse("https://dl.mahanmusic.net/ahang/01/07/Amir%20Maghare%20%20-%20Zange%20Ensha%20-%20320%20-%20mahanmusic.net.mp3"))
            request.setTitle("download music")
            request.setDescription("music 2022")
            request.setAllowedNetworkTypes(2 or 1)
            request.setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                "" + System.currentTimeMillis()
            )
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            var downloadm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            downloadm.enqueue(request)

        }
    }
}