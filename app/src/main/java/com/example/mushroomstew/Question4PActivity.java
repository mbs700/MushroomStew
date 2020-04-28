package com.example.mushroomstew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.mushroomstew.Question3PActivity.EXTRA_GAD10;
import static com.example.mushroomstew.Question3PActivity.EXTRA_PHQ10;

public class Question4PActivity extends AppCompatActivity {
    public static final String EXTRA_GAD11 = EXTRA_GAD10;
    public static final String EXTRA_PHQ11 = EXTRA_PHQ10;

    private TextView sliderValue;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4p);

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
                openQ12Activity(GAD, PHQ);
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

    private void openQ12Activity(int[] GAD, int[] PHQ) {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());

        PHQ[3] = newVal;

        Intent intent = new Intent(this, Question5PActivity.class);
        intent.putExtra(EXTRA_GAD11, GAD);
        intent.putExtra(EXTRA_PHQ11, PHQ);

        startActivity(intent);
    }

    /*private void openQ1Activity() {
        int lastSum = Integer.parseInt(previousSum.getText().toString());

        Intent intent = new Intent(this, Question3Activity.class);
        intent.putExtra(EXTRA_NUMBER2, lastSum);
        startActivity(intent);
    }*/
}
