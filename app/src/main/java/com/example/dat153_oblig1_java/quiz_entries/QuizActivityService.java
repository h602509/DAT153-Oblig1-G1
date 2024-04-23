package com.example.dat153_oblig1_java.quiz_entries;

import android.net.Uri;

import com.example.dat153_oblig1_java.Database.Entry;
import com.example.dat153_oblig1_java.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizActivityService {

    Entry currentEntry;
    List<Entry> entries;
    List<String> allAlternatives;
    int score;
    int rounds;
    int currentRound;
    int chosenAlternative;

    public QuizActivityService(List<Entry> entries) {

        this.entries = entries;
        allAlternatives = getAllAlternatives();
        currentEntry = popRandomEntry();
        rounds = entriesLeft();
        score = 0;
        currentRound = 1;
        chosenAlternative = -1;
    }

    public Entry popRandomEntry() {
        return entriesLeft() == 0 ? null : entries.remove((int) (Math.random() * (entries.size() - 1)));
    }

    public void goToNextQuestion() {
        currentEntry = popRandomEntry();
    }

    public int entriesLeft() {
        return entries.size();
    }

    public List<String> getAlternatives() {
        List<String> alternatives = new ArrayList<>();
        alternatives.add(currentEntry.getAnswer());
        alternatives.addAll(getWrongs());
        Collections.shuffle(alternatives);
        return alternatives;
    }

    public int getNumberOfRounds() {
        return allAlternatives.size();
    }

    private List<String> getAllAlternatives() {
        List<String> all = new ArrayList<>();
        entries.forEach(x -> all.add(x.getAnswer()));
        return all;
    }

    private List<String> getWrongs() {
        List<String> wrongs = new ArrayList<>();
        while (wrongs.size() < 2) {
            Random r = new Random();
            String wrong = allAlternatives.get(r.nextInt(allAlternatives.size()));
            if (!wrongs.contains(wrong) && !wrong.equals(currentEntry.getAnswer())) {
                wrongs.add(wrong);
            }
        }
        return wrongs;
    }

    public boolean isFinished() {
        return entriesLeft() == 0;
    }


    public Uri getCurrentImgRef() {
        return currentEntry.getImgUri();
    }

    public String getCurrentAnswer() {
        return currentEntry.getAnswer();
    }

    public void setChosenAlternative(int chosenAlternative) {
        this.chosenAlternative = chosenAlternative;
    }

    public int getChosenAlternative() { return chosenAlternative; }

    public void addScore() { score++; }

    public int getScore() { return score; }

    public void addCurrentRoundCounter() { currentRound++; }

    public int getCurrentRound() { return currentRound; }
}
