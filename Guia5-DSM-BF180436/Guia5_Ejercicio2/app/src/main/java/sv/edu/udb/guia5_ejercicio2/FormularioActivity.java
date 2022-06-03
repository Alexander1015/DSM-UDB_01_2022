package sv.edu.udb.guia5_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormularioActivity extends AppCompatActivity {

    private EditText carnet,nombre,apellido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        carnet=(EditText)findViewById(R.id.carnet);
        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);
    }

    public void guardar (View v) {
        DatabaseHelper dbhelp = new DatabaseHelper(this,StudentsContentProvider.DATABASE_NAME, null, StudentsContentProvider.DATABASE_VERSION);
        ContentValues values = new ContentValues();
        values.put(StudentsContract.Columnas.NOMBRE, nombre.getText().toString());
        values.put(StudentsContract.Columnas.APELLIDO, apellido.getText().toString());
        values.put(StudentsContract.Columnas.CARNET, carnet.getText().toString());
        SQLiteDatabase db = dbhelp.getWritableDatabase();
        db.insert(StudentsContract.STUDENTS,null, values);
    }

    public void ver (View v) {
        Intent llamar = new Intent(this, MainActivity.class);
        startActivity(llamar);
    }
}