package com.example.dat153_oblig1_java.quiz_entries;


import android.util.Log;

import com.example.dat153_oblig1_java.R;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.List;


public class Entries implements Serializable {

    private final List<QuizEntry> entries;

    public Entries() {

        // init the list with the three quiz entries included in the quiz app
        Log.i("Quiz", "Entries(), Entries added: {cat, dog, horse}");
        entries = new ArrayList<>();
        entries.add(new QuizEntry(R.drawable.cat, "cat", "dog", "tiger"));
        entries.add(new QuizEntry(R.drawable.dog, "dog", "snoop dog", "horse"));
        entries.add(new QuizEntry(R.drawable.horse, "horse", "donkey", "monkey"));
    }

    public QuizEntry getRandomEntry() {
        int ran = (int) (Math.random() * entries.size());
        return entries.get(ran);
    }


    public QuizEntry popRandomEntry() {
        int ran = (int) (Math.random() * entries.size());
        QuizEntry q = entries.get(ran);
        entries.remove(ran);
        return q;
    }

    public void addQuizEntry(int imgRef, String answer) {
        entries.add(new QuizEntry(imgRef, answer));
    }

    public List<String> getWrongs(QuizEntry quizEntry) {
        List<String> wrongs = new ArrayList<>(2);
        int i = 0;
        while (wrongs.size() < 2) {
            QuizEntry q = getRandomEntry();
            if (!(q.equals(quizEntry) || wrongs.contains(q.getAnswer()))) {
                wrongs.add(i, q.getAnswer());
                i++;
            }

        }

        return wrongs;
    }

    public List<QuizEntry> getEntries() {
        return entries;
    }
}
