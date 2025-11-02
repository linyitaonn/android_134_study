package com.example.simpleadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button exp1Button = findViewById(R.id.exp1_button);
        Button exp2Button = findViewById(R.id.exp2_button);
        Button exp3Button = findViewById(R.id.exp3_button);
        Button exp4Button = findViewById(R.id.exp4_button);

        exp1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        exp2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        exp3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Experiment3Activity.class);
                startActivity(intent);
            }
        });

        exp4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Experiment4Activity.class);
                startActivity(intent);
            }
        });
    }
}
