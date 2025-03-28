/*
package com.example.estudos.POO;

abstract class Pessoa {

    String corCebelo;
    int idade;
    String nome;

    void bebe() {
        System.out.println("Beber:");
    }

    void comer() {
        System.out.printf("Comer");
    }

}

interface Presidente{ //  A INTERFACE É ABSTRACT E
    // NAO PODE TER CORPO -
    // nao é instanciada
    // tiramos o {} do void e deixamos somente os ()

    void candidatarseCargoPolitico();
}

class DesenvolvedorWeb extends Pessoa  {
    void programar() {}

}

class Jornalista extends Pessoa implements Presidente {
    void escreverNoticia() {
    }

    @Override
    public void candidatarseCargoPolitico() {
        System.out.printf("Candidatar-se a cargo politico");

    }
}

    class DesenvolvedorAndroid extends Pessoa {
        void programar() {
        }
    }


    class Scratch {
        public void main(String[] args) {

            DesenvolvedorAndroid devAndroid = new DesenvolvedorAndroid();

            Jornalista jornalista = new Jornalista();
            jornalista.candidatarseCargoPolitico();

        }
    }


// ENTENDENDO O PROBLEA

// AQUI CRIAMOS DESENVOLVEDORWEB, DESENVOLVEDOR ANDROID E JORNALISTA
//CADA UM TEM SUAS PROPRIAS FUNCÇOES, MAS TAMBEM TEM FUNCOES EM COMUM POIS SÃO PESSOAS
//BEBEM, COMEM E ETC
//LOGO IREMOS CRIAR UMA CLASSE "PESSOA"

// FIZEMOS UM EXEMPLO DE CANDIDATAR=SE PARA CARGO POLITICO VOID
// SO QUE TODOS RECEBEM POR HERANÇA ESSE METODO E NAO QUEREMOS
//POIS DESENVOLVEDORES AQUI NO NOSSO EXEMPLO NÃO QUEREM SE CANDIDATAR A POLITICO

//EM HERANÇA ALGUMAS AÇÕES NÃO QUEREMOS QUE TODOS RECEBAM, MAS SOMENTE ALGUNS

    //----- > VAMOS USAR UMA INTERFACE

// NAO PODEMOPS CRIAR MAIS DE UMA CLASSE E HERDAR VARIAS, NO JAVA NAO EXISTE MULTIPLA HERANÇA

//----->>>>>> CRIAMOS A INTERFACE E DEPOIS NAS CLASSES ESPECIFICAS CHAMAMOS O "IMPLEMENTS" ASSIM COMO O EXTENDE

        //class Jornalista extends Pessoa implements Presidente

*/
/*
class Jornalista extends Pessoa implements Presidente {
    void escreverNoticia() {
    }

    @Override
    public void candidatarseCargoPolitico() {

    }
}*//*

*/