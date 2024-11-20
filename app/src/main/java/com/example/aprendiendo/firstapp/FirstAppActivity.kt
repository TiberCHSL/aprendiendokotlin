package com.example.aprendiendo.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aprendiendo.R
// https://stackoverflow.com/questions/28238037/git-log-out-user-from-command-line para hacer logout
// de github a traves de cmd



class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app) //diseño de la actividad
        val botonqlo = findViewById<AppCompatButton>(R.id.botonqlo)     // codigo para pasarle a la actividad la vista botonqlo
        val editando = findViewById<AppCompatEditText>(R.id.editando)
        botonqlo.setOnClickListener{
            val name = editando.text.toString()
            if (name.isNotEmpty()){
                Log.i("Donwea","se pulso el botonqlo $name} ")
                val intent = Intent(this, SaludoActivity::class.java)
                intent.putExtra("EXTRA_NAME",name)
                startActivity(intent)
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

//campos de texto es sp, para layout es dp