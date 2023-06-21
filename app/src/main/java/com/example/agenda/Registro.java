package com.example.agenda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    EditText NombreEt,CorreoEt,ContraseñaEt,ConfirmarContraseñaEt;
    Button RegistrarUsuario;
    TextView TengounacuentaTXT;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    //
    String nombre= " ", correo= " ", password= " " , confirmarpassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registrar");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        NombreEt= findViewById(R.id.NombreEt);
        CorreoEt= findViewById(R.id.CorreoEt);
        ContraseñaEt = findViewById(R.id.ContraseñaEt);
        ConfirmarContraseñaEt = findViewById(R.id.ConfirmarContraseñaEt);
        RegistrarUsuario = findViewById(R.id.RegistrarUsuario);
        TengounacuentaTXT = findViewById(R.id.TengounacuentaTXT);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(Registro.this);
        progressDialog.setTitle("Espere por favor");
        progressDialog.setCanceledOnTouchOutside(false);

        RegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        TengounacuentaTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });


    }
    private void ValidarDatos(){
        nombre= NombreEt.getText().toString();
        correo= CorreoEt.getText().toString();
        password=ContraseñaEt.getText().toString();
        confirmarpassword = ConfirmarContraseñaEt.getText().toString();

        if (TextUtils.isEmpty(nombre)){
            Toast.makeText(this, "Ingrese nombre", Toast.LENGTH_SHORT).show();
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            Toast.makeText(this, "Ingrese correo", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Ingrese contraseña", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(confirmarpassword)){
            Toast.makeText(this, "Confirme contraseña", Toast.LENGTH_SHORT).show();
        }
        else{
            CrearCuenta();
        }
    }

    private void CrearCuenta() {
        progressDialog.setMessage("Creando su cuenta");
    }
}