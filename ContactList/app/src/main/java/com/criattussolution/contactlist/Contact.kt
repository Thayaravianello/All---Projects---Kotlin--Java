package com.criattussolution.contactlist

import androidx.annotation.DrawableRes

data class Contact(
    val nome: String,
    val telefone: String,
    @DrawableRes val iconeImagem:Int,
)
