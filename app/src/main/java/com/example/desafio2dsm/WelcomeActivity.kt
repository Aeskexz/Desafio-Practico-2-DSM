package com.example.desafio2dsm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {

    private lateinit var rgDificultad: RadioGroup
    private lateinit var rbFacil: RadioButton
    private lateinit var rbDificil: RadioButton
    private lateinit var btnIdiomas: com.google.android.material.button.MaterialButton
    private lateinit var btnHistoria: com.google.android.material.button.MaterialButton
    private lateinit var btnComenzar: Button
    private lateinit var btnCerrarSesion: Button

    private var tipoQuizSeleccionado = "Idiomas"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        rgDificultad = findViewById(R.id.rgDificultad)
        rbFacil = findViewById(R.id.rbFacil)
        rbDificil = findViewById(R.id.rbDificil)
        btnIdiomas = findViewById(R.id.btnIdiomas)
        btnHistoria = findViewById(R.id.btnHistoria)
        btnComenzar = findViewById(R.id.btnComenzar)
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)

        btnIdiomas.setOnClickListener {
            tipoQuizSeleccionado = "Idiomas"
            btnIdiomas.isSelected = true
            btnHistoria.isSelected = false
        }

        btnHistoria.setOnClickListener {
            tipoQuizSeleccionado = "Historia (Siglo XX)"
            btnHistoria.isSelected = true
            btnIdiomas.isSelected = false
        }

        btnComenzar.setOnClickListener {
            iniciarQuiz()
        }

        btnCerrarSesion.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this, "Sesión finalizada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun iniciarQuiz() {
        val dificultad = when (rgDificultad.checkedRadioButtonId) {
            R.id.rbFacil -> "Fácil"
            else -> "Difícil"
        }

        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("TIPO_QUIZ", tipoQuizSeleccionado)
        intent.putExtra("DIFICULTAD", dificultad)
        startActivity(intent)
    }
}


