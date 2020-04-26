package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.mushroomstew.Question3Activity.EXTRA_NUMBER3;

public class ResultsActivity extends AppCompatActivity {


    private TextView finalSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        finalSum = findViewById(R.id.finalSum);


        Intent intent = getIntent();
        int sum = intent.getIntExtra(EXTRA_NUMBER3, -1);
        finalSum.setText("" + sum);


        Button mainScreen = findViewById(R.id.mainScreen);
        mainScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeMeHome();
            }
        });


    }

    private void takeMeHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
