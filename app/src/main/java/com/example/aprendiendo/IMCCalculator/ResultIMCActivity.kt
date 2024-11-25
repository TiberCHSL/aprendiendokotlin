package com.example.aprendiendo.IMCCalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aprendiendo.IMCCalculator.IMCActivity.Companion.IMC_KEY
import com.example.aprendiendo.R

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result) {
            in 0.00..18.50 -> {   // Bajo peso
                tvResult.text = getString(R.string.title_underweight)
                tvDescription.text = getString(R.string.description_underweight)
            } in 18.51..24.99 -> {   // Peso normal
                tvResult.text = getString(R.string.title_normalWeight)
                tvDescription.text = getString(R.string.description_normalWeight)
            } in 25.00..29.99  ->{   // Sobrepeso
                tvResult.text = getString(R.string.title_overweight)
                tvDescription.text = getString(R.string.description_overWeight)
            }
             in 30.00..99.00 -> {   // Obesidad
                tvResult.text = getString(R.string.title_obese)
                tvDescription.text = getString(R.string.description_obese)
        }
          else -> {
              tvIMC.text = getString(R.string.error)
              tvResult.text = getString(R.string.error)
              tvDescription.text = getString(R.string.error)
          }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}