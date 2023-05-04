package com.andres.consultas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText P;
    EditText R1;
    EditText R2;
    EditText R3;
    EditText R4;
  Button Btn;

   FirebaseDatabase database;
    DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referenciar();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, Andres!");

    }
public void intent(View view){
    Intent intent=new Intent(this,MainActivity2.class);
    startActivity(intent);
}
    private void referenciar() {
        //Referenciar a firefase

        database=FirebaseDatabase.getInstance();
        myref=database.getReference();


        P=findViewById(R.id.Pregunta);
        R1=findViewById(R.id.Respuesta1);
        R2=findViewById(R.id.Respuesta2);
        R3=findViewById(R.id.Respuesta3);
        R4=findViewById(R.id.Respuesta4);
        Btn=findViewById(R.id.Btnconsultas);
       Btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Preguntas preguntas =new Preguntas();
               preguntas.setId(UUID.randomUUID().toString());
               preguntas.setPregunta(P.getText().toString());
               preguntas.setRespuesta1(R1.getText().toString());
               preguntas.setRespuesta2(R2.getText().toString());
               preguntas.setRespuesta3(R3.getText().toString());
               preguntas.setRespuesta4(R4.getText().toString());

               myref.child("Preguntas").child(preguntas.getId()).setValue(preguntas);

               Toast.makeText(MainActivity.this, ""+preguntas.toString(), Toast.LENGTH_SHORT).show();

           }
       });
    }

}