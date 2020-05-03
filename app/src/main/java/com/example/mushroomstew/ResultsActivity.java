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
    private TextView GADresult;
    private TextView scorePHQ;
    private TextView PHQresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        scoreGAD = findViewById(R.id.finalSumGAD);
        scorePHQ = findViewById(R.id.finalSumPHQ);
        GADresult = findViewById(R.id.GADresult);
        PHQresult = findViewById(R.id.PHQresult);


        Intent intent = getIntent();
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GADR);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQR);
        int sumGAD = 0;
        int sumPHQ = 0;
        for (int num : GAD) {
            sumGAD += num;
        }

        if (sumGAD < 5) {
            GADresult.setText("No anxiety disorder.");
        } else if (sumGAD < 9) {
            GADresult.setText("Mild anxiety disorder.");
        } else if (sumGAD < 14) {
            GADresult.setText("Moderate anxiety disorder.");
        } else {
            GADresult.setText("Severe anxiety disorder");
        }

        if (sumPHQ < 5) {
            PHQresult.setText("Depression severity: minimal or none.");
        } else if (sumPHQ < 10) {
            PHQresult.setText("Depression severity: mild.");
        } else if (sumPHQ < 15) {
            PHQresult.setText("Depression severity: moderate.");
        } else if (sumPHQ < 20) {
            PHQresult.setText("Depression severity: moderately severe.");
        }else {
            PHQresult.setText("Depression severity: severe.");
        }

        for (int num : PHQ) {
            sumPHQ += num;
        }


        scoreGAD.setText("The patient scored " + sumGAD + " out of 21, indicating:");
        scorePHQ.setText("The patient scored " + sumPHQ + " out of 27, indicating:");

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
