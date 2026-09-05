package com.example.desafio2dsm

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var pbCargando: ProgressBar
    private lateinit var btnIniciarSesion: Button
    private lateinit var btnRegistrarse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        pbCargando = findViewById(R.id.pbCargando)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        btnRegistrarse = findViewById(R.id.btnRegistrarse)

        btnIniciarSesion.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validarCampos(email, password)) {
                iniciarSesion(email, password)
            }
        }

        btnRegistrarse.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validarCampos(email, password)) {
                registrarUsuario(email, password)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            navegarABienvenida()
        }
    }

    private fun validarCampos(email: String, pass: String): Boolean {
        if (email.isEmpty()) {
            etEmail.error = "Ingresa tu correo"
            etEmail.requestFocus()
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = "Ingresa un correo electrónico válido"
            etEmail.requestFocus()
            return false
        }

        if (pass.isEmpty()) {
            etPassword.error = "Ingresa tu contraseña"
            etPassword.requestFocus()
            return false
        }

        if (pass.length < 6) {
            etPassword.error = "La contraseña debe tener al menos 6 caracteres"
            etPassword.requestFocus()
            return false
        }

        return true
    }

    private fun iniciarSesion(email: String, pass: String) {
        mostrarCarga(true)
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                mostrarCarga(false)
                if (task.isSuccessful) {
                    Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                    navegarABienvenida()
                } else {
                    val errorMsg = task.exception?.localizedMessage ?: "Credenciales incorrectas"
                    Toast.makeText(this, "Error: $errorMsg", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun registrarUsuario(email: String, pass: String) {
        mostrarCarga(true)
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                mostrarCarga(false)
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    navegarABienvenida()
                } else {
                    val errorMsg = task.exception?.localizedMessage ?: "Fallo al registrar usuario"
                    Toast.makeText(this, "Error: $errorMsg", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun mostrarCarga(cargando: Boolean) {
        pbCargando.visibility = if (cargando) View.VISIBLE else View.GONE
        btnIniciarSesion.isEnabled = !cargando
        btnRegistrarse.isEnabled = !cargando
    }

    private fun navegarABienvenida() {
        val intent = Intent(this, WelcomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
