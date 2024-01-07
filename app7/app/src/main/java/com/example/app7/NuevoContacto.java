package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        // configuramos para guardar el contacto en base de datos
        Button btnNuevo = (Button) findViewById(R.id.btnNuevo);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // proceso para guardar un contacto en base de datos
                BBDD dataBase = new BBDD(getApplicationContext(), "agenda_db", null, 1);
                // accedemos a la base de datos en modo escritura
                SQLiteDatabase db = dataBase.getWritableDatabase();

                // obtenemos los datos de los dos inputs
                EditText edtNombreContacto = (EditText) findViewById(R.id.edtNombreContacto);
                String nombreContacto = edtNombreContacto.getText().toString();

                EditText edtTelefonoContacto = (EditText) findViewById(R.id.edtTelefonoContacto);
                String telefonoContacto = edtTelefonoContacto.getText().toString();

                // insertamos a la base de datos
                db.execSQL("INSERT INTO contactos (nombre, telefono) VALUES ('" + nombreContacto + "', '" + telefonoContacto + "')");
                db.close();

                edtNombreContacto.setText("");
                edtTelefonoContacto.setText("");

                Toast toast = Toast.makeText(getApplicationContext(), nombreContacto + " es nuevo contacto", Toast.LENGTH_LONG);
                toast.show();
            }
        });


        // para cerrar la activity
        Button btnAtras = (Button) findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NuevoContacto.this.finish();
            }
        });
    }
}