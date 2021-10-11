package com.cursoandroid.mobileappnovo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


public class MainPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textGithub:
                Toast.makeText(this, "Indo para Github", Toast.LENGTH_SHORT).show();
                caminhoGithub();
                break;
            case R.id.textApi:
                Toast.makeText(this, "Abrindo API", Toast.LENGTH_SHORT).show();
                abrirApi();
                break;
            case R.id.textRecyclerView:
                Toast.makeText(this, "Abrindo Recycler View", Toast.LENGTH_SHORT).show();
                abrirRecycler();
                break;
            case R.id.textProfile:
                Toast.makeText(this, "Abrindo Profile", Toast.LENGTH_SHORT).show();
                abrirProfile();
                break;
            case R.id.textAdicionar:
                Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show();
                break;
        }
    }



    private void caminhoGithub() {
        String url = "https://github.com/adamcardoso/MobileApp";

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void abrirApi() {
        Intent intent = new Intent(MainPage.this, UsandoApi.class);
        startActivity(intent);
        finish();
    }

    private void abrirRecycler() {
        Intent intent = new Intent(MainPage.this, UsandoRecycler.class);
        startActivity(intent);
        finish();
    }

    private void abrirProfile() {
        Intent intent = new Intent(MainPage.this, FormProfile.class);
        startActivity(intent);
        finish();
    }
}