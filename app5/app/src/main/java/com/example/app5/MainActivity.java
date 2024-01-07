package com.example.app5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se usa la variable del boton para utilizarlo con el boton con el id
        b1 = (Button) findViewById(R.id.bt1);
        b1.setOnClickListener(view -> {
            // creamos el objeto de tipo Intent
            // esto para comunicarme de una actividad con otra
            Intent it1;

            // le decimos que sera igual a una nueva actividad
            // el objeto intent lleva, desde que actividad se usa hacia que actividad ira
            // no se puede poner this, porque hace referencia al onclick
            it1 = new Intent(MainActivity.this, SegundaActividad.class);

            // para pasar un valor de una activity a otra se utiliza el método putExtra
            it1.putExtra("p1", "Enviado");

            // arrancamos la nueva actividad
            startActivity(it1);
        });

        // conocido como Intent Filter, no se llama una actividad por su nombre
        // si no por lo que hace
        // application de como se hace cuando llamamos a otra actividad sin conocer su nombre
        b2 = (Button) findViewById(R.id.bt2);

        b2.setOnClickListener(view -> {
            Intent it2;

            // no le mandamos la clase, si no un identificador
            // el texto le estamos diciendo que quiero abrir aquella
            // actividad que tenga registrada la acción texto
            // esta acción se pone en el Android Manifest
            it2 = new Intent("TEXTO");
            it2.putExtra("p1", "Me han llamada sin poner la actividad");
            // arrancamos la nueva actividad
            startActivity(it2);
        });

        // notificaciones Toast
        b3 = (Button) findViewById(R.id.bt3);

        // escuchamos peticiones por medio del OnClick
        b3.setOnClickListener(view -> {
            // le decimos cuanto va a durar
            int duration = Toast.LENGTH_SHORT; // short, es corto. Long es larga. No se le puede indicar una dirección concreta

            // creamos un objeto de la clase
            // makeText, recibe el contexto donde se va a desarrollar el Toast, en este caso en el contexto de la propia aplicación
            // el texto que queremos poder y la duración
            Toast toast = Toast.makeText(getApplicationContext(), "Salida por medio del Toast", duration);
            toast.show();

            // Toast.makeText(this, etiqueta + "Estoy pasando por onStart", Toast.LENGTH_SHORT).show();
            // la salida puede ser asi o al final en la misma linea
        });

        // del objeto dialogo se tienen varios que heredan de la clase dialog, pero el mas interesante es este
        b4 = (Button) findViewById(R.id.bt4);
        b4.setOnClickListener(view -> {
            // creamos una ventana como tipico modal, creamos un objeto e la clase asociado a la actividad principal
            AlertDialog.Builder d1 = new AlertDialog.Builder(MainActivity.this);

            // ponemos titulo y mensaje
            d1.setTitle("Ejemplo de dialogo");
            d1.setMessage("Mensaje del dialogo");

            // colocamos distintos botones
            // set positive button: Yes message
            d1.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    // le decimos que en la caja de texto nos alerte que ha pulsado el usuario
                    TextView t1 = (TextView) findViewById(R.id.mensajeAlerta);
                    t1.setText("Haz pulsado el Si");
                }
            });

            // set negative button: no message
            d1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // cancele la caja de alerta and put a textview message
                    dialogInterface.cancel();
                    // Mensaje de salida en la caja
                    TextView t1 = (TextView) findViewById(R.id.mensajeAlerta);
                    t1.setText("Haz pulsado el No");
                }
            });

            // un boton neutral
            d1.setNeutralButton("Salir de la aplicación", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // salimos de la aplicacion, usamos la actividad principal
                    MainActivity.this.finish();
                }
            });

            // lo mostramos aqui
            // creamos el objeto con todas las caracteristicas anteriores
            AlertDialog alertDialog = d1.create();
            // mostramos el Dialog
            alertDialog.show();
        });
    }
}