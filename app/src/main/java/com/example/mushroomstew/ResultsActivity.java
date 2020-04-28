package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import static com.example.mushroomstew.Question3Activity.EXTRA_NUMBER3;
import static com.example.mushroomstew.Question9PActivity.EXTRA_GAD3;
import static com.example.mushroomstew.Question9PActivity.EXTRA_PHQ3;



public class ResultsActivity extends AppCompatActivity {
    public static final String EXTRA_GADR = EXTRA_GAD3;
    public static final String EXTRA_PHQR = EXTRA_PHQ3;

    private TextView scoreGAD;
    private TextView scorePHQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        scoreGAD = findViewById(R.id.finalSumGAD);
        scorePHQ = findViewById(R.id.finalSumPHQ);


        Intent intent = getIntent();
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GADR);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQR);
        int sumGAD = 0;
        int sumPHQ = 0;
        for (int num : GAD) {
            sumGAD += num;
        }
        for (int num : PHQ) {
            sumPHQ += num;
        }

        scoreGAD.setText("" + sumGAD);
        scorePHQ.setText("" + sumPHQ);

        Button mainScreen = findViewById(R.id.mainScreen);
        mainScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeMeHome();
            }
        });


    }

    private void takeMeHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
