package com.example.dat153_oblig1_java.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dat153_oblig1_java.Database.Entry;
import com.example.dat153_oblig1_java.Database.EntryRepo;
import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.quiz_entries.QuizActivityService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class QuizActivity extends AppCompatActivity {

    EntryRepo repo;
    QuizActivityService qs;
    RadioButton[] answerButtons;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Quiz", "QuizActivity.onCreate()");
        setContentView(R.layout.activity_quiz);

        // Set header Text from Res
        TextView header = findViewById(R.id.result_score_heading);

        repo = new EntryRepo(getApplication());

        repo.loadAllEntriesDsc().observe(this, x -> {
            qs = new QuizActivityService(repo.loadAllEntriesDsc().getValue());

            // Set header text with score
            header.setText(getString(R.string.quiz_heading
                    , String.valueOf(qs.getScore()), String.valueOf(qs.getCurrentRound())));

            // Set up radiobuttonViews
            answerButtons = new RadioButton[] {findViewById(R.id.quiz_button_answerA)
                    , findViewById(R.id.quiz_button_answerB)
                    , findViewById(R.id.quiz_button_answerC)};

            Drawable backGroundColor = answerButtons[0].getBackground();

                    // Setting up radio group buttons with text from quizEntry
            setupRadioButtons();

            for (int i = 0; i < answerButtons.length; i++) {
                int index = i;
                answerButtons[i].setOnCheckedChangeListener((buttonView, isChecked) -> {
                    Log.i("Quiz", "QuizActivity.answerButtons.OnChangeListener(), choice = button[" + index + "]");
                    if (isChecked) {
                        answer = (String) answerButtons[index].getText();
                        qs.setChosenAlternative(index);
                    }
                });
            }

            // set image from the entry
            ImageView quizImage = findViewById(R.id.quiz_image_current);
            quizImage.setImageResource(qs.getCurrentImgRef());

            // setting up submit button
            Button submitButton = findViewById(R.id.quiz_submit_button);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Quiz", "QuizActivity.submitButton.onClick()");

                    if (!answer.equals("")) {
                        // Submit answer logic
                        if (submitButton.getText().equals("Submit")) {
                            qs.addCurrentRoundCounter();
                            boolean correctAnswer = answer.equals(qs.getCurrentAnswer());

                            // colors correct answer green
                            for (int i = 0; i < 3; i++) {
                                if (answerButtons[i].getText().equals(qs.getCurrentAnswer())) {
                                    answerButtons[i].setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
                                }
                            }

                            if (correctAnswer) {
                                qs.addScore();
                            } else {
                                // colors answer given red if wrong
                                answerButtons[qs.getChosenAlternative()].setBackgroundColor(getResources().getColor(R.color.red, getTheme()));
                            }
                            header.setText(getString(R.string.quiz_heading
                                    , String.valueOf(qs.getScore()), String.valueOf(qs.getCurrentRound())));

                            // sets text in submit button to "Next"
                            submitButton.setText(getResources().getText(R.string.quiz_submit_button2));
                        }

                        // after submit are done, the logic for pressing next
                        else if (submitButton.getText().toString().equals("Next")) {

                            if (qs.isFinished()) {
                                startResultActivity(qs.getScore(), qs.getNumberOfRounds());

                            } else {
                                qs.goToNextQuestion();
                                quizImage.setImageResource(qs.getCurrentImgRef());
                                setupRadioButtons();
                                // reset color on all radio buttons
                                for (RadioButton r : answerButtons) {
                                    r.setBackground(backGroundColor);
                                    r.setChecked(false);
                                }

                                submitButton.setText(getResources().getText(R.string.quiz_submit_button1));
                            }

                        }


                    }
                }
            });
            Log.i("Quiz", "QuizActivity.onCreate(), correct: " + qs.getScore() + ", of total: " + qs.getCurrentRound());
        });

        // setting up quit button
        Button quitButton = findViewById(R.id.quiz_quit_button);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startResultActivity(qs.getScore(), qs.getNumberOfRounds());
            }
        });
    }

    @NonNull
    private void setupRadioButtons() {
        List<String> answers = qs.getAlternatives();
        answerButtons[0].setText(answers.get(0));
        answerButtons[1].setText(answers.get(1));
        answerButtons[2].setText(answers.get(2));
    }

    private void startResultActivity(int score, int questionCount) {
        Log.i("Quiz", "QuizActivity.startResultActivity()");
        Intent intent = new Intent(QuizActivity.this , ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("questionCount", questionCount);
        startActivity(intent);
        finish();
    }
}