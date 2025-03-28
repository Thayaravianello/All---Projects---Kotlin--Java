/*
package com.example.estudos;


//CONTRUTOR - CONSTRUIR OBJETO
// PARA CONSTRUIR PRECISAMOS CRIAR INFORMACOES QUE SAO NECESSARIAS PARA SEU FUNCIONAMENT

// COMO CONSTRUIR


class Usuario {

    //OBJETIVO GUARDAR INFORMACOES DO USUARIO
    // FAZER AÇÕES DO USUARIO

    //-> ATRIBUTOS
    String nome;
    String sobrenome;
    String email;
    String senha;
    int idade;


    // --> CONSTRUTOR

    //METODO PRECISA DO VOID COM RETORNO OU SEM
    // CONSTRUTOR ELE ESTÁ RELACIONADO DIRETAMENTE COM O OBJETO USUARIO, COM A CLASSE
    // NAO VAMOS USAR VOID E SIM O MESMO NOME DA CLASSE

    //CHAMADO EM DETERMNADO MOMENTO
    // É ESPECIAL
    //VAI SER EXECUTANDO QUANDO PASSARMOS ALGUM PARAMETRO LA NO  usuario.verificarUsuarioLogado();, OU SEJA, QUANDO FOR INSTANCIADO
    //CONSTRUTOR NAO USAMOS VOID, INT, DOUBLE E ETC

    //TEMOS QUE DEFIINIR PARAMETROS AQUI NO ()

    //PARA NAO VIR COM VALOR NULL TEMOS QUE CHAMAR O THIS + O ITEM DA CLASSE

    Usuario(String nome, String sobrenome, String email, String senha, int idade) {

        System.out.println("Autenticador por email e senha");
        this.nome = email;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;

    }


*/
/*//*
/ASSINATURA DE METODO^: UTILIZAR MESMO NOME DE METODO OU CONSTRUTOR - NOME + PARAMETRO + TIPO
    Usuario(String nome, String sobrenome, String email, int senha, int idade) {

      System.out.println("Contrutor chamado");
        this.nome = email;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idade = idade;

    }*//*




    Usuario(String telefone ) {

        System.out.println("Autenticacao por telefone");


    }



    //---> MeTODO

    //ABSTRACAO - OBJETOS DO MUNDO REAL PARA O SEU APP SELECIONANDO SO O NECESSARIO

    //METODO PARA VERIFICAR SE ESTA LOGADO


    void verificarUsuarioLogado() {

    }

    // EXEMPLOIS DE METODO -SOBRECARGA

    void logar (String email , String senha){}
    void logar (String telefone, int token){}

}

//INSTANCIAR O USUARIO CRIANDO UMA CLASSE MAIN

class Scratch {
    public static void main(String[] args) {


      */
/*  //PASSANDO PARAMETROS PARA O CONSTRUTOR

        Usuario usuario = new Usuario("Thayara", "Soares", "thayarasoares@gmail.com", "5552225", 35); // NO JAVA PARA CRIAR NOVO TEMOS QUE CHAMAR O NEW
        Usuario usuario2 = new Usuario("58661553");

        System.out.println("NOME:" + "  " + usuario.nome + "SOBRENOME:" + "  " + usuario.sobrenome + "EMAIL:" + "  " + usuario.email + "SENHA:" + "  " + usuario.senha + "IDADE:" + "  " + usuario.idade);

*//*

        //O CONSTRUTOR SERVE PARA QUE NÃO PRECISEMOS COLCOAR ESSAS DEFINICOES AQUI
        */
/*usuario.email ="thayarasoares@gmail.com";
        usuario.nome ="Thayara";
        usuario.sobrenome ="Soares";
        usuario.idade = 36;
        usuario.senha = 5552225;
        usuario.verificarUsuarioLogado();*//*



        //INSTANCIAR O METODO

        Usuario usuario = new Usuario();
        usuario.logar("552265522532");
        usuario.logar("thayara@hp", "56353232");
    }
}

//EXEMPLO CARRO: PARA ANDAR EM UM CARRO, PRECISAMOS DA CHAVE, GASOLINA E ETC  -  Usuario usuario = new Usuario();
*/
