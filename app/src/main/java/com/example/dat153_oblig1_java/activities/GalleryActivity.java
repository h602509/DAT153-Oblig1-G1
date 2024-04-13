package com.example.dat153_oblig1_java.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.adaptor.GalleryItemAdaptor;
import com.example.dat153_oblig1_java.quiz_entries.Entries;
import com.example.dat153_oblig1_java.quiz_entries.EntryModel;

public class GalleryActivity extends AppCompatActivity {

    private Entries entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Log.i("Quiz", "GalleryActivity.onCreate()");

        Bundle extras = getIntent().getExtras();

        // getting entries from Bundle coming from mainActivity
        if (extras != null) {
            entries = (Entries) extras.getSerializable("entries");
        }


        // setting upp gallery view
        RecyclerView recyclerView = findViewById(R.id.gallery_recycle_view);
        GalleryItemAdaptor adaptor = new GalleryItemAdaptor(this, entries);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // setting upp add entry button
        Button goToAddEntry = findViewById(R.id.gallery_add_button);
        goToAddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Quiz", "GalleryActivity.goToAddEntry.onClick()");
                Intent intent = new Intent(GalleryActivity.this, AddQuizEntryActivity.class);
                startActivity(intent);
            }
        });

        // setting upp add entry button
        Button gallerySortButton = findViewById(R.id.gallery_sort_button);
        gallerySortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gallerySortButton.getText().equals("A-Z")) {
                    entries.sortEntriesAsc();
                    gallerySortButton.setText(R.string.gallery_sort_button_desc);
                    Log.i("Quiz", "GalleryActivity.onClick(), sortEntriesAsc(), button.getText() = A-Z -> " + gallerySortButton.getText());
                } else if (gallerySortButton.getText().equals("Z-A")) {
                    entries.sortEntriesDesc();
                    gallerySortButton.setText(R.string.gallery_sort_button_asc);
                    Log.i("Quiz", "GalleryActivity.onClick(), sortEntriesDesc(), button.getText() = Z-A -> " + gallerySortButton.getText());
                }
                adaptor.notifyDataSetChanged();
            }
        });
    }
}