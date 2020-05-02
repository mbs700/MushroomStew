package com.example.mushroomstew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import static com.example.mushroomstew.Question6PActivity.EXTRA_GAD13;
import static com.example.mushroomstew.Question6PActivity.EXTRA_PHQ13;

public class Question7PActivity extends AppCompatActivity {
    public static final String EXTRA_GAD14 = EXTRA_GAD13;
    public static final String EXTRA_PHQ14 = EXTRA_PHQ13;

    private TextView sliderValue;
    private SeekBar seekBar;
    private TextView scoreWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7p);

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
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GAD14);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQ14);
        //previousSum.setText("" + sum);

        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ15Activity(GAD, PHQ);
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

    private void openQ15Activity(int[] GAD, int[] PHQ) {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());
        PHQ[6] = newVal;

        Intent intent = new Intent(this, Question8PActivity.class);
        intent.putExtra(EXTRA_GAD14, GAD);
        intent.putExtra(EXTRA_PHQ14, PHQ);

        startActivity(intent);
    }

    /*private void openQ1Activity() {
        int lastSum = Integer.parseInt(previousSum.getText().toString());

        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra(EXTRA_NUMBER2, lastSum);
        startActivity(intent);
    }*/
}
