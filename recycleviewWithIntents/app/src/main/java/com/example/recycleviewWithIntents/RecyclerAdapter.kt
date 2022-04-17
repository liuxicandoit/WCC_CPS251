package com.example.recycleviewWithIntents

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    private val data = Data()
    //lateinit var viewModel: MainViewModel
    private val TAG = "StateChange"


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                sendText(itemView.context, getAdapterPosition())
            }
        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = data.titles[MainViewModel.arr[i][0]]
        viewHolder.itemDetail.text = data.details[MainViewModel.arr[i][1]]
        viewHolder.itemImage.setImageResource(data.images[MainViewModel.arr[i][2]])

    }

    override fun getItemCount(): Int {
        return data.titles.size
    }

    fun sendText(context: Context, position: Int) {

        val i = Intent(context, MainActivity2::class.java)

        i.putExtra("title", data.titles[MainViewModel.arr[position][0]])
        i.putExtra("detail",data.details[MainViewModel.arr[position][1]])
        i.putExtra("image",data.images[MainViewModel.arr[position][2]])

        context.startActivity(i)
    }


}