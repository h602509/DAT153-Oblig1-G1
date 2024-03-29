package com.example.dat153_oblig1_java.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.quiz_entries.EntriesViewModel;
import com.example.dat153_oblig1_java.quiz_entries.EntryModel;

import java.util.List;

public class LiveTestActivity extends AppCompatActivity {

    private List<EntryModel> liveEntries;
    private EntriesViewModel entriesViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_test);

        //liveEntries = new EntriesViewModel();

        entriesViewModel = new ViewModelProvider(this).get(EntriesViewModel.class);

        final Observer<List<EntryModel>> favsObserver = new Observer<List<EntryModel>>() {
            @Override
            public void onChanged(List<EntryModel> updatedEntries) {
                if (liveEntries == null) {
                    liveEntries = updatedEntries;
                }
            }
        };

    }
}