/*
package com.example.estudos

fun main(){

    //REPETIÇÃO DE LINHA DE CÓDIGO VÁRIAS VEZES SEM PRECISAR DUPLICAR AS LINHAS


    //exemplo da tabuada :

    */
/*1x1
    1x2
    1x3
    1x4
    1x5
    1x6
    1x7
    1x8
    1x9
    1x10*//*


    val tableOne = 1
    println(1 * tableOne)
    println(2 * tableOne)
    println(3 * tableOne)
    println(4 * tableOne)
    println(5 * tableOne)
    println(6 * tableOne)
    println(7 * tableOne)
    println(8 * tableOne)
    println(9 * tableOne)
    println(10 * tableOne)

 */
/*   //imagina repetir isso em grandes códigos

            //FOR LOOP
    FOR (VALOR INICIAL, BOOLEANO){
        ENQUANTO FOR FALSO O VALOR ELE REPETIRA, QUANDO FOR TRUE ELE PARA
    }

*//*


    //SINTAXE DO FOR

  for (i in 1..3){
      println("")
  }

    //EXEMPLO REAL FOR - CONTADOR I EM 1 ATÉ 4-- ELE VAI REPETIR ATÉ 4
    val item = 5

    for (i in 1..10){
        println(item * i)
    }

//LOOP + ARRAY - PEGA O ITEM IN COLLECTION

    val listaSupermecado = arrayOf("Ovos", "arroz", "feijão","açucar", "pimentão", "carne")

    //ACESSAR CADA ITEM DA LISTA ITEM POR ITEM UM A UM

    println(listaSupermecado[0])
    println(listaSupermecado[1])
    println(listaSupermecado[2])
    println(listaSupermecado[3])
    println(listaSupermecado[4])
    println(listaSupermecado[5])


    // AESSAR CADA ITEM DA LISTA COM FOR SEM PRECISAR ESCREVER UM POR UM

    for (i in listaSupermecado){
        println(i)
    }


    // ESSA FORMA É RUIM POIS SE ADICIONA UM ITEM A MAIS COMO SE FAZ, VOCE TEM QUE VIR MODIFICAR
    for (i in 0..5){
        println(listaSupermecado[i])
    }

//LASTINDEX

    for (i in 0..listaSupermecado.lastIndex){
        println(listaSupermecado[i])
    }

    //COM NUMERO INTEIRO

    for (i in listaSupermecado){
        println(i)
    }



*/


