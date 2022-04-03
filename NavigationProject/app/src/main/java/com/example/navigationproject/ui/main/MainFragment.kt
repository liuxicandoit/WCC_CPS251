package com.example.navigationproject.ui.main

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.navigationproject.R
import com.example.navigationproject.databinding.MainFragmentBinding
import java.io.ByteArrayOutputStream
import java.util.*


class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding?=null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val action =  MainFragmentDirections.mainToSecond()

        binding.button1.setOnClickListener {
            val title1="Image 1"
            val imageResId1 = R.drawable.android_image_1

            action.setTitle(title1)
            action.setResultImage(imageResId1)

            Navigation.findNavController(it).navigate(action)


        }
        binding.button2.setOnClickListener {
            val title2="Image 2"
            val imageResId2 = R.drawable.android_image_2

            action.setTitle(title2)
            action.setResultImage(imageResId2)

            Navigation.findNavController(it).navigate(action)
        }


        binding.button3.setOnClickListener {
            val title3="Image 3"
            val imageResId3 = R.drawable.android_image_3

            action.setTitle(title3)
            action.setResultImage(imageResId3)

            Navigation.findNavController(it).navigate(action)
        }
    }




}