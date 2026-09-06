package com.example.desafio2dsm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio2dsm.data.QuizQuestionsData
import com.example.desafio2dsm.models.QuizResult

class QuizActivity : AppCompatActivity() {

    private var tipoQuiz = ""
    private var dificultad = ""
    private val quizResult by lazy { QuizResult(tipoQuiz, dificultad, mutableMapOf()) }
    private val questions by lazy { QuizQuestionsData.getQuestions(tipoQuiz, dificultad) }
    private val radioGroups = mutableListOf<RadioGroup>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        tipoQuiz = intent.getStringExtra("TIPO_QUIZ") ?: ""
        dificultad = intent.getStringExtra("DIFICULTAD") ?: ""

        val tvHeader: TextView = findViewById(R.id.tvQuizHeader)
        tvHeader.text = "Quiz de $tipoQuiz - $dificultad"

        val llQuestions: LinearLayout = findViewById(R.id.llQuestions)
        createQuestionViews(llQuestions)

        findViewById<Button>(R.id.btnEnviarQuiz).setOnClickListener { enviarQuiz() }
        findViewById<Button>(R.id.btnReiniciarQuiz).setOnClickListener { reiniciarQuiz() }
    }

    private fun createQuestionViews(container: LinearLayout) {
        questions.forEachIndexed { index, question ->
            val questionView = createQuestionView(index, question)
            container.addView(questionView)
        }
    }

    private fun createQuestionView(index: Int, question: com.example.desafio2dsm.models.Question): LinearLayout {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(16, 16, 16, 16) }
        }

        val tvQuestion = TextView(this).apply {
            text = "${index + 1}. ${question.text}"
            textSize = 16f
            setTextColor(resources.getColor(R.color.primary_dark_blue, null))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 12 }
        }
        layout.addView(tvQuestion)

        val radioGroup = RadioGroup(this).apply {
            orientation = RadioGroup.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            question.options.forEachIndexed { optionIndex, option ->
                val radioButton = RadioButton(this@QuizActivity).apply {
                    text = option
                    id = optionIndex
                    layoutParams = RadioGroup.LayoutParams(
                        RadioGroup.LayoutParams.MATCH_PARENT,
                        RadioGroup.LayoutParams.WRAP_CONTENT
                    ).apply { bottomMargin = 8 }
                }
                addView(radioButton)
            }
            setOnCheckedChangeListener { _, checkedId ->
                quizResult.selectedAnswers[question.id] = checkedId
            }
        }
        radioGroups.add(radioGroup)
        layout.addView(radioGroup)

        val divider = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1).apply { setMargins(0, 8, 0, 8) }
            setBackgroundColor(resources.getColor(R.color.border_color, null))
        }
        layout.addView(divider)

        return layout
    }

    private fun enviarQuiz() {
        if (!allQuestionsAnswered()) {
            Toast.makeText(this, "Por favor responde todas las preguntas", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this, ResultsActivity::class.java)
        intent.putExtra("QUIZ_RESULT", quizResult)
        intent.putExtra("QUESTIONS", questions.toTypedArray())
        startActivity(intent)
    }

    private fun allQuestionsAnswered(): Boolean {
        return quizResult.selectedAnswers.size == questions.size
    }

    private fun reiniciarQuiz() {
        quizResult.selectedAnswers.clear()
        radioGroups.forEach { it.clearCheck() }
        Toast.makeText(this, "Quiz reiniciado", Toast.LENGTH_SHORT).show()
    }
}
