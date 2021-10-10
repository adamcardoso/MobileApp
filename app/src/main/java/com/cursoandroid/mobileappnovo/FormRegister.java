package com.cursoandroid.mobileappnovo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FormRegister extends AppCompatActivity {
    private EditText edit_text_telefone;
    private EditText edit_add_user;
    private EditText edit_add_email;
    private EditText edit_add_name;
    private EditText edit_add_password;
    private Button btn_sign_up_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);


        edit_add_user = findViewById(R.id.edit_add_user);
        edit_add_email = findViewById(R.id.edit_add_email);
        edit_add_name = findViewById(R.id.edit_add_name);
        edit_add_password = findViewById(R.id.edit_add_password);
        edit_text_telefone = findViewById(R.id.edit_text_telefone);
        btn_sign_up_2 = findViewById(R.id.btn_sign_up_2);

        btn_sign_up_2.setOnClickListener(view -> {
            Intent intent = new Intent(FormRegister.this, FormLogin.class);
            startActivity(intent);
            finish();
        });
    }
}