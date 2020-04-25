package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
//import android.widget.TextView;

public class Question2Activity extends AppCompatActivity {

    //private TextView previousSum = findViewById(R.id.previousSum);

    private TextView sliderValue = findViewById(R.id.sliderValue);
    private SeekBar seekBar = findViewById(R.id.seekBar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sliderValue.setText(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Intent intent = getIntent();
        //int sum = intent.getIntExtra(Question1Activity.EXTRA_NUMBER, 0);
        //previousSum.setText(sum);

        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ3Activity();
            }
        });
    }

    private void openQ3Activity() {
        Intent intent = new Intent(this, Question3Activity.class);
        startActivity(intent);
    }
}
