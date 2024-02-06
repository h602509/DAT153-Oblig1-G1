package com.example.dat153_oblig1_java.quiz_entries;

import java.io.Serializable;

public class EntryModel implements Serializable, Comparable<EntryModel> {

    private Integer imgRef;
    private String answer;

    public EntryModel(Integer imgRef, String answer) {
        this.imgRef = imgRef;
        this.answer = answer;
    }

    public Integer getImage() {
        return imgRef;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public int compareTo(EntryModel e) {
        return this.getAnswer().compareTo(e.getAnswer());
    }
}
