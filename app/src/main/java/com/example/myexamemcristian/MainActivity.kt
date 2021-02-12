package com.example.myexamemcristian

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    private var vdUntels: VideoView? = null
    private var btnCarreras: Button? = null
    private var url: String = "splash_video2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vdUntels = findViewById(R.id.vd_untels)
        btnCarreras = findViewById(R.id.btn_carreras)

        vdUntels?.setVideoURI(getMedia(url));
        vdUntels?.setMediaController(MediaController(this));
        vdUntels?.requestFocus();
        vdUntels?.start();

        btnCarreras?.setOnClickListener {
            val intent = Intent(this, CarrerasActivity::class.java)
            vdUntels?.stopPlayback()
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        vdUntels?.start()
    }

    private fun Context.getMedia(mediaName: String): Uri {
        return if (URLUtil.isValidUrl(mediaName)) Uri.parse(mediaName) else Uri.parse("android.resource://$packageName/raw/$mediaName")
    }

}