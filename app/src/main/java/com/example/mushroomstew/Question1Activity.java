package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Question1Activity extends AppCompatActivity {
    //public static final String EXTRA_NUMBER = "com.example.application.mushroomstew.EXTRA_NUMBER";


    private TextView sliderValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        SeekBar seekBar = findViewById(R.id.seekBar);
        sliderValue = findViewById(R.id.sliderValue);
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



        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ2Activity();
            }
        });
    }

    private void openQ2Activity() {
        //TextView previousSum = findViewById(R.id.textView);
       // int sum = Integer.parseInt(previousSum.getText().toString());

        Intent intent = new Intent(this, Question2Activity.class);
        //intent.putExtra(EXTRA_NUMBER, sum);
        startActivity(intent);
    }
}
