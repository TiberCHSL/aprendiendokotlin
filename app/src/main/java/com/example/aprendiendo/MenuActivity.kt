package com.example.aprendiendo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aprendiendo.IMCCalculator.IMCActivity
import com.example.aprendiendo.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val botonsaludoql = findViewById<Button>(R.id.botonsaludoql)
        val btnIMCapp= findViewById<Button>(R.id.btnIMCapp)

        botonsaludoql.setOnClickListener { irasaludoql() }
        btnIMCapp.setOnClickListener{ iraimcql() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun iraimcql() {
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }

    fun irasaludoql() {
        val intent = Intent(this,FirstAppActivity::class.java)
        startActivity(intent)
    }
}

