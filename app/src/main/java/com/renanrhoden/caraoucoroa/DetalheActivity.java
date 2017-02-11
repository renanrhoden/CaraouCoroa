package com.renanrhoden.caraoucoroa;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imagem;
    private ImageView botaoVoltar;
    private String[] opcao = {"Cara", "Coroa"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        imagem = (ImageView) findViewById(R.id.imagemID);
        botaoVoltar = (ImageView) findViewById(R.id.botaoVoltarID);

        setImage(getIntent().getStringExtra("opcao"));

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(2);

                setImage(opcao[numeroAleatorio]);
            }

        });

    }
    private void setImage(String s) {
        if ( s.equals("Cara") ){
            showToast(s);
            imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));
        }else{
            showToast(s);
            imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa));
        }
    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
