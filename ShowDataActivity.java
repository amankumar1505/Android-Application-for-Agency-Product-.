package com.example.dayal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowDataActivity extends AppCompatActivity {
    TextView lUser,lPass;
    Button details , CHQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        lUser = findViewById(R.id.textViewUser);
        lPass= findViewById(R.id.textViewPass);
        details=findViewById(R.id.button);
        CHQ = findViewById(R.id.button7);

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( ShowDataActivity.this,SearchActivity.class));
            }
        });

        CHQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( ShowDataActivity.this,AddChqActivity.class));
            }
        });

        String username = getIntent().getStringExtra("keyuser");
        String password = getIntent().getStringExtra("keypass");

        lUser.setText(username);
        lPass.setText(password);

    }
}