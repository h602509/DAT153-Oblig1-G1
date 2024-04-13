package com.example.dat153_oblig1_java.quiz_entries;


import android.util.Log;

import com.example.dat153_oblig1_java.R;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


public class Entries implements Serializable {

    private final List<EntryModel> entries;
    private final List<String> answers;
    public Entries(List<EntryModel> entries) {

        // init the list with the three quiz entries included in the quiz app
        Log.i("Quiz", "Entries(), Entries added: {cat, dog, horse}");
        this.entries = entries;
        answers = new ArrayList<>();
        for (EntryModel e : entries) {
            answers.add(e.getAnswer());
        }
    }

    public EntryModel getRandomEntry() {
        int ran = (int) (Math.random() * entries.size());
        return entries.get(ran);
    }

    public void generateAnswers() {
        for (EntryModel q : entries) {
            answers.add(q.getAnswer());
        }
    }

    public EntryModel popRandomEntry() {
        int ran = (int) (Math.random() * entries.size());
        EntryModel q = entries.get(ran);
        entries.remove(ran);
        return q;
    }

    public void addQuizEntry(int imgRef, String answer) {
        entries.add(new EntryModel(imgRef, answer));
    }

    public List<String> getWrongs(EntryModel quizEntry) {
        generateAnswers();
        List<String> wrongs = answers;
        int i = 0;
        while (wrongs.size() < 2) {
            EntryModel q = getRandomEntry();
            if (!(q.equals(quizEntry) || wrongs.contains(q.getAnswer()))) {
                wrongs.add(i, q.getAnswer());
                i++;
            }
        }
        return wrongs;
    }

    public List<EntryModel> getEntries() {
        return entries;
    }

    public void sortEntriesDesc() {
        Collections.sort(entries);
    }

    public void sortEntriesAsc() {
        sortEntriesDesc();
        Collections.reverse(entries);
    }

}
