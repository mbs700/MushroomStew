package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.example.mushroomstew.Question2Activity.EXTRA_GAD2;
import static com.example.mushroomstew.Question2Activity.EXTRA_PHQ2;

public class Question3Activity extends AppCompatActivity {
    public static final String EXTRA_GAD3 = EXTRA_GAD2;
    public static final String EXTRA_PHQ3 = EXTRA_PHQ2;

    private SeekBar seekBar;
    private TextView sliderValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);


        seekBar = findViewById(R.id.seekBar);
        sliderValue = findViewById(R.id.sliderValue);

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
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GAD3);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQ3);



        Button resultsButton;
        resultsButton = findViewById(R.id.resultsButton);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultsActivity(GAD, PHQ);
            }
        });
    }

    private void openResultsActivity(int[] GAD, int[] PHQ) {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());

        GAD[2] = newVal;
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra(EXTRA_GAD3, GAD);
        intent.putExtra(EXTRA_PHQ3, PHQ);
        startActivity(intent);
    }
}
