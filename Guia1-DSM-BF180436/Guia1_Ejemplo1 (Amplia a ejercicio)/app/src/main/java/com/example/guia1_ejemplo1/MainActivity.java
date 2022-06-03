package com.example.guia1_ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
    }

    //Este metodo se ejecutara cuando se presione el boton
    public void sumar(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);

        int suma = nro1 + nro2;

        String resu = String.valueOf(suma);
        tv1.setText(resu);
    }

    public void restar(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);

        int suma = nro1 - nro2;

        String resu = String.valueOf(suma);
        tv1.setText(resu);
    }

    public void multiplicar(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);

        int suma = nro1 * nro2;

        String resu = String.valueOf(suma);
        tv1.setText(resu);
    }

    public void dividir(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);

        String resu = "Resultado";
        if (nro2 == 0) {
            resu = "No se puede realizar esa operacion";
        }
        else {
            int suma = nro1 / nro2;
            resu = String.valueOf(suma);
        }

        tv1.setText(resu);
    }
}