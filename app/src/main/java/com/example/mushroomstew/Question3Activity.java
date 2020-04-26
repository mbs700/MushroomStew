package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.example.mushroomstew.Question2Activity.EXTRA_NUMBER2;

public class Question3Activity extends AppCompatActivity {
    public static final String EXTRA_NUMBER3  = "com.example.application.mushroomstew.EXTRA_NUMBER3";

    private TextView previousSum;
    private SeekBar seekBar;
    private TextView sliderValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);


        previousSum = findViewById(R.id.previousSum);
        seekBar = findViewById(R.id.seekBar);
        sliderValue = findViewById(R.id.sliderValue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sliderValue.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        Intent intent = getIntent();
        int sum = intent.getIntExtra(EXTRA_NUMBER2, -1);
        previousSum.setText("" + sum);



        Button resultsButton;
        resultsButton = findViewById(R.id.resultsButton);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultsActivity();
            }
        });
    }

    private void openResultsActivity() {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());
        int lastSum = Integer.parseInt(previousSum.getText().toString());
        int newSum = newVal + lastSum;

        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra(EXTRA_NUMBER3, newSum);
        startActivity(intent);
    }
}
