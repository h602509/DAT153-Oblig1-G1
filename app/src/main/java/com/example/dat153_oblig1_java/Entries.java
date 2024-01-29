package com.example.dat153_oblig1_java;

import android.app.Application;
import android.util.Log;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Entries extends Application {

    private final List<QuizEntry> entries;

    public Entries() {

        // init the list with the three quiz entries included in the quiz app
        Log.i("Quiz", "Entries(), Entries added: {cat, dog, horse}");
        entries = new ArrayList<QuizEntry>();
        entries.add(new QuizEntry(R.drawable.cat, "cat", "dog", "tiger"));
        entries.add(new QuizEntry(R.drawable.dog, "dog", "snoop dog", "horse"));
        entries.add(new QuizEntry(R.drawable.cat, "horse", "donkey", "monkey"));
    }

    public QuizEntry getRandomEntry() {
        int ran = (int)(Math.random()*entries.size());
        return entries.get(ran);
    }
}
