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
    private lateinit var btnEspanol: Button
    private lateinit var btnIngles: Button
    private lateinit var btnFrances: Button
    private lateinit var btnAleman: Button
    private lateinit var btnCerrarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        rgDificultad = findViewById(R.id.rgDificultad)
        rbFacil = findViewById(R.id.rbFacil)
        rbDificil = findViewById(R.id.rbDificil)
        btnEspanol = findViewById(R.id.btnQuizEspanol)
        btnIngles = findViewById(R.id.btnQuizIngles)
        btnFrances = findViewById(R.id.btnQuizFrances)
        btnAleman = findViewById(R.id.btnQuizAleman)
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)

        btnEspanol.setOnClickListener {
            iniciarQuiz("Español")
        }

        btnIngles.setOnClickListener {
            iniciarQuiz("Inglés")
        }

        btnFrances.setOnClickListener {
            iniciarQuiz("Francés")
        }

        btnAleman.setOnClickListener {
            iniciarQuiz("Alemán")
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

    private fun iniciarQuiz(tipoQuiz: String) {
        val dificultad = if (rbDificil.isChecked) "Difícil" else "Fácil"
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("TIPO_QUIZ", tipoQuiz)
        intent.putExtra("DIFICULTAD", dificultad)
        startActivity(intent)
    }
}
