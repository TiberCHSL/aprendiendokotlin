package com.example.aprendiendo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aprendiendo.IMCCalculator.IMCActivity
import com.example.aprendiendo.TODOapp.TODOActivity
import com.example.aprendiendo.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var botonsaludoql: Button
    private lateinit var btnIMCapp: Button
    private lateinit var btnTODO: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
    }

    private fun initListeners() {
        botonsaludoql.setOnClickListener { irasaludoql() }
        btnIMCapp.setOnClickListener { iraimcql() }
        btnTODO.setOnClickListener { iraTODO() }
    }

    private fun iraTODO() {
        val intent = Intent(this,TODOActivity::class.java)
        startActivity(intent)
    }

    private fun iraimcql() {
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }

    fun irasaludoql() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
    fun initComponents() {
        botonsaludoql = findViewById(R.id.botonsaludoql)
        btnIMCapp = findViewById(R.id.btnIMCapp)
        btnTODO = findViewById(R.id.btnTODO)
    }
}

