package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.billAmount.text.isNotEmpty()) {
                val billValue = binding.billAmount.text.toString().toDouble()

                val tipValue10 = billValue * 0.1 + billValue
                val tipValue15 = billValue * 0.15 + billValue
                val tipValue20 = billValue * 0.2 + billValue

                val tipValue10Round = "%.2f".format(tipValue10).toDouble()
                val tipValue15Round = "%.2f".format(tipValue15).toDouble()
                val tipValue20Round = "%.2f".format(tipValue20).toDouble()

                val textOutput = "The tips are as follows:\n\n" +
                        " 10% = $tipValue10Round\n" + " 15% = $tipValue15Round\n" +
                        " 20% = $tipValue20Round"

                binding.textResult.text = textOutput.toString()


            } else {
                binding.textResult.text = getString(R.string.no_value_String)
            }
        }
    }
}


