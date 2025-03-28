package com.example.estudos.POO

fun main() {

    data class Pessoa(
        val alturaPessoa: Float,
        val idadePessoa: Int,
        val nomePessoa: String,
        val sobrenomePessoa: String
    )

    val pessoa: Pessoa = Pessoa(1.63f, 35, "Thayara", "Soares")
    val pessoa2: Pessoa = Pessoa(1.63f, 35, "Thayara", "Soares")
    val pessoa3: Pessoa = Pessoa(1.65f, 36, "Carol", "Silva")


    //EXEMPLO DE NOMES E IDADE IGUAL

    println(pessoa)
    println(pessoa2)
    println(pessoa == pessoa2)


    if (pessoa == pessoa3){
        println("São as mesmas pessoas")
    }else{
        println("Não são as mesmas pessoas")
    }
}



