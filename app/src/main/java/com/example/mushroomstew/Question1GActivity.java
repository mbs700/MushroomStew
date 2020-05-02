package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class Question1GActivity extends AppCompatActivity {
    public static final String EXTRA_GAD = "com.example.application.mushroomstew.EXTRA_GAD";
    public static final String EXTRA_PHQ = "com.example.application.mushroomstew.EXTRA_PHQ";

    private TextView sliderValue;
    private TextView scoreWords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1g);


        SeekBar seekBar = findViewById(R.id.seekBar);
        sliderValue = findViewById(R.id.sliderValue);
        scoreWords = findViewById(R.id.wordScore);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    scoreWords.setText("Not at all.");
                } else if (progress == 1) {
                   scoreWords.setText("Several days.");
                } else if (progress == 2) {
                    scoreWords.setText("More than half the days.");
                } else if (progress == 3) {
                    scoreWords.setText("Nearly every day.");
                }
                sliderValue.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ2Activity();
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeMeHome();
            }
        });
    }

    private void openQ2Activity() {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());

        int[] GAD = new int[7];
        int[] PHQ = new int[9];
        GAD[0] = newVal;

        Intent intent = new Intent(this, Question2GActivity.class);
        intent.putExtra(EXTRA_GAD, GAD);
        intent.putExtra(EXTRA_PHQ, PHQ);

        startActivity(intent);
    }

    private void takeMeHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
