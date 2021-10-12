package com.cursoandroid.mobileappnovo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsandoRecycler extends AppCompatActivity {

    private Button btn_voltar3;

    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    PostsAdapter adapter;
    List<Posts> postsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        inicializaComponentes();
        eventoVoltar();

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostsAdapter(postsList);
        recyclerView.setAdapter(adapter);

        fetchPosts();
    }

    private void fetchPosts() {
        progressBar.setVisibility(View.VISIBLE);

        RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful() && Objects.nonNull(response.body())){
                    postsList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(UsandoRecycler.this, "Error"+t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
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
