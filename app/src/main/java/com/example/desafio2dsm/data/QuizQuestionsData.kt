package com.example.desafio2dsm.data

import com.example.desafio2dsm.models.Question

object QuizQuestionsData {

    fun getQuestions(quizType: String, difficulty: String): List<Question> {
        return when (quizType) {
            "Idiomas" -> getLanguageQuestions(difficulty)
            "Historia (Siglo XX)" -> getHistoryQuestions(difficulty)
            else -> getLanguageQuestions(difficulty)
        }
    }

    private fun getLanguageQuestions(difficulty: String): List<Question> {
        return when (difficulty) {
            "Fácil" -> getEasyLanguageQuestions()
            else -> getHardLanguageQuestions()
        }
    }

    private fun getHistoryQuestions(difficulty: String): List<Question> {
        return when (difficulty) {
            "Fácil" -> getEasyHistoryQuestions()
            else -> getHardHistoryQuestions()
        }
    }

    // IDIOMAS - FÁCIL: Inglés, Italiano, Francés, Alemán, Portugués
    private fun getEasyLanguageQuestions(): List<Question> {
        return listOf(
            // Inglés (germánico) vs Alemán, Neerlandés
            Question(1, "¿En qué idioma está esta frase?\n\n\"Hello, how are you today?\"", listOf("Alemán", "Inglés", "Sueco"), 1),

            // Francés (romance) vs Italiano, Portugués, Español
            Question(2, "¿En qué idioma está esta frase?\n\n\"Bonjour, comment allez-vous?\"", listOf("Italiano", "Francés", "Portugués"), 1),

            // Italiano (romance) vs Francés, Portugués
            Question(3, "¿En qué idioma está esta frase?\n\n\"Buongiorno, come stai?\"", listOf("Portugués", "Italiano", "Francés"), 1),

            // Alemán (germánico) vs Inglés, Holandés
            Question(4, "¿En qué idioma está esta frase?\n\n\"Guten Tag, wie geht es Ihnen?\"", listOf("Inglés", "Alemán", "Holandés"), 1),

            // Portugués (romance) vs Italiano, Francés
            Question(5, "¿En qué idioma está esta frase?\n\n\"Olá, como você está?\"", listOf("Francés", "Portugués", "Italiano"), 1)
        )
    }

    // MEDIO: Coreano, Ruso, Chino, Árabe, Rumano
    // Agrupar: Ruso-Rumano (eslavos/balcánicos) | Chino-Coreano-Vietnamita (asiáticos) | Árabe-Hebreo (semíticos)
    private fun getMediumQuestions(): List<Question> {
        return listOf(
            // Chino vs Coreano, Vietnamita
            Question(1, "¿En qué idioma está esta frase?\n\n\"你好，你好吗？\"", listOf("Coreano", "Chino", "Vietnamita"), 1),

            // Coreano vs Chino, Japonés
            Question(2, "¿En qué idioma está esta frase?\n\n\"안녕하세요, 어떻게 지내세요?\"", listOf("Chino", "Coreano", "Tailandés"), 1),

            // Ruso vs Rumano, Búlgaro
            Question(3, "¿En qué idioma está esta frase?\n\n\"Здравствуйте, как дела?\"", listOf("Rumano", "Ruso", "Búlgaro"), 1),

            // Árabe vs Hebreo, Persa
            Question(4, "¿En qué idioma está esta frase?\n\n\"مرحبا، كيف حالك؟\"", listOf("Hebreo", "Árabe", "Persa"), 1),

            // Rumano vs Ruso, Serbio
            Question(5, "¿En qué idioma está esta frase?\n\n\"Bună ziua, cum te simți?\"", listOf("Ruso", "Rumano", "Serbio"), 1)
        )
    }

    // IDIOMAS - DIFÍCIL: Tailandés, Kazajo, Japonés, Vietnamita, Turco
    private fun getHardLanguageQuestions(): List<Question> {
        return listOf(
            // Tailandés vs Vietnamita, Lao
            Question(1, "¿En qué idioma está esta frase?\n\n\"สวัสดี ยังไงบ้าง\"", listOf("Vietnamita", "Tailandés", "Lao"), 1),

            // Vietnamita vs Tailandés, Camboyano
            Question(2, "¿En qué idioma está esta frase?\n\n\"Xin chào, bạn khỏe không?\"", listOf("Tailandés", "Vietnamita", "Camboyano"), 1),

            // Japonés vs Coreano, Chino
            Question(3, "¿En qué idioma está esta frase?\n\n\"おはようございます\"", listOf("Coreano", "Japonés", "Chino"), 1),

            // Kazajo vs Turco, Uzbeco
            Question(4, "¿En qué idioma está esta frase?\n\n\"Сәлем, қалың қалай?\"", listOf("Turco", "Kazajo", "Uzbeco"), 1),

            // Turco vs Kazajo, Tártaro
            Question(5, "¿En qué idioma está esta frase?\n\n\"Merhaba, nasılsın?\"", listOf("Kazajo", "Turco", "Uzbeco"), 1)
        )
    }

    // HISTORIA (SIGLO XX) - FÁCIL
    private fun getEasyHistoryQuestions(): List<Question> {
        return listOf(
            Question(1, "¿En qué año comenzó la Primera Guerra Mundial?", listOf("1912", "1914", "1916"), 1),
            Question(2, "¿Cuál fue la capital del Imperio Austro-Húngaro?", listOf("Berlín", "Viena", "Praga"), 1),
            Question(3, "¿Quién fue el primer presidente de los Estados Unidos?", listOf("Thomas Jefferson", "George Washington", "Benjamin Franklin"), 1),
            Question(4, "¿En qué año terminó la Segunda Guerra Mundial?", listOf("1943", "1944", "1945"), 2),
            Question(5, "¿Cuál fue la capital del Imperio Alemán bajo el Kaiser?", listOf("Múnich", "Berlín", "Hamburgo"), 1)
        )
    }

    // HISTORIA (SIGLO XX) - DIFÍCIL
    private fun getHardHistoryQuestions(): List<Question> {
        return listOf(
            Question(1, "¿Cuál fue el Tratado que terminó la Primera Guerra Mundial?", listOf("Versalles", "París", "Berlín"), 0),
            Question(2, "¿En qué año ocurrió la Revolución Rusa?", listOf("1917", "1919", "1915"), 0),
            Question(3, "¿Cuál fue el nombre de la crisis de misiles que casi causa WWIII?", listOf("Crisis de Berlín", "Crisis de Cuba", "Crisis de Suez"), 1),
            Question(4, "¿En qué año se fundó el Estado de Israel?", listOf("1945", "1948", "1950"), 1),
            Question(5, "¿En qué año se construyó el Muro de Berlín?", listOf("1958", "1961", "1964"), 1)
        )
    }
}

