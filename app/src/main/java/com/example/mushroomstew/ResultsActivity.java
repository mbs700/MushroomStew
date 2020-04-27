package com.example.mushroomstew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import static com.example.mushroomstew.Question3Activity.EXTRA_NUMBER3;
import static com.example.mushroomstew.Question3Activity.EXTRA_GAD3;
import static com.example.mushroomstew.Question3Activity.EXTRA_PHQ3;



public class ResultsActivity extends AppCompatActivity {
    public static final String EXTRA_GADR = EXTRA_GAD3;
    public static final String EXTRA_PHQR = EXTRA_PHQ3;

    private TextView finalSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        finalSum = findViewById(R.id.finalSum);


        Intent intent = getIntent();
        //int sum = intent.getIntExtra(EXTRA_NUMBER3, -1);
        final int[] GAD = intent.getIntArrayExtra(EXTRA_GADR);
        final int[] PHQ = intent.getIntArrayExtra(EXTRA_PHQR);
        int sum = 0;
        for (int num : GAD) {
            sum += num;
        }

        finalSum.setText("" + sum);


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
