package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Pantalla_De_Carga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_carga);

        int Tiempo=3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Pantalla_De_Carga.this, MainActivity.class));
                finish();

            }
        },Tiempo);




    }
}
