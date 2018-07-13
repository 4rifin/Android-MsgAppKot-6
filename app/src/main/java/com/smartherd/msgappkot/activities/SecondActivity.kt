package com.smartherd.msgappkot.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.smartherd.msgappkot.Constants
import com.smartherd.msgappkot.R
import com.smartherd.msgappkot.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){

    companion object {
        val TAG:String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //extract / passing data value object parameter from MainActivity
        val bundle:Bundle? = intent.extras
        /*var msg = bundle!!.getString("user_message")

        showToast(msg)
        //set value object parameter from MainActivity
        txvUserMessage.text = msg*/

        /*handle null*/
        bundle?.let {
            val msg = bundle.getString(Constants.USER_MSG_KEY)

            showToast(msg)
            //set value object parameter from MainActivity
            txvUserMessage.text = msg
        }

    }
}