package com.cursoandroid.mobileappnovo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RecuperarSenha  extends AppCompatActivity {

    private Button enviarRedefinicao;
    private EditText idEmailRecuperacao;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        inicalizaComponentes();
        eventoRedefinirSenha();

    }

    private void eventoRedefinirSenha() {
        enviarRedefinicao.setOnClickListener(view -> {
            String email = idEmailRecuperacao.getText().toString().trim();
            resetSenha(email);
        });
    }

    private void resetSenha(String idEmailRecuperacao) {
        auth.sendPasswordResetEmail(idEmailRecuperacao)
                .addOnCompleteListener(RecuperarSenha.this, task -> {
                    if (task.isSuccessful()){
                        alert("Um e-mail foi enviado para alteração de senha!");

                        Intent intent = new Intent(RecuperarSenha.this, FormLogin.class);
                        startActivity(intent);
                        finish();
                    }else {
                        alert("E-mail não registrado!");
                    }
                });
    }

    private void alert(String msg) {
        Toast.makeText(RecuperarSenha.this, msg, Toast.LENGTH_SHORT).show();
    }

    private void inicalizaComponentes(){
        enviarRedefinicao = findViewById(R.id.enviarRedefinicao);
        idEmailRecuperacao = findViewById(R.id.idEmailRecuperacao);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}
