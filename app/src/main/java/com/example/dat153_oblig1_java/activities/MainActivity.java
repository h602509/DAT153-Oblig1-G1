package com.example.dat153_oblig1_java.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dat153_oblig1_java.R;

public class MainActivity extends AppCompatActivity {

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
                startActivity(intent);
            }
        });

    }
}