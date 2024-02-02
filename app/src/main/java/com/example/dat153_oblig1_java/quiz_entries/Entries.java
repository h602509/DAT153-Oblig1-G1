package com.example.dat153_oblig1_java.quiz_entries;

import android.app.Application;
import android.util.Log;

import com.example.dat153_oblig1_java.R;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Entries implements Serializable {

    private final List<QuizEntry> entries;
    public Entries() {

        // init the list with the three quiz entries included in the quiz app
        Log.i("Quiz", "Entries(), Entries added: {cat, dog, horse}");
        entries = new ArrayList<QuizEntry>();
        entries.add(new QuizEntry(R.drawable.cat, "cat", "dog", "tiger"));
        entries.add(new QuizEntry(R.drawable.dog, "dog", "snoop dog", "horse"));
        entries.add(new QuizEntry(R.drawable.horse, "horse", "donkey", "monkey"));
    }

    public QuizEntry getRandomEntry() {
        int ran = (int) (Math.random() * entries.size());
        return entries.get(ran);
    }

    public Queue<QuizEntry> getShuffledEntryQueue() {
        Queue<QuizEntry> queue = new ArrayDeque<>();
        Collections.shuffle(entries);
        queue.addAll(entries);
        return queue;
    }
}
