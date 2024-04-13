package com.example.dat153_oblig1_java.quiz_entries;

import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.interfaces.EntriesInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EntriesRepoIntent implements EntriesInterface, Serializable{



    public EntriesRepoIntent() {}

    @Override
    public void deleteEntryModel(EntryModel entryModel) {
    }

    @Override
    public List<EntryModel> loadAllEntryModels() {
        List<EntryModel> entries = new ArrayList<>();

        entries.add(new EntryModel(R.drawable.cat, "cat"));
        entries.add(new EntryModel(R.drawable.dog, "dog"));
        entries.add(new EntryModel(R.drawable.horse, "horse"));

        return entries;
    }

    @Override
    public void addEntryModel(int imgRef, String answer) {}
}
