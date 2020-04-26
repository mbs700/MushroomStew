package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.example.mushroomstew.Question1Activity.EXTRA_NUMBER;
//import android.widget.TextView;

public class Question2Activity extends AppCompatActivity {
    public static final String EXTRA_NUMBER2  = "com.example.application.mushroomstew.EXTRA_NUMBER2";

    private TextView previousSum;
    private TextView sliderValue;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        previousSum = findViewById(R.id.previousSum);
        sliderValue = findViewById(R.id.sliderValue);
        seekBar = findViewById(R.id.seekBar);

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
        int sum = intent.getIntExtra(EXTRA_NUMBER, 0);
        previousSum.setText("" + sum);

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
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());
        int lastSum = Integer.parseInt(previousSum.getText().toString());
        int newSum = newVal + lastSum;

        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra(EXTRA_NUMBER2, newSum);
        startActivity(intent);
    }
}
