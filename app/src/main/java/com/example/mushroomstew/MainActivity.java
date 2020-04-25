package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // oh boy, here i go coding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button initialStart;
        initialStart = findViewById(R.id.initialStart);
        initialStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ1Activity();
            }
        });

    }

    /**
     * ight,so
     * this funk, surprisingly, opens Question1Activity
     */
    public void openQ1Activity() {
        Intent intent = new Intent(this, Question1Activity.class);
        startActivity(intent);
    }
}
