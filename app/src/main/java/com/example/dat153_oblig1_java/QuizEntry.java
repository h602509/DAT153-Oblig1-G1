package com.example.dat153_oblig1_java;

public class QuizEntry {

    private Integer image;
    private String answer;
    private String wrong1;
    private String wrong2;

    public QuizEntry(Integer image, String answer, String wrong1, String wrong2) {
        this.image = image;
        this.answer = answer;
        this.wrong1 = wrong1;
        this.wrong2 = wrong2;
    }

    public Integer getImage() {
        return image;
    }

    public String getAnswer() {
        return answer;
    }

    public String getWrong1() {
        return wrong1;
    }

    public String getWrong2() {
        return wrong2;
    }
}
