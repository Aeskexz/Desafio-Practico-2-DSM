package com.example.desafio2dsm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.desafio2dsm.models.Question
import com.example.desafio2dsm.models.QuizResult

class ResultsActivity : AppCompatActivity() {

    private lateinit var quizResult: QuizResult
    private lateinit var questions: Array<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        quizResult = intent.getParcelableExtra("QUIZ_RESULT") ?: QuizResult("", "", mutableMapOf())
        @Suppress("DEPRECATION")
        questions = intent.getParcelableArrayExtra("QUESTIONS") as? Array<Question> ?: arrayOf()

        displayResults()
        setupButtons()
    }

    private fun displayResults() {
        val correctCount = calculateCorrectAnswers()

        val tvScore: TextView = findViewById(R.id.tvScore)
        tvScore.text = "Obtuviste $correctCount de ${questions.size} respuestas correctas"

        val tvQuizType: TextView = findViewById(R.id.tvQuizType)
        tvQuizType.text = "Quiz: ${quizResult.language} - Dificultad: ${quizResult.difficulty}"

        val tvFeedback: TextView = findViewById(R.id.tvFeedback)
        tvFeedback.text = getFeedbackMessage(correctCount)

        displayAnswerReview()
    }

    private fun calculateCorrectAnswers(): Int {
        return questions.count { question ->
            val selectedIndex = quizResult.selectedAnswers[question.id]
            selectedIndex == question.correctAnswerIndex
        }
    }

    private fun getFeedbackMessage(correctCount: Int): String {
        return when {
            correctCount <= 1 -> "Mejor me dedico a otra cosa"
            correctCount in 2..3 -> "Mas o menos OK"
            correctCount == 4 -> "Me merezco un churro"
            correctCount == 5 && quizResult.difficulty == "Difícil" -> "Como pegarle a un bolo"
            else -> "¡Bien hecho!"
        }
    }

    private fun displayAnswerReview() {
        val llReview: LinearLayout = findViewById(R.id.llAnswerReview)

        questions.forEach { question ->
            val reviewView = createReviewView(question)
            llReview.addView(reviewView)
        }
    }

    private fun createReviewView(question: Question): LinearLayout {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(12, 12, 12, 12) }
            setBackgroundColor(resources.getColor(R.color.surface_white, null))
            elevation = 2f
        }

        val tvQuestion = TextView(this).apply {
            text = question.text
            textSize = 15f
            setTextColor(resources.getColor(R.color.primary_dark_blue, null))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 8 }
        }
        layout.addView(tvQuestion)

        val selectedIndex = quizResult.selectedAnswers[question.id] ?: -1
        val isCorrect = selectedIndex == question.correctAnswerIndex

        val tvSelected = TextView(this).apply {
            text = "Tu respuesta: ${question.options.getOrNull(selectedIndex) ?: "No respondida"}"
            textSize = 13f
            setTextColor(if (isCorrect) resources.getColor(R.color.success_green, null) else resources.getColor(R.color.error_red, null))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 4 }
        }
        layout.addView(tvSelected)

        if (!isCorrect) {
            val tvCorrect = TextView(this).apply {
                text = "Respuesta correcta: ${question.options[question.correctAnswerIndex]}"
                textSize = 13f
                setTextColor(resources.getColor(R.color.success_green, null))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = 8 }
            }
            layout.addView(tvCorrect)
        }

        val divider = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                1
            ).apply { setMargins(0, 8, 0, 0) }
            setBackgroundColor(resources.getColor(R.color.border_color, null))
        }
        layout.addView(divider)

        return layout
    }

    private fun setupButtons() {
        findViewById<Button>(R.id.btnRetryQuiz).setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("TIPO_QUIZ", quizResult.language)
            intent.putExtra("DIFICULTAD", quizResult.difficulty)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.btnAnotherQuiz).setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this, "Sesión finalizada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
