package com.example.dat153_oblig1_java.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dat153_oblig1_java.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int score = 0;
        int questionCount = 0;

        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            score = extra.getInt("score");
            questionCount = extra.getInt("questionCount");
        }

        // setting up results textView
        TextView scoreBoard = findViewById(R.id.result_score_board);
        scoreBoard.setText(getString(R.string.result_score, String.valueOf(score), String.valueOf(questionCount)));

        // setting up return to main  button
        Button returnButton = findViewById(R.id.result_return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Ex1", "Activity2.ButtonB.onClick()");
                finish();
            }
        });
    }


}