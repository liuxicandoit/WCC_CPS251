package com.example.recycleview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    /*private val titles = arrayOf(
        "Chapter One", "Chapter Two",
        "Chapter Three", "Chapter Four", "Chapter Five", "Chapter Six",
        "Chapter Seven", "Chapter Eight"
    )

    private val details = arrayOf(
        "Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details"
    )
    private val images = intArrayOf(
        R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8
    )*/

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
            }

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()

                Snackbar.make(
                    v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()
            }
        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

//        viewHolder.itemTitle.text = data.titles[randId]
//        viewHolder.itemDetail.text = data.details[randId]
//        viewHolder.itemImage.setImageResource(data.images[randId])

        viewHolder.itemTitle.text = data.titles[MainViewModel.arr[i][0]]
        viewHolder.itemDetail.text = data.details[MainViewModel.arr[i][1]]
        viewHolder.itemImage.setImageResource(data.images[MainViewModel.arr[i][2]])
        Log.i(TAG, "onCreate \n****************" + MainViewModel.arr[i].contentToString())

    }

    override fun getItemCount(): Int {
        return data.titles.size
    }


}