package com.example.dat153_oblig1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goToQuiz = findViewById(R.id.goToQuiz);
        goToQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("Quiz", "MainApplication.goToQuiz.onClick()");

                Intent intent = new Intent(MainActivity.this, Quiz.class);
                startActivity(intent);
            }
        });

        Button goToGallery = findViewById(R.id.goToGallery);

        goToGallery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("Quiz", "MainApplication.goToGallery.onClick()");

                Intent intent = new Intent(MainActivity.this, Gallery.class);
                startActivity(intent);
            }
        });

    }
}