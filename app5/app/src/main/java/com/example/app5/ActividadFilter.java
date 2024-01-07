package com.example.app5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActividadFilter extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_filter);

        // buscamos el elemento por el ID
        t1 = (TextView) findViewById(R.id.mensaje);

        // recuperamos el valor del elemento enviado desde la Activity
        // Bundle es un paquete que nos permite recuperar los parámetros que nos llegan en el Intent
        Bundle bundle = getIntent().getExtras();
        t1.setText(bundle.getString("p1"));
    }
}