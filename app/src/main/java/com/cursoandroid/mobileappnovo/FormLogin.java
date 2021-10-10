package com.cursoandroid.mobileappnovo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FormLogin extends AppCompatActivity {

    private EditText edit_user_email;
    private EditText edit_password;
    private Button btn_sign_in;
    private Button btn_sign_up;
    private Button btn_forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        inicializaComponentes();
        eventoCadastrar();
        eventoRedefinir();
    }

    private void inicializaComponentes() {
        edit_user_email = findViewById(R.id.edit_user);
        edit_password = findViewById(R.id.edit_password);
        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_sign_up = findViewById(R.id.btn_sign_up);
        btn_forgot_password = findViewById(R.id.btn_forgot_password);
    }

    private void eventoCadastrar(){
        btn_sign_up.setOnClickListener(view -> {
            Intent intent = new Intent(FormLogin.this, FormRegister.class);
            startActivity(intent);
            finish();
        });
    }

    private void eventoRedefinir() {
        btn_forgot_password.setOnClickListener(view -> {
            Intent i = new Intent(FormLogin.this, RecuperarSenha.class);
            startActivity(i);
            finish();
        });
    }
}