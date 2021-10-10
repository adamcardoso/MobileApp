package com.cursoandroid.mobileappnovo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperarSenha  extends AppCompatActivity {

    private Button enviarRedefinicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        enviarRedefinicao = findViewById(R.id.enviarRedefinicao);

        enviarRedefinicao.setOnClickListener(view -> {
            Intent intent = new Intent(RecuperarSenha.this, FormLogin.class);
            startActivity(intent);
            finish();

            Toast.makeText(getApplicationContext(),
                    "Verifique seu email!",
                    Toast.LENGTH_SHORT).show();
        });
    }
}
