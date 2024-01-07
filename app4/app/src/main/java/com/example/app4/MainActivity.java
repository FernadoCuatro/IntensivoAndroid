package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String etiqueta = "Evento >> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, etiqueta + "Estoy pasando por onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, etiqueta + "Estoy pasando por onStart", Toast.LENGTH_SHORT).show();
    }

    // todo esto esta comentado
    // comentado con ese color

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, etiqueta + "Estoy pasando por onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, etiqueta + "Estoy pasando por onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, etiqueta + "Estoy pasando por onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, etiqueta + "Estoy pasando por onResume", Toast.LENGTH_SHORT).show();
    }

}