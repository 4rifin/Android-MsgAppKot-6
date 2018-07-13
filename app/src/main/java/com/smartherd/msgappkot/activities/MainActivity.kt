package com.smartherd.msgappkot.activities

import android.content.Intent
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.widget.Toast
import com.smartherd.msgappkot.Constants
import com.smartherd.msgappkot.R
import com.smartherd.msgappkot.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG:String = MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener(){
            //Log.i("MainActivity","Button Was Clicked !!")
            //Log.i(TAG,"Button Was Clicked !!")
            Log.i(TAG,resources.getString(R.string.text_button_was_clicked))

            //showToast("Button Was Clicked !",Toast.LENGTH_LONG)
            showToast(resources.getString(R.string.text_button_was_clicked),Toast.LENGTH_LONG)
        }

        btnSendMsgToNextActivity.setOnClickListener {
            /*explecit intent*/
            val message : String = etUserMessage.text.toString()
            Log.i(TAG,resources.getString(R.string.text_second_button_was_clicked) + message)
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

            // move to view activity_second
            val intent = Intent (this, SecondActivity::class.java)

            /*send object parameter to second activity */
            intent.putExtra(Constants.USER_MSG_KEY,message)

            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener(){
            /*implicit intent*/
            val message : String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "text/plan"
            startActivity(Intent.createChooser(intent, resources.getString(R.string.text_Share_to)))
        }

        btnRecycleViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
