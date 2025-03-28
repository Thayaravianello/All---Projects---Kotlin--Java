/*
package com.example.estudos


*/
/*PROGRAMAÇÃO ORIENTADA A OBJETOS


        //EXISTE VARIOS TIPOS DE PROGRAMAÇÃO
                // BAIXO NIVEL: MAIS PRÓXIMO DA LINGUAGEM DE MÁQUINA
                // ALTO NIVEL: MAIS DISTANTE DA LINGUAGEM DA MÁQUINA E MAIS PRÓXIMA DA HUMANA


1 -PROGRAMACAO LINEAR: DE BAIXO PARA CIMA , O CÓDIGO É EXECUTADO SEGUINDO UMA LINHA DE IDEIAS

2- PROGRAMACAO ESTRUTURADA - EVOLUCAO DA PRPGRAMACAO LINEAR. NA LINEAR PRECISARIA REESCREVER O CODIGO
    //NA ESTRUTURADA CONSEGUIMOS AGRUPAR AS OPERACOES QUE ERAM FEITAS, COMO POR EXEMPLO "SOMAR"
        //FUN SOMAR(NUMERO 1, NUMERO2)

            // NUMERO1 + NUMERO2

 3 - PROGRAMACAO MODULAR
    //TELA INICIAL DO SISTEMA
    // TELA PRINCIPAL DO SISTEMA
    // FUNAO LOGAR... FUNCAO DESLOGAR

- SIGNIFICA QUE A ESTRUTURA PODE SER REPETIDA EM VARIOS LUGARES DO CODIGO
        //CRIA UM MODULO COM UMA FUNCAO COM DADOS POR EXEMPLO "USUARIO

4 -PROGRAMACAO ORIENTADA A OBJETOS - CONCEITO DE MODULO COMO A MODULAR
 ATRAVÉS DE CLASSES QUE PODEM SER REAPROVEITADAS- RELACAO ENTRE CLASSE SE ETC

*//*


*/
/*

class ModeloMarioKartJogador{

    // ATRIBUTO

    String kart;
    String pneu ;
    String planador;

        //CRIAR METODOS

    //(ação vazia significa o VOID)
    void acelerar(){
        System.out.println("Acelerar")
    }

}

class POO {

        //CRIAR UMA INSTANCIA DE UM OBJETO
        String nome = "Jammilton"
        ModeloMarioKartJogador Thayara = ModeloMarioKartJogador(); // NOSSO PROPRIO TIPO CRIADO
        Thayara.kart = "Normal",
        Thayara.pneu ="Gelo"
        Thayara.planador  = "Avião"

        //CHAMAR O METODO

        Thayara.acelerar()
    }

*//*




class FuncionarioBanco {

    //ATRIBUTOS
    var nome: String = ""
    var sobrenome: String = ""
    var salario: Float = 0.0f
    var bonus: Float = 0.0f
    var descontos:Float = 0.0f


    //MÉTODOS

    fun salarioTotalCalcular(salario: Float, bonus: Float, descontos: Float) {
        this.salario
        this.bonus
        this.descontos



    }
}

fun main() {
    val FuncionarioBanco = FuncionarioBanco()
    FuncionarioBanco.nome = "Caio"
    FuncionarioBanco.sobrenome = "Pinto"
    FuncionarioBanco.salario = 2565.55f
    FuncionarioBanco.bonus = 200.0f
    FuncionarioBanco.descontos = 100.0f

    println( FuncionarioBanco.nome + " "+ FuncionarioBanco.sobrenome + " Salário:" + FuncionarioBanco.salario )
    println( "Descontos:" + FuncionarioBanco.descontos + " Bonus:" +FuncionarioBanco.bonus )


    return FuncionarioBanco.salarioTotalCalcular()


}

private fun FuncionarioBanco.salarioTotalCalcular() {
    salario = 2565.55f
    bonus = 200.00f
    descontos = 100.00f

}


*/
