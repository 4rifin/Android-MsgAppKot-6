package com.smartherd.msgappkot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener(){
            Log.i("MainActivity","Button Was Clicked !!")
            Toast.makeText(this,"Button Was Clicked !",Toast.LENGTH_SHORT).show()
        }

        btnSendMsgToNextActivity.setOnClickListener {
            val message : String = etUserMessage.text.toString()
            Log.i("MainActivity ","Second Button Was Clicked: " + message)
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

            // move to view activity_second
            val intent = Intent (this,SecondActivity::class.java)

            /*send object parameter to second activity */
            intent.putExtra("user_message",message)

            startActivity(intent)
        }
    }
}
