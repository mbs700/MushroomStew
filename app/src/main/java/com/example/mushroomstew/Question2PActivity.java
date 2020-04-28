package com.example.mushroomstew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.mushroomstew.Question1PActivity.EXTRA_GAD8;
import static com.example.mushroomstew.Question1PActivity.EXTRA_PHQ8;

public class Question2PActivity extends AppCompatActivity {
    public static final String EXTRA_GAD9 = EXTRA_GAD8;
    public static final String EXTRA_PHQ9 = EXTRA_PHQ8;

    private TextView sliderValue;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2p);

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
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GAD9);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQ9);
        //previousSum.setText("" + sum);

        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ10Activity(GAD, PHQ);
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

    private void openQ10Activity(int[] GAD, int[] PHQ) {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());

        PHQ[1] = newVal;

        Intent intent = new Intent(this, Question3PActivity.class);
        intent.putExtra(EXTRA_GAD9, GAD);
        intent.putExtra(EXTRA_PHQ9, PHQ);

        startActivity(intent);
    }

    /*private void openQ1Activity() {
        int lastSum = Integer.parseInt(previousSum.getText().toString());

        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra(EXTRA_NUMBER2, lastSum);
        startActivity(intent);
    }*/
}
