package com.example.simpleadapter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Experiment3Activity extends AppCompatActivity {

    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment3);

        Toolbar toolbar = findViewById(R.id.toolbar_exp3);
        setSupportActionBar(toolbar);

        testTextView = findViewById(R.id.test_textview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.experiment3_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.font_size_10) {
            testTextView.setTextSize(10);
        } else if (itemId == R.id.font_size_16) {
            testTextView.setTextSize(16);
        } else if (itemId == R.id.font_size_20) {
            testTextView.setTextSize(20);
        } else if (itemId == R.id.normal_menu_item) {
            Toast.makeText(this, "您点击了普通菜单项", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.font_color_red) {
            testTextView.setTextColor(Color.RED);
        } else if (itemId == R.id.font_color_black) {
            testTextView.setTextColor(Color.BLACK);
        } else {
            return super.onOptionsItemSelected(item);
        }
        item.setChecked(true);
        return true;
    }
}
