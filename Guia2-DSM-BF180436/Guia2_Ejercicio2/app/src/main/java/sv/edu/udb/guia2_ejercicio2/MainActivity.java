package sv.edu.udb.guia2_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtHoras = (EditText) findViewById(R.id.txtHoras);
    }

    public void calcular(View view) {
        String nombre = txtNombre.getText().toString();
        String numh = txtHoras.getText().toString();

        int hora = Integer.parseInt(numh);

        double salario = hora * 8.50;
        double isss = salario * 0.02;
        double afp = salario * 0.03;
        double renta = salario * 0.04;
        double neto = salario - isss - afp - renta;

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("txtNombre", txtNombre.getText().toString());
        i.putExtra("txtHorasTot", txtHoras.getText().toString());
        i.putExtra("txtISSS", isss);
        i.putExtra("txtAFP", afp);
        i.putExtra("txRenta", renta);
        i.putExtra("txtSalarioNeto", neto);
        startActivity(i);
    }
}