package com.example.dmorales.seguimientosillabus.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dmorales.seguimientosillabus.R;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText txtUsuario;
    TextInputEditText txtPassword;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = (TextInputEditText) findViewById(R.id.login_input_usuario);
        txtPassword = (TextInputEditText) findViewById(R.id.login_input_password);
        btnIngresar = (Button) findViewById(R.id.login_boton_ingresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = txtUsuario.getText().toString();
                String pass = txtPassword.getText().toString();

                if(usuario.equals("dmorales") && pass.equals("12345")){
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                }else Toast.makeText(LoginActivity.this, "usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
