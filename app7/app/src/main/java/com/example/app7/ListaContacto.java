package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListaContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contacto);

        // abrimos la base de datos
        // cargamos automaticamente la informacion de la lista de contactos
        BBDD dataBase = new BBDD(getApplicationContext(), "agenda_db", null, 1);
        // accedemos a la base de datos en modo escritura
        SQLiteDatabase db = dataBase.getWritableDatabase();

        // hacemos la busqueda del contenido, que campos vamos a leer
        String[] campos = new String[] {"nombre", "telefono"};
        // el cursor para movernos en los registros
        // hacemos el query con los campos que vamos a recuperar
        Cursor c = db.query("contactos", campos, null, null, null,null, null);

        // recuperamos la caja de texto para llenar
        TextView tvLista = (TextView) findViewById(R.id.tvLista);

        // nos movemos al primero registro, si no hubiese nada; pues no pasa nada se va vacio
        if (c.moveToFirst()) {
            do {
                // recuperamos por la posicion de columnas
                String telefono = c.getString(1);
                String nombre = c.getString(0);
                // add al text concatenando la informacion anterior con la informacion nueva
                tvLista.setText(tvLista.getText().toString() + telefono + "\t .... \t" + nombre + "\n");
            } while (c.moveToNext());
        }

        // para cerrar la activity
        Button btnAtras = (Button) findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListaContacto.this.finish();
            }
        });
    }
}