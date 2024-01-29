package com.example.dat153_oblig1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Entries entries = new Entries();
        QuizEntry entry = entries.getRandomEntry();
        ImageView quizImage = findViewById(R.id.quiz_image_current);

        quizImage.setImageResource(entry.getImage());
    }
}