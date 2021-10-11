package com.cursoandroid.mobileappnovo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FormRegister extends AppCompatActivity {

    private EditText edit_add_email;
    private EditText edit_add_password;
    private Button btn_registrar;
    private Button btn_voltar;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);

        inicializaComponentes();
        eventoCadastrar();
        eventoVoltar();
    }

    private void inicializaComponentes() {
        edit_add_email = findViewById(R.id.edit_add_email);
        edit_add_password = findViewById(R.id.edit_add_password);
        btn_voltar = findViewById(R.id.btn_voltar);
        btn_registrar = findViewById(R.id.btn_registrar);
    }

    private void eventoCadastrar() {
        btn_registrar.setOnClickListener(view -> {
            String email = edit_add_email.getText().toString().trim();
            String senha = edit_add_password.getText().toString().trim();

            criarUsuario(email, senha);
        });
    }

    private void eventoVoltar() {
        btn_voltar.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), FormLogin.class);
            startActivity(intent);
            finish();
        });
    }

    private void criarUsuario(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(FormRegister.this, task -> {
                    if (task.isSuccessful()){
                        alert("Usuário cadastrado com sucesso!");

                        Intent intent = new Intent(FormRegister.this, FormLogin.class);
                        startActivity(intent);
                        finish();
                    }else {
                        alert("Erro de cadastro!");
                    }
                });
    }

    private void alert(String msg){
        Toast.makeText(FormRegister.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}