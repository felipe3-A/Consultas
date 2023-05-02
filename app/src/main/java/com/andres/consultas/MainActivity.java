package com.andres.consultas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText P;
    EditText R1;
    EditText R2;
    EditText R3;
    EditText R4;
  Button Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referenciar();
    }

    private void referenciar() {
        P=findViewById(R.id.Pregunta);
        R1=findViewById(R.id.Respuesta1);
        R2=findViewById(R.id.Respuesta2);
        R3=findViewById(R.id.Respuesta3);
        R4=findViewById(R.id.Respuesta4);
        Btn=findViewById(R.id.Btnconsultas);
    }
}