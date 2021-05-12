package com.example.newreds;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Help2 extends AppCompatActivity {

    Button btnBack2;
    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2);

        btnBack2 = findViewById(R.id.btnBack2);
        link = findViewById(R.id.link);

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Help.class));
            }
        });

    }
}