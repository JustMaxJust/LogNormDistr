package com.example.lognormdistr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private val confirmButton: Button by lazy { findViewById(R.id.get_random_num) }
    private val muInput: TextView by lazy { findViewById(R.id.mean_val) }
    private val sigmaInput: TextView by lazy { findViewById(R.id.variance_value) }
    private val result: TextView by lazy { findViewById(R.id.random_number_result) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        confirmButton.setOnClickListener {
            InputHandler.handle(
                muInput.text.toString(),
                sigmaInput.text.toString(),
                fun (str1: String, str2: String) {
                    result.text = LognormalDistribution.generate(
                        str1.toDouble(),
                        str2.toDouble().pow(0.5)
                    ).toString()
                },
                fun (errorMsg) {
                    result.text = errorMsg
                }
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(resultSisKey, result.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        result.text = savedInstanceState.getString(resultSisKey) ?: ""
    }

    companion object {
        private const val resultSisKey = "generated_num"
    }
}
