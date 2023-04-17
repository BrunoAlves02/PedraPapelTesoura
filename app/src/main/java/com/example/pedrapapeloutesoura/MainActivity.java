package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void clickPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void clickPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void clickTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario) {

            ImageView imagem = findViewById(R.id.imgResultado);
            TextView texto = findViewById(R.id.txtResultado);

            int aleatorio = new Random().nextInt(3);
            String[] opcoes = {"pedra", "papel", "tesoura"};
            String escolhaMaquina = opcoes[aleatorio];

            switch (escolhaMaquina) {
                case "pedra":
                    imagem.setImageResource(R.drawable.pedra);
                    break;
                case "papel":
                    imagem.setImageResource(R.drawable.papel);
                    break;
                case "tesoura":
                    imagem.setImageResource(R.drawable.tesoura);
                    break;
                default:
                    imagem.setImageResource(R.drawable.padrao);
            }


                if ( //maquina ganha
                        escolhaMaquina == "pedra" && opcaoUsuario == "tesoura" ||
                        escolhaMaquina == "papel" && opcaoUsuario == "pedra" ||
                        escolhaMaquina == "tesoura" && opcaoUsuario == "papel"
                ) {
                    texto.setText("Maquina ganhou!");
                } else if (
                        opcaoUsuario == "pedra" && escolhaMaquina == "tesoura" ||
                        opcaoUsuario == "papel" && escolhaMaquina == "pedra" ||
                        opcaoUsuario == "tesoura" && escolhaMaquina == "papel"
                ) {
                    texto.setText("Voce ganhou!");
                } else {
                    texto.setText("Empate!");
                }

    }
}

