package com.example.desafio2dsm.data

import com.example.desafio2dsm.models.Question

object QuizQuestionsData {

    fun getQuestions(language: String, difficulty: String): List<Question> {
        return when (language) {
            "Español" -> getSpanishLanguageQuestions(difficulty)
            "Inglés" -> getEnglishLanguageQuestions(difficulty)
            "Francés" -> getFrenchLanguageQuestions(difficulty)
            "Alemán" -> getGermanLanguageQuestions(difficulty)
            else -> emptyList()
        }
    }

    // ESPAÑOL - Las frases están en ESPAÑOL, la respuesta correcta es siempre "Español"
    private fun getSpanishLanguageQuestions(difficulty: String): List<Question> {
        return if (difficulty == "Fácil") {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"Hola, ¿cómo estás?\"", listOf("Español", "Inglés", "Francés"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"Tengo hambre y sed\"", listOf("Portugués", "Español", "Italiano"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"Me encanta este día soleado\"", listOf("Catalán", "Español", "Gallego"), 1),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Gracias por tu ayuda\"", listOf("Español", "Francés", "Rumano"), 0),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Los gatos duermen en la casa\"", listOf("Inglés", "Español", "Alemán"), 1)
            )
        } else if (difficulty == "Medio") {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"Necesitamos encontrar una solución rápidamente\"", listOf("Español", "Portugués", "Francés"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"La educación es fundamental para el desarrollo\"", listOf("Italiano", "Español", "Inglés"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"Aunque sea difícil, nunca debemos rendirnos\"", listOf("Español", "Francés", "Alemán"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"El mercado está lleno de productos frescos\"", listOf("Portugués", "Español", "Holandés"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Hemos estado esperando este momento\"", listOf("Español", "Italiano", "Rumano"), 0)
            )
        } else {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"La perspectiva contemporánea enfatiza la importancia de la sostenibilidad\"", listOf("Español", "Francés", "Portugués"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"Mediante la introspección, podemos comprender nuestras contradicciones\"", listOf("Inglés", "Español", "Italiano"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"La complejidad del fenómeno requiere un análisis multidisciplinario\"", listOf("Español", "Holandés", "Alemán"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Antaño, las civilizaciones mesoamericanas poseían conocimientos astronómicos\"", listOf("Catalán", "Español", "Gallego"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"La epistemología contempla las limitaciones del conocimiento humano\"", listOf("Español", "Francés", "Portugués"), 0)
            )
        }
    }

    // INGLÉS - Las frases están en INGLÉS, la respuesta correcta es siempre "Inglés"
    private fun getEnglishLanguageQuestions(difficulty: String): List<Question> {
        return if (difficulty == "Fácil") {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"Hello, how are you?\"", listOf("Francés", "Inglés", "Español"), 1),
                Question(2, "¿En qué idioma está esta frase?\n\n\"I like apples and oranges\"", listOf("Alemán", "Inglés", "Holandés"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"The cat is on the table\"", listOf("Inglés", "Sueco", "Dinamarqués"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Do you speak English?\"", listOf("Escocés", "Inglés", "Galés"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Thank you very much\"", listOf("Noruego", "Inglés", "Finlandés"), 1)
            )
        } else if (difficulty == "Medio") {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"Understanding different cultures enriches our perspective\"", listOf("Inglés", "Alemán", "Francés"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"The development of technology has transformed society\"", listOf("Holandés", "Inglés", "Sueco"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"Unfortunately, we couldn't attend the conference\"", listOf("Inglés", "Italiano", "Portugués"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Environmental protection requires collective responsibility\"", listOf("Alemán", "Inglés", "Polaco"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"She has been working here for five years\"", listOf("Francés", "Inglés", "Español"), 1)
            )
        } else {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"The exponential proliferation of digital platforms necessitates unprecedented regulatory frameworks\"", listOf("Inglés", "Francés", "Alemán"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"Phenomenologically, consciousness encompasses multifaceted dimensions of human experience\"", listOf("Holandés", "Inglés", "Sueco"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"Epistemological considerations underpin contemporary philosophical discourse\"", listOf("Inglés", "Italiano", "Portugués"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"The juxtaposition of disparate ideologies precipitates intellectual ferment\"", listOf("Alemán", "Inglés", "Polaco"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Notwithstanding their heterogeneity, these paradigms coalesce around fundamental principles\"", listOf("Francés", "Inglés", "Español"), 1)
            )
        }
    }

    // FRANCÉS - Las frases están en FRANCÉS, la respuesta correcta es siempre "Francés"
    private fun getFrenchLanguageQuestions(difficulty: String): List<Question> {
        return if (difficulty == "Fácil") {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"Bonjour, comment allez-vous?\"", listOf("Español", "Francés", "Italiano"), 1),
                Question(2, "¿En qué idioma está esta frase?\n\n\"J'aime beaucoup le café\"", listOf("Portugués", "Francés", "Rumano"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"Où est la gare?\"", listOf("Francés", "Inglés", "Alemán"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Au revoir, à bientôt\"", listOf("Catalán", "Francés", "Provenzal"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Le pain est très bon\"", listOf("Italiano", "Francés", "Holandés"), 1)
            )
        } else if (difficulty == "Medio") {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"La vie est une aventure extraordinaire\"", listOf("Francés", "Portugués", "Español"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"Nous devons protéger notre environnement\"", listOf("Inglés", "Francés", "Alemán"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"L'apprentissage des langues ouvre des portes\"", listOf("Francés", "Italiano", "Catalán"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Malgré les difficultés, nous continuerons\"", listOf("Holandés", "Francés", "Sueco"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Les enfants jouent dans le parc\"", listOf("Francés", "Portugués", "Español"), 0)
            )
        } else {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"L'épistémologie contemporaine s'interroge sur la légitimité du savoir scientifique\"", listOf("Francés", "Alemán", "Inglés"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"La déconstruction des paradigmes établis s'avère indispensable\"", listOf("Italiano", "Francés", "Holandés"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"La phénoménologie transcende la dichotomie sujet-objet\"", listOf("Francés", "Portugués", "Español"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"La prolifération des méthodologies complexifie le champ disciplinaire\"", listOf("Catalán", "Francés", "Provenzal"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"L'herméneutique constitue un enjeu majeur de la philosophie contemporaine\"", listOf("Francés", "Sueco", "Polaco"), 0)
            )
        }
    }

    // ALEMÁN - Las frases están en ALEMÁN, la respuesta correcta es siempre "Alemán"
    private fun getGermanLanguageQuestions(difficulty: String): List<Question> {
        return if (difficulty == "Fácil") {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"Guten Tag, wie geht es Ihnen?\"", listOf("Holandés", "Alemán", "Sueco"), 1),
                Question(2, "¿En qué idioma está esta frase?\n\n\"Ich mag Schokolade sehr gerne\"", listOf("Alemán", "Noruego", "Danés"), 0),
                Question(3, "¿En qué idioma está esta frase?\n\n\"Wo ist die Bibliothek?\"", listOf("Inglés", "Alemán", "Francés"), 1),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Auf Wiedersehen, bis später\"", listOf("Sueco", "Alemán", "Polaco"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Das Auto ist rot\"", listOf("Holandés", "Alemán", "Checo"), 1)
            )
        } else if (difficulty == "Medio") {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"Die Bildung ist der Schlüssel zum Erfolg\"", listOf("Alemán", "Holandés", "Inglés"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"Wir müssen die Umwelt schützen\"", listOf("Francés", "Alemán", "Español"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"Das Leben ist voller Überraschungen\"", listOf("Alemán", "Italiano", "Portugués"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Trotz der Schwierigkeiten geben wir nicht auf\"", listOf("Sueco", "Alemán", "Noruego"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Die Kinder spielen im Garten\"", listOf("Alemán", "Holandés", "Inglés"), 0)
            )
        } else {
            listOf(
                Question(1, "¿En qué idioma está esta frase?\n\n\"Die erkenntnistheoretische Problematik der Wissenschaftlichkeit bedarf einer grundlegenden Neubetrachtung\"", listOf("Alemán", "Inglés", "Holandés"), 0),
                Question(2, "¿En qué idioma está esta frase?\n\n\"Die Dekonstruktion etablierter Paradigmen erweist sich als notwendig\"", listOf("Francés", "Alemán", "Sueco"), 1),
                Question(3, "¿En qué idioma está esta frase?\n\n\"Phänomenologisch betrachtet transzendiert die Erfahrung die Subjekt-Objekt-Dichotomie\"", listOf("Alemán", "Portugués", "Español"), 0),
                Question(4, "¿En qué idioma está esta frase?\n\n\"Die Proliferation empirischer Methodologien kompliziert das wissenschaftliche Feld\"", listOf("Polaco", "Alemán", "Checo"), 1),
                Question(5, "¿En qué idioma está esta frase?\n\n\"Die Hermeneutik stellt ein fundamentales Anliegen zeitgenössischer Philosophie dar\"", listOf("Alemán", "Danés", "Sueco"), 0)
            )
        }
    }
}


