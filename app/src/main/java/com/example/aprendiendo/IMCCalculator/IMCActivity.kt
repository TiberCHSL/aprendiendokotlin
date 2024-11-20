package com.example.aprendiendo.IMCCalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aprendiendo.R

class IMCActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var vistaHombre: CardView
    private lateinit var vistaMujer: CardView
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
    }

    private fun initComponents() {
        vistaHombre = findViewById(R.id.vistaHombre)
        vistaMujer = findViewById(R.id.vistaMujer)
    }

    private fun initUI() {
        setGenderColor()
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