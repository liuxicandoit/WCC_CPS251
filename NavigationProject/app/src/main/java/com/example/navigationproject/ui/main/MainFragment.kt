package com.example.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationproject.R
import com.example.navigationproject.databinding.MainFragmentBinding

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

        binding.button1.setOnClickListener {
            //val outImage= binding.imageView1.drawable
            val outImageID = binding.imageView1.tag //tag of the picture defined in xml file, will be parameter in mainToSecond()

            val viewText1="Image 1"
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond(outImageID.toString())
            action.setTitle(viewText1)
            action.setResultImage(outImageID.toString())  //pass picture data to secondFragment by imageview tag id


            Navigation.findNavController(it).navigate(action)

        }
/*
        binding.button2.setOnClickListener {
            //val outImage= binding.imageView1.drawable.toString()

            val viewText2="image 2"
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond()
            action.setTitle(viewText2)

            Navigation.findNavController(it).navigate(action)

        }

        binding.button3.setOnClickListener {
            //val outImage= binding.imageView1.drawable.toString()

            val viewText3="image 3"
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond()
            action.setTitle(viewText3)

            Navigation.findNavController(it).navigate(action)

        }*/
    }

}