package com.example.addnamesavedata2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.addnamesavedata2.databinding.MainFragmentBinding
import androidx.lifecycle.Observer
import com.example.addnamesavedata2.R
import com.example.addnamesavedata2.BR.myViewModel

class MainFragment : Fragment() {

    //private var _binding: MainFragmentBinding? = null
    //private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //_binding = MainFragmentBinding.inflate(inflater,container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)
        return binding.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.setVariable(myViewModel, viewModel)



        //binding.displayNames.text= viewModel.getName().toString()
        /*val nameObserver = Observer<String>{
            name -> binding.outputNames.text = name.toString()
        }

        viewModel.getName().observe(viewLifecycleOwner, nameObserver)

        binding.addNamebtn.setOnClickListener{
            viewModel.getName()
        }*/

        /*binding.addNamebtn.setOnClickListener {
            if (binding.editText.text.isNotEmpty()){
                viewModel.setName(binding.editText.text.toString())

                binding.outputNames.text = viewModel.getName().toString()
            }else{
                binding.outputNames.text = "No Name Displayed"
            }
        }*/


    }

}