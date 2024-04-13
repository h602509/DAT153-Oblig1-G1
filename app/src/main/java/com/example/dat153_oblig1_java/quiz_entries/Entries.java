package com.example.dat153_oblig1_java.quiz_entries;


import android.util.Log;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


public class Entries implements Serializable {

    private final List<EntryModel> entries;
    private final MockEntriesRepo repo;
    public Entries(MockEntriesRepo repo) {
        this.repo = repo;

        // init the list with the three quiz entries included in the quiz app
        Log.i("Quiz", "Entries(), Entries added: {cat, dog, horse}");
        entries = repo.loadAllEntryModels();


    }

    public EntryModel getRandomEntry() {
        int ran = (int) (Math.random() * entries.size());
        return entries.get(ran);
    }

    public List<String> generateAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("sheep");
        answers.add("wolf");
        answers.add("deer");
        for (EntryModel q : entries) {
            answers.add(q.getAnswer());
        }
        return answers;
    }

    public EntryModel popRandomEntry() {
        int ran = (int) (Math.random() * entries.size());
        EntryModel q = entries.get(ran);
        entries.remove(ran);
        return q;
    }

    public List<String> getWrongs(EntryModel quizEntry) {
        List<String> wrongs = generateAnswers();
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
