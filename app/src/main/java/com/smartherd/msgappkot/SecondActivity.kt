package com.smartherd.msgappkot

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //extract / passing data value object parameter from MainActivity
        val bundle:Bundle? = intent.extras
        var msg = bundle!!.getString("user_message")

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        //set value object parameter from MainActivity
        txvUserMessage.text = msg

    }
}