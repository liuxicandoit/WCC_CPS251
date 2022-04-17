package com.example.recycleviewWithIntents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recycleviewWithIntents.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main2)

        Log.i("oncreate","in oncreate")
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        binding.titleText.text = extras.getString("title")
        binding.detailText.text = extras.getString("detail")
        binding.imageView.setImageResource(extras.getInt("image"))
    }
}