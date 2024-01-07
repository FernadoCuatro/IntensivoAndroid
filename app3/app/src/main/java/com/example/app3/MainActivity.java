package com.example.app3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/*
checkbox.setOnCheckedChangeListener => el evento

onCheckedCahnged () => Metodo a controlar

Con isChecked podemos comprobar el estado
*/

public class MainActivity extends AppCompatActivity {

    TextView eti1;
    CheckBox ck1;
    RadioGroup g1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // los asociamos a los objetos correspondientes
        eti1 = (TextView) findViewById(R.id.eti1);
        ck1 = (CheckBox) findViewById(R.id.ck1);

        // asociamos el grupo con el objeto que le corresponde
        g1 = (RadioGroup) findViewById(R.id.grupo1);

        // escuchamos un cambio en ese evento
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // validamos para el checked
                if (ck1.isChecked()) {
                    // para pasar a mayus
                    eti1.setText(eti1.getText().toString().toUpperCase());
                } else {
                    // para pasar a minus
                    eti1.setText(eti1.getText().toString().toLowerCase());
                }
            }
        });

        // responde ante los eventos
        g1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.azul) {
                    eti1.setTextColor(Color.BLUE);
                } else if (checkedId == R.id.rojo) {
                    eti1.setTextColor(Color.RED);
                } else if (checkedId == R.id.verde) {
                    eti1.setTextColor(Color.GREEN);
                } else if (checkedId == R.id.morado) {
                    eti1.setTextColor(Color.MAGENTA);
                }
            }
        });




    }
}