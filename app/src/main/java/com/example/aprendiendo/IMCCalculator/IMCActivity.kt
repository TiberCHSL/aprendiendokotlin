package com.example.aprendiendo.IMCCalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aprendiendo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class IMCActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 60
    private var currentAge: Int = 18
    private var currentHeight: Int = 120

    private lateinit var btnCalculate: Button
    private lateinit var buttonSubstractAge: FloatingActionButton
    private lateinit var buttonAddAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var vistaHombre: CardView
    private lateinit var vistaMujer: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var buttonSubstractWeight: FloatingActionButton
    private lateinit var buttonAddWeight: FloatingActionButton
    private lateinit var tvWeight: TextView

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        initComponents()
        initListeners()
        initUI()
    }

    private fun initListeners() {
        vistaHombre.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        vistaMujer.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        buttonAddWeight.setOnClickListener {
            currentWeight +=1
            setWeight()
        }
        buttonSubstractWeight.setOnClickListener{
            currentWeight -=1
            setWeight()
        }
        buttonAddAge.setOnClickListener{
            currentAge+=1
            setAge()
        }
        buttonSubstractAge.setOnClickListener {
            currentAge-=1
            setAge()
        }
        btnCalculate.setOnClickListener{
            val result = calculateIMC(currentWeight,currentHeight)
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY,result)
        startActivity(intent)
    }

    private fun calculateIMC(weight: Int, height: Int): Double {
        val df = DecimalFormat("#.##")
        val imc = weight / (height.toDouble()/100*height.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        var newWeight: String = currentWeight.toString()
        tvWeight.text = "$newWeight KG"
    }

    private fun initComponents() {
        vistaHombre = findViewById(R.id.vistaHombre)
        vistaMujer = findViewById(R.id.vistaMujer)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        buttonAddWeight = findViewById(R.id.buttonAddWeight)
        buttonSubstractWeight = findViewById(R.id.buttonSubstractWeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        buttonAddAge = findViewById(R.id.buttonAddAge)
        buttonSubstractAge = findViewById(R.id.buttonSubstractAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        vistaHombre.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        vistaMujer.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val color = if (isSelectedComponent) {
            R.color.card_component_selected
        } else {
            R.color.card_component
        }
        return ContextCompat.getColor(this, color)
    }

}