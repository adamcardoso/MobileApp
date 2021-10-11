package com.cursoandroid.mobileappnovo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UsandoRecycler extends AppCompatActivity {

    private Button btn_voltar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        inicializaComponentes();
        eventoVoltar();
    }

    private void inicializaComponentes() {
        btn_voltar3 = findViewById(R.id.btn_voltar3);
    }

    private void eventoVoltar() {
        btn_voltar3.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainPage.class);
            startActivity(intent);
            finish();
        });
    }
}
