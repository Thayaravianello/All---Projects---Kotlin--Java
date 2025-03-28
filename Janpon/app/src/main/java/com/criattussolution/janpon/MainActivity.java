package com.criattussolution.janpon;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.criattussolution.janpon.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        var optionPc = binding.optionPc;
        var resultFinal = binding.resultFinal;


        var optionEscolha = binding.escolhaOption;
        var optionUser = binding.optionUser;
        var optionUser2 = binding.optionUser2;
        var optionUser3 = binding.optionUser3;
        var result = binding.result;


    }


    // ESCOLHA DO USUARIO
    public void selecionarPedra(View view) {
        verificarGanhador("Pedra");
    }


    public void selecionarPapel(View view) {
        verificarGanhador("Papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("Tesoura");
    }


    //ESCOLHA DO APP
    private String gerarEscolhaAleatoriaApp() {

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3);
        ImageView imagemApp = binding.optionPc;
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp) {
            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;


        }
        return escolhaApp;
    }

    private void verificarGanhador(String escolhaUsuario) {
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = binding.resultFinal;

        if (
            (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
            (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
            (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
        ) {
            textoResultado.setText("Você Perde :(");

        } else if (
            (escolhaUsuario == "pedra" && escolhaApp == "Tesoura") ||
            (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
            (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
        ) {
            textoResultado.setText("Você Ganhou :)");

        } else  {
            textoResultado.setText("Empatamos");
        }

    }
}