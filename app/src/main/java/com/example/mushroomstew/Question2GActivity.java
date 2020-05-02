package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.example.mushroomstew.Question1GActivity.EXTRA_GAD;
import static com.example.mushroomstew.Question1GActivity.EXTRA_PHQ;

public class Question2GActivity extends AppCompatActivity {
    public static final String EXTRA_GAD2 = EXTRA_GAD;
    public static final String EXTRA_PHQ2 = EXTRA_PHQ;

    private TextView sliderValue;
    private TextView scoreWords;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2g);

        sliderValue = findViewById(R.id.sliderValue);
        seekBar = findViewById(R.id.seekBar);
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


        Intent intent = getIntent();
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GAD2);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQ2);

        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ3Activity(GAD, PHQ);
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

    private void openQ3Activity(int[] GAD, int[] PHQ) {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());
        GAD[1] = newVal;

        Intent intent = new Intent(this, Question3GActivity.class);
        intent.putExtra(EXTRA_GAD, GAD);
        intent.putExtra(EXTRA_PHQ, PHQ);

        startActivity(intent);
    }

    /*private void openQ1Activity() {
        int lastSum = Integer.parseInt(previousSum.getText().toString());

        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra(EXTRA_NUMBER2, lastSum);
        startActivity(intent);
    }*/
}
