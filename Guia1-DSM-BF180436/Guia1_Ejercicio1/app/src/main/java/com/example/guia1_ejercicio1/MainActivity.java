package com.example.guia1_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtnum1;
    private EditText txtnum2;
    private TextView lblresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnum1 = findViewById(R.id.txtnum1);
        txtnum2 = findViewById(R.id.txtnum2);
        lblresultado = findViewById(R.id.lblresultado);
    }

    public void verificar(View view) {
        String num1 = txtnum1.getText().toString();
        String num2 = txtnum2.getText().toString();

        int x = Integer.parseInt(num1);
        int y = Integer.parseInt(num2);

        int divi = x % y;
        String result = "";

        if (divi != 0) result = x + " NO ES divisible de " + y;
        else result = x + " ES divisible de " + y;
        lblresultado.setText(result);
    }
}