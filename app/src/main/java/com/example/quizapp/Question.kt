package com.example.quizapp
/*
imports necessários para o funcionamento e uso de matodos
*/
import androidx.annotation.StringRes
/*
função que seleciona as questões por strings que é selecionado de acordo com o clique na tela no botão confirmar
*/
data class Question(@StringRes val textResId: Int, val answer: Boolean)
