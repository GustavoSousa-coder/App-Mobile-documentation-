package com.example.quizapp.data

import androidx.lifecycle.ViewModel
import br.edu.ifgoiano.quizapp.R
import com.example.quizapp.Question

class QuizViewModel : ViewModel() {

    /*
    Banco de questões que vão aparecer na tela a cada clique de confirmação de respostas
    aqui ela já recebe a resposta padrão se é verdadeiro ou falso, que é verificado de acordo com a resposta
    */
    private val questionBank = listOf(
        Question(R.string.question_goiania, true),
        Question(R.string.question_araguaia, true),
        Question(R.string.question_caldas, true),
        Question(R.string.question_capital, false),
        Question(R.string.question_pequi, false),
        Question(R.string.question_chapada, true))

    /*
    variável indicativa da posição das perguntas
    */
    private var currentIndex = 0

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

}