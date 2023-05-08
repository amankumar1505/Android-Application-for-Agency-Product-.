package com.example.dayal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login1Activity extends AppCompatActivity {
    EditText lPass, lUser;
    Button lButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        lUser = findViewById(R.id.loginUser);
        lPass = findViewById(R.id.loginPass);
        lButton = findViewById(R.id.loginButton);

        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = lUser.getText().toString();
                String password = lPass.getText().toString();

                Intent intent = new Intent(Login1Activity.this,ShowDataActivity.class);
                intent.putExtra("keyuser",username);
                intent.putExtra("keypass",password);
                startActivity(intent);


            }
        });
    }
}