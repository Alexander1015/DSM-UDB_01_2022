package com.example.guia1_ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtnum;
    private TextView lblresultado;
    public List<Integer> digitos = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnum = findViewById(R.id.txtnum);
        lblresultado = findViewById(R.id.lblresultado);
    }

    public void agregar(View view) {
        try {
            String num = txtnum.getText().toString();
            int x = Integer.parseInt(num);
            digitos.add(x);
            txtnum.setText("");
            lblresultado.setText("");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void verificar(View view) {
        try {
            String resultado = "";
            int par = 0;
            int impar = 0;
            for (int i = 0; i < digitos.size(); i++) {
                int num = digitos.get(i);
                if (num % 2 == 0) {
                    par++;
                }
                else {
                    impar++;
                }
            }
            int total = par + impar;
            if (total == digitos.size()) {
                resultado = "Hay " + par + " digitos par/es y " + impar + " digitos impar/es";
                digitos.clear();
            }
            else resultado = "Los datos no cuadraron, vuelva a ingresarlos.";
            lblresultado.setText(resultado);
            txtnum.setText("");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}