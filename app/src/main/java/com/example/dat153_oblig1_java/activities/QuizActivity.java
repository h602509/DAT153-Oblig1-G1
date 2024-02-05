package com.example.dat153_oblig1_java.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dat153_oblig1_java.quiz_entries.Entries;
import com.example.dat153_oblig1_java.quiz_entries.QuizEntry;
import com.example.dat153_oblig1_java.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    Entries entries;
    QuizEntry entry;
    String answer;
    int counterQuiz = 0;
    int counterCorrect = 0;
    int choosenButton = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // get saved counter values
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Log.i("Quiz", "QuizActivity.onCreate(), Bundle != null");
            counterQuiz = extras.getInt("quizNo");
            counterCorrect = extras.getInt("correctNo");
            entries = (Entries) extras.getSerializable("entries");
        } else {
            Log.i("Quiz", "QuizActivity.onCreate(), Bundle == null");
            entries = new Entries();
        }

        if (entries.getEntries().size() == 0) {
            Log.i("Ex1", "Activity2.ButtonB.onClick()");
            Intent intent = new Intent(QuizActivity.this , ResultActivity.class);
            intent.putExtra("counterCorrect", counterCorrect);
            intent.putExtra("counterQuiz", counterQuiz);
            startActivity(intent);
            finish();
        } else {
            entry = entries.popRandomEntry();
        }
        Log.i("Quiz", "QuizActivity.onCreate(), correct: " + counterCorrect + ", of total: " + counterQuiz);

        // Set header Text from Res
        TextView header = findViewById(R.id.result_score_heading);
        header.setText(getString(R.string.quiz_heading, String.valueOf(counterCorrect), String.valueOf(counterQuiz)));

        // set image from the entry
        ImageView quizImage = findViewById(R.id.quiz_image_current);
        quizImage.setImageResource(entry.getImage());

        // Shuffle the answers
        List<String> answers = new ArrayList<>();
        answers.add(0,entry.getAnswer());
        List<String> wrongs = entries.getWrongs(entry);
        answers.add(wrongs.get(0));
        answers.add(wrongs.get(1));
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

        // setting up submitbutton
        Button submitButton = findViewById(R.id.quiz_submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answer != null) {
                    // Submit answer logic
                    if (submitButton.getText().equals("Submit")) {
                        counterQuiz++;
                        boolean correctAnswer = answer.equals(entry.getAnswer());

                        // colors correct answer green
                        for (int i = 0; i < 3; i++) {
                            if (answerButtons[i].getText().equals(entry.getAnswer())) {
                                answerButtons[i].setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
                            }
                        }

                        if (correctAnswer) {
                            counterCorrect++;
                        } else {
                            // colors answer given red
                            answerButtons[choosenButton].setBackgroundColor(getResources().getColor(R.color.red, getTheme()));
                        }
                        header.setText(getString(R.string.quiz_heading, String.valueOf(counterCorrect), String.valueOf(counterQuiz)));
                    }

                    // after submit are done, the logic for pressing next
                    if (submitButton.getText().toString().equals("Next")) {
                        Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                        intent.putExtra("quizNo", counterQuiz);
                        intent.putExtra("correctNo", counterCorrect);
                        intent.putExtra("entries", entries);
                        startActivity(intent);
                    }

                    // sets text in submit button to "Next"
                    submitButton.setText(getResources().getText(R.string.quiz_submit_button2));

                }
            }
        });

        // setting up quit button
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