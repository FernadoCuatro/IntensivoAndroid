package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // comprobamos si la base de datos existe o no existe
        BBDD dataBase = new BBDD(getApplicationContext(), "agenda_db", null, 1);

        // boton para nuevo contacto
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // llamamos a la otra actividad
                Intent intent = new Intent(getApplicationContext(), NuevoContacto.class);
                startActivity(intent);
            }
        });

        // boton para buscar
        ImageButton btnSearch = (ImageButton) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // llamamos a la otra actividad
                Intent intent = new Intent(getApplicationContext(), ListaContacto.class);
                startActivity(intent);
            }
        });

        // para limpiar la tabla de contactos
        ImageButton btnDelete = (ImageButton) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // no necesitamos una actividad nueva
                // abrimos la base de datos
                BBDD dataBase = new BBDD(getApplicationContext(), "agenda_db", null, 1);
                // accedemos a la base de datos en modo escritura
                SQLiteDatabase db = dataBase.getWritableDatabase();

                db.execSQL("DROP TABLE IF EXISTS contactos");
                db.execSQL("CREATE TABLE contactos (nombre TEXT, telefono TEXT)");

                Toast toast = Toast.makeText(getApplicationContext()," Se limpio la lista de los contactos", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        // para cerrar la activity
        ImageButton btnExit = (ImageButton) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });


    }
}