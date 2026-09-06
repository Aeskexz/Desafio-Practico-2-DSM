package com.example.desafio2dsm.data

import com.example.desafio2dsm.models.Question

object QuizQuestionsData {

    fun getQuestions(quizType: String, difficulty: String): List<Question> {
        return when (quizType) {
            "Idiomas" -> getLanguageQuestions(difficulty)
            "Historia (Siglo XX)" -> getHistoryQuestions(difficulty)
            "Informática" -> getComputerQuestions(difficulty)
            "Cultura general salvadoreña" -> getSalvadoranCultureQuestions(difficulty)
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

    private fun getComputerQuestions(difficulty: String): List<Question> {
        return when (difficulty) {
            "Fácil" -> getEasyComputerQuestions()
            else -> getHardComputerQuestions()
        }
    }

    private fun getSalvadoranCultureQuestions(difficulty: String): List<Question> {
        return when (difficulty) {
            "Fácil" -> getEasySalvadoranCultureQuestions()
            else -> getHardSalvadoranCultureQuestions()
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

    private fun getEasyComputerQuestions(): List<Question> {
        return listOf(
            Question(1, "¿Cuál de estos es un lenguaje de programación?", listOf("Python", "HTML", "CSS"), 0),
            Question(2, "¿Qué lenguaje se ejecuta principalmente en la máquina virtual de Java?", listOf("Java", "SQL", "Bash"), 0),
            Question(3, "¿Qué tipo de dato representa verdadero o falso?", listOf("Booleano", "Decimal", "Cadena"), 0),
            Question(4, "¿Qué símbolo se usa habitualmente para iniciar un comentario de una línea en Kotlin?", listOf("//", "##", "<!--"), 0),
            Question(5, "¿Qué estructura de datos almacena elementos en pares clave-valor?", listOf("Mapa", "Pila", "Cola"), 0)
        )
    }

    private fun getHardComputerQuestions(): List<Question> {
        return listOf(
            Question(1, "¿Qué complejidad temporal tiene la búsqueda binaria en una colección ordenada?", listOf("O(n)", "O(log n)", "O(n²)"), 1),
            Question(2, "¿Qué principio de POO permite que una subclase ofrezca una implementación específica de un método?", listOf("Herencia", "Polimorfismo", "Encapsulamiento"), 1),
            Question(3, "¿Qué estructura sigue el principio LIFO?", listOf("Cola", "Árbol", "Pila"), 2),
            Question(4, "¿Qué protocolo se usa normalmente para transferir páginas web de forma segura?", listOf("HTTP", "FTP", "HTTPS"), 2),
            Question(5, "¿Qué palabra clave de Kotlin declara una referencia que no puede ser nula?", listOf("?", "!!", "lateinit"), 2)
        )
    }

    private fun getEasySalvadoranCultureQuestions(): List<Question> {
        return listOf(
            Question(1, "¿Cuál es la capital de El Salvador?", listOf("San Salvador", "Santa Ana", "San Miguel"), 0),
            Question(2, "¿En qué año se declaró la independencia de Centroamérica de España?", listOf("1810", "1821", "1838"), 1),
            Question(3, "¿Cuál es el ave nacional de El Salvador?", listOf("Torogoz", "Quetzal", "Tucán"), 0),
            Question(4, "¿Cuál es la moneda de curso legal adoptada en El Salvador desde 2001?", listOf("Dólar estadounidense", "Peso salvadoreño", "Colón costarricense"), 0),
            Question(5, "¿Cómo se conoce tradicionalmente al volcán de Izalco?", listOf("El Faro del Pacífico", "La Montaña Azul", "El Guardián del Norte"), 0)
        )
    }

    private fun getHardSalvadoranCultureQuestions(): List<Question> {
        return listOf(
            Question(1, "¿En qué año comenzó el conflicto armado interno de El Salvador?", listOf("1972", "1980", "1992"), 1),
            Question(2, "¿En qué fecha se firmaron los Acuerdos de Paz de Chapultepec?", listOf("16 de enero de 1992", "15 de septiembre de 1980", "1 de junio de 1994"), 0),
            Question(3, "¿En qué año se fundó el FMLN?", listOf("1975", "1980", "1985"), 1),
            Question(4, "¿En qué año ocurrió la guerra de las Cien Horas entre El Salvador y Honduras?", listOf("1965", "1969", "1974"), 1),
            Question(5, "¿En qué año fue asesinado el arzobispo Óscar Arnulfo Romero?", listOf("1977", "1980", "1983"), 1)
        )
    }
}

