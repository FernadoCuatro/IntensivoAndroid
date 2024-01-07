package com.f4.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

/*
Listener es un evento que esta esperando/escuchando por una determinada accion o proceso:
onClick():              View.OnClickListener. Cuando el usuario da click
onLongClick():          View.OnLongClicklistener. Cuando el ususario mantiene pulsado el elemento
onFocusChange():        View.OnFocusChangeListener. Cuando abandonamos el elemento
onKey():                View.OnKeyListener, Cuando pulsamos una tecla hardware
onTouch():              View.OnTouchListener. El usuario realiza una accion calificada como un evento de toque
OnCreateContextMenu():  View,OnCreateContextMenuListener. Se invoca al crear un menu contextual

*/

// cuando se hace de forma global se usa el implement desde la clase
// implementamos la interfas, la plantilla de metodos para implementar la interfas
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Se configura fuera del onCreate para poder utilizarlo de forma global
    TextView eti;
    Button b1;
    Button bt1;
    Button bt2;
    EditText edtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // enlazamos desde al xml
        // hacemos el cast
        eti = (TextView) findViewById(R.id.etiqueta);

        // cambiamos los datos con la clase
        eti.setText("He cambiado el contenido desde la clase");

        // Creamos un objeto de tipo boton
        b1 = (Button) findViewById(R.id.boton1);

        // lo asignamos aqui el bt1
        // usamos el listener desde la actividad es decir el implement
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        
        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);

        // asociamos el evento al boton
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // extraemos la informacion del edt
                // para colocarla en el input de arriba
                edtMensaje = (EditText) findViewById(R.id.edtMensaje);

                // Lo que quiera que hagamos, lo ponemos aqui
                // eti.setText("Haz pulsado el boton, hola que tal.");
                eti.setText(edtMensaje.getText().toString());
                // limpiamos el input de entrada
                edtMensaje.setText("");
            }
        });

    }

    // crear el metodo onClick
    public void onClick (View v) {
        
        // identificar el boton de uno u otro
        // if (v == bt1)
        if (v == bt1) {
            eti.setText("Haz pulsado el boton 1");
        } else if (v == bt2) {
            eti.setText("El boton 2 fue pulsado");
        }



    }



}

