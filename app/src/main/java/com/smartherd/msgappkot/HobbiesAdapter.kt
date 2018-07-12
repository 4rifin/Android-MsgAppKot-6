package com.smartherd.msgappkot

import android.content.Context
import android.content.Intent
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolded>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolded {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return MyViewHolded(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolded, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby,position)
    }

    inner class MyViewHolded(itemView: View) :RecyclerView.ViewHolder(itemView){


        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init{
            itemView.setOnClickListener {
                Toast.makeText(context,currentHobby!!.title + " Clicked!",Toast.LENGTH_SHORT).show()
            }
            itemView.imgShare.setOnClickListener {
                val message : String = "My hobby is: " + currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,message)
                intent.type = "text/plan"
                context.startActivity(Intent.createChooser(intent, "Share To : "))
            }
        }

        fun setData(hobby: Hobby?,pos: Int){
            itemView.txvTitle.text = hobby!!.title

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}