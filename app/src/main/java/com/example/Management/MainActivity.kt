package com.example.Management

import android.content.Intent
import android.graphics.Color.red
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.opencsv.CSVReader
import java.io.*
import java.nio.charset.Charset
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val bustart = findViewById<Button>(R.id.buStart)
        bustart.setOnClickListener {

            val intent = Intent(this, List_view_prsn::class.java)

            startActivity(intent)

        }


    }
}





