package com.example.mushroomstew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.mushroomstew.Question6GActivity.EXTRA_GAD6;
import static com.example.mushroomstew.Question6GActivity.EXTRA_PHQ6;

public class Question7GActivity extends AppCompatActivity {
    public static final String EXTRA_GAD7 = EXTRA_GAD6;
    public static final String EXTRA_PHQ7 = EXTRA_PHQ6;

    private TextView sliderValue;
    private SeekBar seekBar;
    private TextView scoreWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7g);

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
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GAD7);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQ7);
        //previousSum.setText("" + sum);

        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ8Activity(GAD, PHQ);
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

    private void openQ8Activity(int[] GAD, int[] PHQ) {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());
        GAD[6] = newVal;

        Intent intent = new Intent(this, Question1PActivity.class);
        intent.putExtra(EXTRA_GAD7, GAD);
        intent.putExtra(EXTRA_PHQ7, PHQ);

        startActivity(intent);
    }

    /*private void openQ1Activity() {
        int lastSum = Integer.parseInt(previousSum.getText().toString());

        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra(EXTRA_NUMBER2, lastSum);
        startActivity(intent);
    }*/
}
