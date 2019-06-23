package com.ching.frankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private EditText password;
    private EditText carnetNumber;

    private String userCarnet = "20191120093";
    private String userPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initialize();
        connectButton();
    }

    private void connectButton() {

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carnetNumber.getText().toString().equals(userCarnet)){
                    if(password.getText().toString().equals(userPassword)){
                        Context context = v.getContext();
                        SharedPreferences preferences = context.getSharedPreferences(getString(R.string.preference_key),Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("firstName","Abrahin");
                        editor.putString("carnet",carnetNumber.getText().toString());
                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),"Clave equivocada",Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Usuario no encontrado",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void initialize() {

        password = findViewById(R.id.passwordEditText);
        carnetNumber = findViewById(R.id.carnetEditText);

    }


}
