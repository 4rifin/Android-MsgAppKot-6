package com.smartherd.msgappkot.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.smartherd.msgappkot.adapters.HobbiesAdapter
import com.smartherd.msgappkot.R
import com.smartherd.msgappkot.models.Suplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {

    companion object {
        val TAG:String = HobbiesAdapter::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setupRecycleView()

    }

    private fun setupRecycleView() {

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Suplier.hobbies)
        recycleView.adapter = adapter

    }

}