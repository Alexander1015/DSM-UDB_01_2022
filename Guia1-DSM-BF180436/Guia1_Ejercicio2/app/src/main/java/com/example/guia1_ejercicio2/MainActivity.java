package com.example.guia1_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtnum1;
    private EditText txtnum2;
    private EditText txtnum3;
    private EditText txtnum4;
    private EditText txtnum5;
    private EditText txtnum6;
    private EditText txtnum7;
    private EditText txtnum8;
    private EditText txtnum9;
    private EditText txtnum10;
    private TextView lblresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnum1 = findViewById(R.id.txt1);
        txtnum2 = findViewById(R.id.txt2);
        txtnum3 = findViewById(R.id.txt3);
        txtnum4 = findViewById(R.id.txt4);
        txtnum5 = findViewById(R.id.txt5);
        txtnum6 = findViewById(R.id.txt6);
        txtnum7 = findViewById(R.id.txt7);
        txtnum8 = findViewById(R.id.txt8);
        txtnum9 = findViewById(R.id.txt9);
        txtnum10 = findViewById(R.id.txt10);
        lblresultado = findViewById(R.id.lblresultado);
    }

    public void verificar(View view) {
        String num1 = txtnum1.getText().toString();
        String num2 = txtnum2.getText().toString();
        String num3 = txtnum3.getText().toString();
        String num4 = txtnum4.getText().toString();
        String num5 = txtnum5.getText().toString();
        String num6 = txtnum6.getText().toString();
        String num7 = txtnum7.getText().toString();
        String num8 = txtnum8.getText().toString();
        String num9 = txtnum9.getText().toString();
        String num10 = txtnum10.getText().toString();

        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int n3 = Integer.parseInt(num3);
        int n4 = Integer.parseInt(num4);
        int n5 = Integer.parseInt(num5);
        int n6 = Integer.parseInt(num6);
        int n7 = Integer.parseInt(num7);
        int n8 = Integer.parseInt(num8);
        int n9 = Integer.parseInt(num9);
        int n10 = Integer.parseInt(num10);

        int may7 = 0;
        int men7 = 0;

        if (n1 >= 7) may7++;
        else men7++;
        if (n2 >= 7) may7++;
        else men7++;
        if (n3 >= 7) may7++;
        else men7++;
        if (n4 >= 7) may7++;
        else men7++;
        if (n5 >= 7) may7++;
        else men7++;
        if (n6 >= 7) may7++;
        else men7++;
        if (n7 >= 7) may7++;
        else men7++;
        if (n8 >= 7) may7++;
        else men7++;
        if (n9 >= 7) may7++;
        else men7++;
        if (n10 >= 7) may7++;
        else men7++;
        String resultado = "Hay " + may7 + " nota/s mayor/res o igual/es que 7 y hay " + men7 + " nota/s menor/es";
        lblresultado.setText(resultado);

    }
}