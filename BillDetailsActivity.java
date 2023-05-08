package com.example.dayal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BillDetailsActivity extends AppCompatActivity {
    Button take;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_details);

        take = findViewById(R.id.button4);

        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BillDetailsActivity.this,PaymentsActivity.class));
            }
        });
    }
}