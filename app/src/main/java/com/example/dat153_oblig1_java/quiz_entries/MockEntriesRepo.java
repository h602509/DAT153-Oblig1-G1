package com.example.dat153_oblig1_java.quiz_entries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dat153_oblig1_java.Database.Entry;
import com.example.dat153_oblig1_java.R;
import com.example.dat153_oblig1_java.interfaces.EntriesRepo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MockEntriesRepo implements EntriesRepo {



    public MockEntriesRepo() {}

    @Override
    public void deleteEntry(Entry entry) {
    }

    @Override
    public LiveData<List<Entry>> loadAllEntriesAsc() {
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(R.drawable.horse, "horse"));
        entries.add(new Entry(R.drawable.dog, "dog"));
        entries.add(new Entry(R.drawable.cat, "cat"));

        return new MutableLiveData<>(entries);
    }

    @Override
    public LiveData<List<Entry>> loadAllEntriesDsc() {
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(R.drawable.cat, "cat"));
        entries.add(new Entry(R.drawable.dog, "dog"));
        entries.add(new Entry(R.drawable.horse, "horse"));

        return new MutableLiveData<>(entries);
    }

    @Override
    public void addEntry(int imgRef, String answer) {}
}
