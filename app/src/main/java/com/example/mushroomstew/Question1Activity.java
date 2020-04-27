package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class Question1Activity extends AppCompatActivity {
    public static final String EXTRA_GAD = "com.example.application.mushroomstew.EXTRA_GAD";
    public static final String EXTRA_PHQ = "com.example.application.mushroomstew.EXTRA_PHQ";

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
                // ik it doesn't like what i did with the quotes. I can tell you that the solution
                // is NOT just to delete them. Then the app crashes every time to seek bar is moved
                // sliderValue.setText(String.format("%02d", progress)); also works but isn't liked
                sliderValue.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        Button continueButton;
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ2Activity();
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeMeHome();
            }
        });
    }

    private void openQ2Activity() {
        TextView currentValue = findViewById(R.id.sliderValue);
        int newVal = Integer.parseInt(currentValue.getText().toString());

        int[] GAD = new int[7];
        int[] PHQ = new int[9];
        GAD[0] = newVal;

        Intent intent = new Intent(this, Question2Activity.class);
        intent.putExtra(EXTRA_GAD, GAD);
        intent.putExtra(EXTRA_PHQ, PHQ);

        startActivity(intent);
    }

    private void takeMeHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
