package br.com.devairon.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import br.com.devairon.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    //apenas testando os exemplos da leitura da documentação
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);



    }
}