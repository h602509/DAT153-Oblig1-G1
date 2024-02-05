package com.example.dat153_oblig1_java.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.quiz_entries.Entries;

public class GalleryActivity extends AppCompatActivity {

    private Entries entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Bundle extras = getIntent().getExtras();

        // getting entries from Bundle coming from mainActivity
        if (extras != null) {
            entries = (Entries) extras.getSerializable("entries");
        }

        // setting upp gallery view



        // setting upp add entry button
        Button goToAddEntry = findViewById(R.id.gallery_add_button);
        goToAddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryActivity.this, AddQuizEntryActivity.class);
                startActivity(intent);
            }
        });
    }
}