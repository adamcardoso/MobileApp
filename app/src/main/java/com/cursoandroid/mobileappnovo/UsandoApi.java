package com.cursoandroid.mobileappnovo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UsandoApi extends AppCompatActivity {

    private Button btn_voltar2;
    private Button mostrarAPI;
    private TextView textView, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        btn_voltar2 = findViewById(R.id.btn_voltar2);
        mostrarAPI = findViewById(R.id.mostrarAPI);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        mostrarAPI.setOnClickListener(v -> {
            Tarefa tarefa = new Tarefa();
            tarefa.execute("https://jsonplaceholder.typicode.com/albums/1");

            Tarefa1 tarefa1 = new Tarefa1();
            tarefa1.execute("https://jsonplaceholder.typicode.com/albums/2");

            Tarefa2 tarefa2 = new Tarefa2();
            tarefa2.execute("https://jsonplaceholder.typicode.com/albums/3");
        });

        eventoVoltar();
    }

    private void eventoVoltar() {
        btn_voltar2.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainPage.class);
            startActivity(intent);
            finish();
        });
    }

    private class Tarefa extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = DTO.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
        }
    }

    private class Tarefa1 extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... strings) {
            String retorno = DTO.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            textView2.setText(s);
        }
    }

    private class Tarefa2 extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... strings) {
            String retorno = DTO.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            textView3.setText(s);
        }
    }
}
