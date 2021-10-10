package com.cursoandroid.mobileappnovo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class FormProfile extends AppCompatActivity {

    private TextView textId;
    private TextView textEmailAddress;
    private Button btn_profile_logout;

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        inicializaComponentes();
        eventoBotaoLogout();
    }

    private void eventoBotaoLogout() {
        btn_profile_logout.setOnClickListener(view -> {
            Conexao.logout();
            finish();
        });
    }

    private void inicializaComponentes() {
        textEmailAddress = findViewById(R.id.textEmailAddress);
        textId = findViewById(R.id.textId);
        btn_profile_logout = findViewById(R.id.btn_profile_logout);
    }

    @Override
    protected void onStart() {
        super.onStart();

        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();

        verificaUser();
    }

    private void verificaUser() {
        if (user == null){
            finish();
        }else {
            textEmailAddress.setText("Email: "+user.getEmail());
            textId.setText("ID: "+user.getUid());
        }
    }
}
