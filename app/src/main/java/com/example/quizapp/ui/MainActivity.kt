package com.example.quizapp.ui

/*
imports necessários para o funcionamento e uso de matodos
*/
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifgoiano.quizapp.R
import br.edu.ifgoiano.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.data.QuizViewModel
import androidx.activity.viewModels

private const val TAG = "MainActivity"

/*
criação da classe MainActivity que compõe a tela activity_main além disso o AppCompatActivity()
torna a classe com o construtor padrão da tela que faz a composição com a activity_main.
*/
class MainActivity : AppCompatActivity() {
    /*
    variável do tipo de dados selecionados responsável por acessar os componentes
    */
    private lateinit var binding: ActivityMainBinding
    private val quizViewModel : QuizViewModel by viewModels()

    /*
    função para renderizar a tela responsável em criar a tela, toda tela deve ter uma função onCreate
    incluindo telas posteriores e telas iniciais
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate called")

        /*
        Permite que o aplicativo utilize toda a área da tela
        como até componentes de regiões próximas
        */
        enableEdgeToEdge()

        /*
        inicia a View Biding e define a conteúdo da tela principal
        */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        ajusta a predefinição dos espaços da tela de acordo com os conponentes do sistema
        */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*
        definição do conteúdo de acordo com o clique do botão "Verdadeiro"
        e quando clicar verifica a resposta do usuário
        */
        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        /*
        definição do conteúdo de acordo com o clique do botão "Falso"
        e quando clicar verifica a resposta do usuário
        */
        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        /*
        definição do conteúdo de acordo com o clique do botão "Próximo"
        e quando clicar verifica a resposta do usuário
        */
        binding.nextButton.setOnClickListener {
           quizViewModel.moveToNext()
            updateQuestion()
        }

        /*
        Exibe a primeira pergunta ao iniciar a tela
        */
        updateQuestion()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called")

    }

    /*
    função responsável por atualizar o texto da pergunta exibida na tela
    */
    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }

    /*
    Função responsável por veificar se a resposta do usuário
    corespondente à resposta correta
    */
    private fun checkAnswer(userAnswer: Boolean) {

        //capta a resposta correta
        val correctAnswer = quizViewModel.currentQuestionAnswer
        //define a mensagem exibida ao usuário
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        //exibe uma mensagem rápida confirmando a resposta ao usuário
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}