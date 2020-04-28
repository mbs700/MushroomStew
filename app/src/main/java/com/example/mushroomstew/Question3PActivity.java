package com.example.mushroomstew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.mushroomstew.Question2PActivity.EXTRA_GAD9;
import static com.example.mushroomstew.Question2PActivity.EXTRA_PHQ9;

public class Question3PActivity extends AppCompatActivity {
    public static final String EXTRA_GAD10 = EXTRA_GAD9;
    public static final String EXTRA_PHQ10 = EXTRA_PHQ9;

    private TextView sliderValue;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3p);

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
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GAD10);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQ10);
        //previousSum.setText("" + sum);

        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ11Activity(GAD, PHQ);
            }
        });

        /*Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ1Activity();
            }
        });*/
    }

    private void openQ11Activity(int[] GAD, int[] PHQ) {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());

        PHQ[2] = newVal;

        Intent intent = new Intent(this, Question4PActivity.class);
        intent.putExtra(EXTRA_GAD10, GAD);
        intent.putExtra(EXTRA_PHQ10, PHQ);

        startActivity(intent);
    }

    /*private void openQ1Activity() {
        int lastSum = Integer.parseInt(previousSum.getText().toString());

        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra(EXTRA_NUMBER2, lastSum);
        startActivity(intent);
    }*/
}
