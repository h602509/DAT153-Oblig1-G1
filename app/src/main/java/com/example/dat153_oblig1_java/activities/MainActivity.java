package com.example.dat153_oblig1_java.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.quiz_entries.Entries;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Entries entries = new Entries();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Quiz", "MainActivity.onCreate()");
        setContentView(R.layout.activity_main);

        // connect Button goToQuiz view to logic in code
        Button goToQuiz = findViewById(R.id.goToQuiz);
        goToQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Quiz", "MainActivity.goToQuiz.onClick()");

                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("entries", entries);

                startActivity(intent);
            }
        });

        // connect Button goToGallery view to logic in code
        Button goToGallery = findViewById(R.id.goToGallery);
        goToGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Quiz", "MainActivity.goToGallery.onClick()");

                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                intent.putExtra("entries", entries);
                startActivity(intent);
            }
        });

    }
}