package com.renanrhoden.caraoucoroa;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.ads.*;


import java.util.Random;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imagem;
    private ImageView botaoVoltar;
    private String[] opcao = {"Cara", "Coroa"};
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        adView = new AdView(this, getResources().getString(R.string.placement_id_banner), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(adView);
        AdSettings.addTestDevice("f2e5da66c3d39d36f1a9eb74b8c4a5e6");
        adView.loadAd();

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
            imagem.setVisibility(View.INVISIBLE);
            Animation anim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
            imagem.setAnimation(anim);
            anim.start();
            imagem.setVisibility(View.VISIBLE);
            imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));
        }else{
            imagem.setVisibility(View.INVISIBLE);
            Animation anim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
            imagem.setAnimation(anim);
            anim.start();
            imagem.setVisibility(View.VISIBLE);
            imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa));
        }
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
