package com.cursoandroid.mobileappnovo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FormLogin extends AppCompatActivity {

    private EditText edit_user_email;
    private EditText edit_password;
    private Button btn_sign_in;
    private Button btn_sign_up;
    private Button btn_forgot_password;

    private FirebaseAuth auth;

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
            Intent intent = new Intent(
                    getApplicationContext(),
                    FormRegister.class);
            startActivity(intent);
        });

        btn_sign_in.setOnClickListener(view -> {
            String email = edit_user_email.getText().toString().trim();
            String senha = edit_password.getText().toString().trim();

            login(email, senha);
        });
    }

    private void login(String email, String senha) {
        auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(FormLogin.this, task -> {
                   if (task.isSuccessful()){
                       Intent intent = new Intent(FormLogin.this, MainPage.class);
                       startActivity(intent);
                   }else {
                       alert();
                   }
                });
    }

    private void alert() {
        Toast.makeText(FormLogin.this, "e-mail ou senha errados!", Toast.LENGTH_SHORT).show();
    }

    private void eventoRedefinir() {
        btn_forgot_password.setOnClickListener(view -> {
            Intent i = new Intent(FormLogin.this, RecuperarSenha.class);
            startActivity(i);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        auth = Conexao.getFirebaseAuth();
    }
}