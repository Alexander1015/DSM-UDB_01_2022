package edu.udb.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity_second extends AppCompatActivity {

    private EditText et4,et5,et6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
        et6=(EditText)findViewById(R.id.et6);
    }

    public void alta(View v) {
        ClientSQLiteOpenHelper admin = new ClientSQLiteOpenHelper(this,"administracion", null, 2);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String cod = et4.getText().toString();
        String nombre = et5.getText().toString();
        String edad = et6.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("codigo", cod);
        registro.put("nombres", nombre);
        registro.put("edad", edad);

        try {
            bd.insertOrThrow("clientes", null, registro);
            bd.close();
            et4.setText("");
            et5.setText("");
            et6.setText("");
            Toast.makeText(this, "Se cargaron los datos del cliente",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR!! No se cargaron los datos del cliente" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void consultaporcodigo(View v) {
        ClientSQLiteOpenHelper admin = new ClientSQLiteOpenHelper(this,"administracion", null, 2);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et4.getText().toString();
        Cursor fila = bd.rawQuery("select nombres,edad from clientes where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            et5.setText(fila.getString(0));
            et6.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un cliente con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void consultapornombres(View v) {
        ClientSQLiteOpenHelper admin = new ClientSQLiteOpenHelper(this,"administracion", null, 2);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombre = et5.getText().toString();
        Cursor fila = bd.rawQuery("select codigo,edad from clientes where nombres='" + nombre +"'", null);
        if (fila.moveToFirst()) {
            et4.setText(fila.getString(0));
            et6.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un cliente con dicho nombre",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void bajaporcodigo(View v) {
        ClientSQLiteOpenHelper admin = new ClientSQLiteOpenHelper(this,"administracion", null, 2);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et4.getText().toString();
        int cant = bd.delete("clientes", "codigo=" + cod, null);
        bd.close();
        et4.setText("");
        et5.setText("");
        et6.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró el cliente con dicho código",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un cliente con dicho código",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        ClientSQLiteOpenHelper admin = new ClientSQLiteOpenHelper(this,"administracion", null, 2);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et4.getText().toString();
        String nombre = et5.getText().toString();
        String edad = et6.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("nombres", nombre);
        registro.put("edad", edad);
        int cant = bd.update("clientes", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe un cliente con el código ingresado",
                    Toast.LENGTH_SHORT).show();
    }
}