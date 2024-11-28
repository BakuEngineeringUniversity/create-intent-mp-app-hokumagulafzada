package com.example.profil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.TextView
import android.net.Uri
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val emailText = findViewById<TextView>(R.id.emailText)
        emailText.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:hgulafzade@std.beu.edu.az")
                putExtra(Intent.EXTRA_SUBJECT, "Subject")
            }
            startActivity(Intent.createChooser(emailIntent, "Send Email"))
        }

        val phoneText = findViewById<TextView>(R.id.phoneText)
        phoneText.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+994 51 405 02 92")
            }
            startActivity(phoneIntent)
        }

        val locationText = findViewById<TextView>(R.id.locationText)
        locationText.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=Baku, Azerbaijan")
            }
            startActivity(mapIntent)
        }

        val playMusicButton = findViewById<Button>(R.id.playMusicButton)
        playMusicButton.setOnClickListener {
            val musicIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.youtube.com/watch?v=HWqKPWO5T4o")
                type = "audio/*"
            }
            startActivity(musicIntent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}