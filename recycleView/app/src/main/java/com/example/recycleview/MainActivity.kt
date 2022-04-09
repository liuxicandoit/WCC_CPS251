package com.example.recycleview

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.recycleview.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var viewModel: MainViewModel
    private val TAG = "StateChange"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(TAG, "onCreate \n****************" + MainViewModel.isFirstArr)

        setSupportActionBar(binding.toolbar)

        //val firstArr= viewModel.set2DArr() //call that method from mainactivity
        //set boolean,save first array
        //viewModel.get2DArr()
        if (MainViewModel.isFirstArr) {
            viewModel.set2DArr()
        }

        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(viewModel)
        binding.contentMain.recyclerView.adapter = adapter

        /*val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        //viewModel.set2DArr()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        MainViewModel.isFirstArr = false
        Log.i(TAG, "onDestroy" + MainViewModel.isFirstArr)
    }

}