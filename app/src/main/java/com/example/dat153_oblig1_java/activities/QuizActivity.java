package com.example.dat153_oblig1_java.activities;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.dat153_oblig1_java.quiz_entries.Entries;
import com.example.dat153_oblig1_java.quiz_entries.QuizEntry;
import com.example.dat153_oblig1_java.R;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class QuizActivity extends AppCompatActivity {

    Entries entries = new Entries();
    QuizEntry entry;
    String answer;
    int counterQuiz = 0;
    int counterCorrect = 0;
    int choosenButton = -1;
    Boolean quit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        entry = entries.getRandomEntry();

        // get saved counter values
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            counterQuiz = extras.getInt("quizNo");
            counterCorrect = extras.getInt("correctNo");
        }

        Log.i("Quiz", "QuizActivity.onCreate(), correct: " + counterCorrect + ", of total: " + counterQuiz);

        // set image from the entry
        ImageView quizImage = findViewById(R.id.quiz_image_current);

        quizImage.setImageResource(entry.getImage());

        // Shuffle the answers
        List<String> answers = new ArrayList<>();
        answers.add(0,entry.getAnswer());
        answers.add(1, entry.getWrong1());
        answers.add(2, entry.getWrong2());
        Collections.shuffle(answers);

        // Setting up radio group buttons with text from quizEntry
        RadioButton[] answerButtons =
                {findViewById(R.id.quiz_button_answerA)
                        , findViewById(R.id.quiz_button_answerB)
                        , findViewById(R.id.quiz_button_answerC)};

        answerButtons[0].setText(answers.get(0));
        answerButtons[0].setOnCheckedChangeListener((buttonView, isChecked) -> {
            answer = (String) answerButtons[0].getText();
            choosenButton = 0;
        });

        answerButtons[1].setText(answers.get(1));
        answerButtons[1].setOnCheckedChangeListener((buttonView, isChecked) -> {
            answer = (String) answerButtons[1].getText();
            choosenButton = 1;
        });

        answerButtons[2].setText(answers.get(2));
        answerButtons[2].setOnCheckedChangeListener((buttonView, isChecked) -> {
            answer = (String) answerButtons[2].getText();
            choosenButton = 2;
        });

        Button submitButton = findViewById(R.id.quiz_submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterQuiz++;
                if (answer.equals(entry.getAnswer())) {
                    answerButtons[choosenButton].setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
                    answerButtons[choosenButton].setBackgroundColor(getResources().getColor(R.color.dark_green, getTheme()));
                    submitButton.setText(getResources().getText(R.string.quiz_submit_button2));
                    counterCorrect++;
                } else {
                    answerButtons[choosenButton].setBackgroundColor(getResources().getColor(R.color.red, getTheme()));
                    answerButtons[choosenButton].setBackgroundColor(getResources().getColor(R.color.dark_red, getTheme()));
                    for (int i = 0; i < 3; i++) {
                        if (answerButtons[i].getText().equals(entry.getAnswer())) {
                            answerButtons[i].setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
                            answerButtons[i].setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
                        }
                    }
                }

                Log.i("Quiz", "QuizActivity.ButtonGoToActivity2 onClick(), correct: " + counterCorrect + ", of total: " + counterQuiz);

            /*
            Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
            intent.putExtra("quizNo", counterQuiz);
            intent.putExtra("correctNo", counterCorrect);
            startActivity(intent);
            */
            }
        });
        Button quitButton = findViewById(R.id.quiz_quit_button);

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Ex1", "Activity2.ButtonB.onClick()");
                Intent intent = new Intent(QuizActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

}